package com.silence.ch05;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class ReflectMethod {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Student student = new Student("KK", "computer");
        Class clazz = student.getClass();
        Method method = clazz.getMethod("getDescription");
        String result = (String) method.invoke(student);
        System.out.println(result);


        Method sqrt = Math.class.getDeclaredMethod("sqrt", double.class);
        double sqrt_result = (Double) sqrt.invoke(null, 9.0);
        System.out.println(sqrt_result);
    }
}