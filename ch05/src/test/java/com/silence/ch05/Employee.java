package com.silence.ch05;

import java.time.LocalDate;

public class Employee {
    private String name = "";
    private double salary = 0.0D;
    private LocalDate hireDay = null;


    public Employee(String aName, double aSalary, int aYear, int aMonth, int aDay) {
        name = aName;
        salary = aSalary;
        hireDay = LocalDate.of(aYear, aMonth, aDay);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double precent) {
        double raise = salary * precent / 100;
        salary += raise;
    }

}
