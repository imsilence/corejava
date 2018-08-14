package com.silence.ch05;


import java.util.Objects;

public abstract class Person {
    private String name = "";

    public Person(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();

    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }
        if(other == null) {
            return false;
        }
        if(other.getClass() != getClass()) {
            return false;
        }

        Person person = (Person) other;
        return name.equals(person.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return getClass().getName()
            + "[name=" + name + "]";
    }
}