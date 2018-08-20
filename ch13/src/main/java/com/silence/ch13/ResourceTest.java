package com.silence.ch13;

import java.io.InputStream;
import java.util.Scanner;

public class ResourceTest {
    public static void main( String[] args ) {
        InputStream stream = Main.class.getResourceAsStream("/about.txt");
        try(Scanner in = new Scanner(stream, "UTF-8")) {
            while(in.hasNext()) {
                System.out.println(in.next());
            }
        }

        stream = Main.class.getResourceAsStream("about.txt");
        try(Scanner in = new Scanner(stream, "UTF-8")) {
            while(in.hasNext()) {
                System.out.println(in.next());
            }
        }
    }
}
