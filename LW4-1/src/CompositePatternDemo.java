import Model.Employee;

public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee boss = new Employee("Danil", "CEO", 30000, 1);

        Employee salesBoss = new Employee("Ivan", "Sales", 1000, boss.getId());
        Employee marketingBoss = new Employee("Natalia", "Marketing", 1000, boss.getId());

        boss.add(salesBoss, marketingBoss);

        Employee employeeSales1 = new Employee("Vladislav", "Sales", 800, salesBoss.getId());
        Employee employeeSales2 = new Employee("Dmitriy", "Sales", 200, salesBoss.getId());
        Employee employeeSales3 = new Employee("Vladimir", "Sales", 300, salesBoss.getId());
        Employee employeeSales4 = new Employee("Vitaliy", "Sales", 400, salesBoss.getId());

        salesBoss.add(employeeSales1, employeeSales2, employeeSales3, employeeSales4);

        Employee employeeMarketing1 = new Employee("Chad", "Marketing", 780, marketingBoss.getId());
        Employee employeeMarketing2 = new Employee("Bob", "Marketing", 700, marketingBoss.getId());
        Employee employeeMarketing3 = new Employee("Jimmy", "Marketing", 60, marketingBoss.getId());
        Employee employeeMarketing4 = new Employee("Jane", "Marketing", 700, marketingBoss.getId());

        marketingBoss.add(employeeMarketing1, employeeMarketing2, employeeMarketing3, employeeMarketing4);

        System.out.println("~~~ Company human resources before downsizing ~~~");
        boss.printSubordinateTree();

        System.out.println("\n\n\n");
        System.out.println("~~~ Sales department ~~~");
        salesBoss.printSubordinateTree();

        boss.remove(salesBoss);

        System.out.println("\n\n\n");
        System.out.println("~~~ Company human resources after downsizing ~~~");

        boss.printSubordinateTree();
    }
}