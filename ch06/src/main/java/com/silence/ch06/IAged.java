package com.silence.ch06;

public interface IAged {
    default int getAge() {
        return 0;
    }
    
    void setAge(int aAge);
    
}