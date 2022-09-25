import exceptions.FieldLenghtLimitException;
import exceptions.IncorrectSalaryException;

public class Employee {
    private final int NAME_SIZE = 10;
    private int id;
    private static int nextId = 0;
    private String name;
    private String surname;
    private double salary;

    public Employee(){
        this.id = nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws FieldLenghtLimitException{
        if(name.length() < NAME_SIZE){
            this.name = name;
        }
        else{
            throw new FieldLenghtLimitException("Name length must be less than " + NAME_SIZE);
        }
    }

    public int getId(){
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws IncorrectSalaryException{
        if(salary >= 0){
            this.salary = salary;
        }
        else {
            throw new IncorrectSalaryException("Salary can't be negative number");
        }
    }
    public void showInformation(){
        System.out.println(name + surname);
        System.out.println("\tSalary: " + salary);
    }
}
