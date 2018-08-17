package com.silence.ch08;

import java.time.LocalDate;
import java.util.Arrays;

public class ArrayAlg2 {
    public static class Pair<T> {
        private T min = null;
        private T max = null;

        public Pair() {
            min = null;
            max = null;
        }

        public Pair(T aMin, T aMax) {
            min = aMin;
            max = aMax;
        }

        public void setMax(T aMax) {
            max = aMax;
        }

        public void setMin(T aMin) {
            min = aMin;
        }

        public T getMax() {
            return max;
        }

        public T getMin() {
            return min;
        }

        public String toString() {
            return getClass().getName()
                + "[min=" + min + "]"
                + "[max=" + max + "]";
        }
    }

    public static class DatePair extends Pair<LocalDate> {
        public void setMax(LocalDate aMax) {
        	super.setMax(aMax);
        }
        
        public LocalDate getMax() {
        	return super.getMax();
        }
    }
 
    public static <T> T[] array(T... ts) {
    	return ts;
    }


	public static void main(String[] args) {
    	Pair<LocalDate> pair = new DatePair();
    	pair.setMax(LocalDate.now());
    	System.out.println(pair.getMax());
    	
    	System.out.println(new Pair<Integer>().getClass().getName());
    	System.out.println(new Pair<String>().getClass().getName());
    	
    	Pair<String>[] pairs = (Pair<String>[]) new Pair<?>[2];
    	pairs[0] = new Pair<String>("1", "2");
    	
    	System.out.println(pairs[0].getMax());

    	System.out.println(Arrays.toString(array(1, 2, 3, "string")));
    }
}