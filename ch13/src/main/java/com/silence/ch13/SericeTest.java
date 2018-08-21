package com.silence.ch13;

import java.util.ServiceLoader;

import com.silence.ch13.serviceloader.IService;

public class SericeTest {
    public static void main(String[] args) {
        ServiceLoader<IService> loader = ServiceLoader.load(IService.class);
        for(IService serice : loader) {
            System.out.println(serice.getScheme());
            System.out.println(serice.say());
        }
    }
}
