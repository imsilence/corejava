
public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[2];
        staff[0] = new Employee("kk", 1000, 1987, 10, 1);
        staff[1] = new Employee("silence", 2000, 1985, 11, 1);

        staff[0].raiseSalary(5);
        staff[1].raiseSalary(7);

        for(Employee e : staff) {
            System.out.println("name: " + e.getName() + " , salary: " + e.getSalary() + " , hire day: " + e.getHireDay());
        }
    }
}
