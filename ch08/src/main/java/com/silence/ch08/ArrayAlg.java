package com.silence.ch08;


public class ArrayAlg {
    public static class Pair<T extends Comparable<T>> {
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


    public static <T extends Number> T getMiddle(T[] array) {
        return array[array.length / 2];
    }

    public static <T extends Comparable<T>> Pair<T> minmax(T[] array) {
        if(array == null || array.length == 0) {
            return null;
        }

        T min = array[0];
        T max = array[0];

        for(int i = 1; i < array.length; ++i) {
            if(min.compareTo(array[i]) > 0) {
                min = array[i];
            }
            if(max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return new Pair<T>(min, max);
    }


    public static void main(String[] args) {
    	Integer[] array = new Integer[] {1, 2, 3, 4, 5};

        System.out.println(ArrayAlg.<Integer>getMiddle(array));


        Pair<Integer> pair = minmax(array);
        System.out.println(pair);
    }
}