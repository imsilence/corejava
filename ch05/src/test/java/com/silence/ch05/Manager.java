package com.silence.ch05;


public class Manager extends Employee {
    private double bonus = 0;

    public Manager(String aName, double aSalary, double aBonus, int aYear, int aMonth, int aDay) {
        super(aName, aSalary, aYear, aMonth, aDay);
        bonus = aBonus;
    }

    public void setBonus(double aBonus) {
        bonus = aBonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public static void main(String[] args) {
        Manager manager = new Manager("null", 1000, 300, 2018, 1, 1);
        System.out.println(manager.getSalary());

        Employee[] staff = new Employee[2];
        staff[0] = manager;
        staff[1] = new Employee("silence", 2000, 1985, 11, 1);

        for(Employee e: staff) {
            System.out.println("name: " + e.getName() + " , salary: " + e.getSalary() + " , hire day: " + e.getHireDay());
        }
    }
}