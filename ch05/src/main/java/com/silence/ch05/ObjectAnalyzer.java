package com.silence.ch05;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {
        if(obj == null) {
            return "null";
        }
        if(visited.contains(obj)) {
            return "...";
        }
        Class clazz = obj.getClass();
        if(clazz == String.class) {
            return (String) obj;
        }
        if(clazz.isArray()) {
            String text = clazz.getComponentType().toString();
            text  += "[]{";
            for(int i = 0; i < Array.getLength(obj); ++i) {
                if(i > 0) {
                    text += ",";
                }
                Object value = Array.get(obj, i);
                if(clazz.getComponentType().isPrimitive()) {
                    text += value;
                } else {
                    text += toString(value);
                }
            }
            text += "}";
            return text;
        } else {
            String text = clazz.getName();
            do {
                text += "[";
                Field[] fields = clazz.getDeclaredFields();
                AccessibleObject.setAccessible(fields, true);
                for(Field field : fields) {
                    if(!Modifier.isStatic(field.getModifiers())) {
                        if(!text.endsWith("[")) {
                            text += ",";
                        }
                        text += field.getName();
                        text += "=";
                        try {
                            Class t = field.getType();
                            Object value = field.get(obj);
                            if(t.isPrimitive()) {
                                text += value;
                            } else {
                                text += toString(value);
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                text += "]";
                clazz = clazz.getSuperclass();
            } while(clazz != null);

            return text;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 10; ++i) {
           list.add(i);
        }

        System.out.println(new ObjectAnalyzer().toString(list));
    }
}