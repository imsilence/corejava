
package com.silence.ch05;

import java.util.Objects;

public class Student extends Person {
    private String major;

    public Student(String aName, String aMajor) {
        super(aName);
        major = aMajor;
    }

    public String getDescription() {
        return "student, name: " + getName() + ", in major: " + major;
    }

    public boolean equals(Object other) {
        if(!super.equals(other)) {
            return false;
        }

        Student student = (Student) other;
        return major.equals(student.major);
    }

    public int hashCode() {
        return Objects.hash(getName(), major);
    }

    public String toString() {
        return super.toString()
                + "[major=" + major + "]";
    }

    public static void main(String[] args) {
        Person s = new Student("KK", "computer");
        Person s2 = new Student("KK2", "computer");
        Person s3 = new Student("KK2", "computer");
        Person s4 = new Student("KK2", "math");
        System.out.println(s.getDescription());
        System.out.println(s.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s2.equals(s4));
        System.out.println(s);

    }
}