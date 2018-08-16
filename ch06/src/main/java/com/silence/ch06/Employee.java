package com.silence.ch06;

import java.util.Arrays;

public class Employee implements Comparable<Employee>, Cloneable, INamed, IAged {
    private String name = "";
    private int age = 0;

    public Employee() {}

    public Employee(String aName, int aAge) {
        name = aName;
        age = aAge;
    }

    public int compareTo(Employee other) {
        return Integer.compare(age, other.age);
    }

    @Override
    public String toString() {
        return getClass().getName()
            + "[name=" + name + "]"
            + "[age=" + age + "]";
    }

	@Override
	public String getName() {
		return name;
	}
	

	@Override
	public void setAge(int aAge) {
		age = aAge;
	}
	
	public Employee clone() throws CloneNotSupportedException {
		return (Employee)super.clone();
	}

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee[] employee = new Employee[3];
        employee[0] = new Employee("kk", 30);
        employee[1] = new Employee("silence", 33);
        employee[2] = new Employee("null", 31);

        System.out.println(Arrays.toString(employee));
        Arrays.sort(employee);
        System.out.println(Arrays.toString(employee));

        for(Employee e : employee) {
            System.out.println(e.getName() + ":" + e.getAge());
        }
        System.out.println(IConstans.getPackage());
        System.out.println(IConstans.PACKAGE);
        
        Employee me = new Employee("kk", 30);
        Employee me2 = me;
        Employee me3 = me.clone();
        
        me2.setAge(31);
        System.out.println(me);
        System.out.println(me2);
        me3.setAge(32);
        System.out.println(me);
        System.out.println(me3);
    }


}