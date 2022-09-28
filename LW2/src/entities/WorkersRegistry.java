package entities;
import exceptions.EmployeeInRegistryException;

import java.util.ArrayList;
import java.util.List;

public class WorkersRegistry {
    private static WorkersRegistry singleRegistry;
    private List<Employee> workers;

    private WorkersRegistry(){
        workers = new ArrayList<>();
    }

    public static WorkersRegistry getRegistry() {
        if(singleRegistry == null){
            singleRegistry = new WorkersRegistry();
        }
        return singleRegistry;
    }

    public void registerNewEmployee(Employee employee) throws EmployeeInRegistryException {
        if(workers.contains(employee)){
            throw new EmployeeInRegistryException("The employee "
                    + employee.getId() + " already exists!");
        }
        workers.add(employee);
    }

    public void printList(){
        for(Employee employee : workers){
            employee.writeInfo();
        }
    }
}
