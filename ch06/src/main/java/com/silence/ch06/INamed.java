package com.silence.ch06;

public interface INamed {
    default String getName() {
        return "";
    };
}