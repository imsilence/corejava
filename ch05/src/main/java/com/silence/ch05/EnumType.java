package com.silence.ch05;

import java.util.Arrays;

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String desc;

    private Size(String aDesc) {
        desc = aDesc;
    }

    public String getDesc() {
        return desc;
    }

}

public class EnumType {
    public static void main(String[] args) {
        Size s = Enum.valueOf(Size.class, "SMALL");
        System.out.println(s);
        System.out.println(s.ordinal());
        System.out.println(Arrays.toString(Size.values()));

    }
}