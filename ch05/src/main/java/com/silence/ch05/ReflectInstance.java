package com.silence.ch05;

import java.lang.reflect.Field;

public class ReflectInstance {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException{
        Student student = new Student("KK", "computer");
        Class clazz = student.getClass();
        Field major = clazz.getDeclaredField("major");
        major.setAccessible(true);
        Object value = major.get(student);
        System.out.println(value);
    }
}