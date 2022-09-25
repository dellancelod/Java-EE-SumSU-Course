import exceptions.FieldLenghtLimitException;
import exceptions.IncorrectSalaryException;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("~~~ Employee creator ~~~");

        Scanner input = new Scanner(System.in);
        Employee worker = new Employee();

        try{
            System.out.print("Enter name of employee >> ");
            worker.setName(input.next());
        }
        catch (FieldLenghtLimitException e){
            System.out.println("Exception: " + e.getMessage());
            System.exit(1);
        }
        System.out.print("Enter surname of employee >> ");
        worker.setSurname(input.next());

        try{
            System.out.print("Enter employee salary >> ");
            worker.setSalary(Integer.parseInt(input.next()));
        }
        catch (IncorrectSalaryException e){
            System.out.println("Exception: " + e.getMessage());
            System.exit(1);
        }

    }
}
