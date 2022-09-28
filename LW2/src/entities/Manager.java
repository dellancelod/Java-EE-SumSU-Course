package entities;

public class Manager extends Employee{
    private double bonus;

    public Manager(String name,
                   String departmentName,
                   double salary,
                   int id,
                   int managerId, double bonus){
        super(name, departmentName, salary, id, managerId);
        this.bonus = bonus;
    }
    public double getBonus() {
        return bonus;
    }

    @Override
    public void writeInfo(){
        System.out.println("Name: " + name + "\n\t" +
                "Department: " + departmentName + "\n\t" +
                "Salary: " + salary + "\n\t" +
                "ID: " + id + "\n\t" +
                "Manager ID: " + managerId + "\n\t" +
                "Bonus: " + bonus + "\n"
        );
    }
}
