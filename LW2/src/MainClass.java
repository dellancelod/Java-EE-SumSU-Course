import entities.Employee;
import entities.Manager;
import entities.WorkersRegistry;
import exceptions.EmployeeInRegistryException;

public class MainClass {
    public static void main(String[] args) {
        WorkersRegistry registry = WorkersRegistry.getRegistry();
        Employee employee1 = new Employee("John Wick", "IT", 12000, 333, 12);
        Employee employee2 = new Employee("Tom Shelby", "IT", 15000, 123, 12);
        Employee employee3 = new Manager("Maria Petrenko", "Sales", 19000, 10, 1, 3000);
        Employee employee4 = new Manager("Bebra Bebrov", "IT", 18000, 12, 1, 1000);


        try {
            registry.registerNewEmployee(employee1);
            registry.registerNewEmployee(employee2);
            registry.registerNewEmployee(employee3);
            registry.registerNewEmployee(employee4);

            //EmployeeRegistryException will be thrown
            registry.registerNewEmployee(employee1);
        } catch (EmployeeInRegistryException e) {
            e.printStackTrace();
        }
        registry.printList();
    }
}
