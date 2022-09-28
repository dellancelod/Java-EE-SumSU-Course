package entities;

public class Employee {
    protected String name;
    protected String departmentName;
    protected double salary;
    protected int id;
    protected int managerId;

    public Employee(String name,
                    String departmentName,
                    double salary,
                    int id,
                    int managerId){
        this.name = name;
        this.departmentName = departmentName;
        this.salary = salary;
        this.id = id;
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public int getManagerId() {
        return managerId;
    }

    public void writeInfo(){
        System.out.println("Name: " + name + "\n\t" +
                        "Department: " + departmentName + "\n\t" +
                        "Salary: " + salary + "\n\t" +
                        "ID: " + id + "\n\t" +
                        "Manager ID: " + managerId + "\n"
                );
    }
}
