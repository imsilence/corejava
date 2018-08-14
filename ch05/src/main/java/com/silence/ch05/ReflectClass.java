package com.silence.ch05;

import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectClass {

    public static void main(String[] args) {
        for(String className : args) {
            try {
                Class clazz = Class.forName(className);
                Class superClazz = clazz.getSuperclass();


                String modifiers = Modifier.toString(clazz.getModifiers());
                if(modifiers.length() > 0) {
                    System.out.print(modifiers + " ");
                }
                System.out.print("class " + clazz.getName());

                if(superClazz != null && superClazz != Object.class) {
                    System.out.print(" extends " + superClazz.getName());
                }

                System.out.println(" {");
                Field[] fields = clazz.getDeclaredFields();
                for(Field field : fields) {
                    System.out.print("\t");
                    String fieldModifiers = Modifier.toString(field.getModifiers());
                    if(fieldModifiers.length() > 0) {
                        System.out.print(fieldModifiers + " ");
                    }
                    System.out.println(field.getType() + " " + field.getName() + ";");
                }

                Constructor[] constructors = clazz.getDeclaredConstructors();
                for(Constructor constructor : constructors) {
                    System.out.print("\t");
                    String constructorModifiers = Modifier.toString(constructor.getModifiers());
                    if(constructorModifiers.length() > 0) {
                        System.out.print(constructorModifiers + " ");
                    }
                    System.out.print(constructor.getName() + "(");
                    Class[] paramTypes = constructor.getParameterTypes();
                    for(int i=0; i < paramTypes.length; ++i) {
                        if(i != 0) {
                            System.out.print(", ");
                        }
                        System.out.print(paramTypes[i].getName());
                    }
                    System.out.println(");");
                }

                Method[] methods = clazz.getDeclaredMethods();
                for(Method method : methods) {
                    System.out.print("\t");
                    String methodModifiers = Modifier.toString(method.getModifiers());
                    if(methodModifiers.length() > 0) {
                        System.out.print(methodModifiers + " ");
                    }
                    System.out.print(method.getReturnType().getName() + " " + method.getName() + "(");
                    Class[] paramTypes = method.getParameterTypes();
                    for(int i=0; i < paramTypes.length; ++i) {
                        if(i != 0) {
                            System.out.print(", ");
                        }
                        System.out.print(paramTypes[i].getName());
                    }
                    System.out.println(");");
                }
                System.out.println("}");
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}