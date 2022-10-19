package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
    private static int nextEmployeeId;

    private int id;
    private int idBoss;
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary, int idBoss){
        id = nextEmployeeId;
        nextEmployeeId++;
        this.idBoss = idBoss;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void add(Employee... employees) {
        subordinates.addAll(Arrays.asList(employees));
    }

    public void remove(Employee employee) {
        subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString(){
        return "Employee: " + "\t" +
                "ID = " + id + "\t" +
                "Boss ID = " + idBoss + "\t" +
                "Name = \033[3m" + name + "\033[0m\t" +
                "Department = " + dept + "\t" +
                "salary = " + salary;
    }

    public void printSubordinateTree() {
        printSubordinateTree(0);
    }

    private void printSubordinateTree(int height) {
        for (int i = 0; i < height; i++) {
            System.out.print("\t\t\t\t");
        }
        System.out.println(Integer.toString(height) + ": " + this);
        for (Employee employee : getSubordinates()) {
            employee.printSubordinateTree(height + 1);
        }
    }
}
