package com.silence.ch05;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayExtends {

    public static Object copyOf(Object array, int length) {
        Class clazz = array.getClass();
        if(!clazz.isArray()) {
            return null;
        }
        Class componentType = clazz.getComponentType();
        int array_length = Array.getLength(array);
        Object array_new = Array.newInstance(componentType, length);
        System.out.println(length);
        System.out.println(array_length);
        System.out.println(Math.min(length, array_length));
        System.arraycopy(array, 0, array_new, 0, Math.min(length, array_length));
        return array_new;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5, 7, 8, 9, 1};
        int[] new_nums = (int[]) copyOf(nums, 3);
        System.out.println(Arrays.toString(new_nums));
        String[] names = new String[] {"kk", "silence"};
        String[] new_names = (String[]) copyOf(names, 3);
        System.out.println(Arrays.toString(new_names));
    }
}