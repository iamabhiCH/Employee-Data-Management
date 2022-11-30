// Main class for performing whole operations in one class because you don't need to perform all operations individually.

import java.sql.Connection;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("\t\t\t\t\t Welcome in HARE KRISHANA Solutions");
                System.out.println("----------------------------------------------------------------------------------\n");
                System.out.println("This page is for manage the details of our employees");
                System.out.println("1. Add new employee \t 2. Display the details of all employees");
                System.out.println("3. Delete the employee data \t4. Update the employee data \n5. Quit from this page");
                System.out.print("Enter your choice : ");
                EmployeeInfo ei = new EmployeeInfo();
                Scanner t = new Scanner(System.in);
                int ch = t.nextInt();

                switch (ch) {
                    case 1:
                        ei.InsertInfo();
                        break;
                    case 2:
                        // Call function for display the details of employees
                        System.out.println("Employee Details..............\n");
                        ei.DisplayDetails();
                        break;
                    case 3:
                        // call function for delete the employee data
                        ei.DeleteInfo();
                        System.out.println("Data deleted........");
                        break;
                    case 4:
                        // Call the function for Update the employee details
                        ei.UpdateInfo();
                        break;
                    case 5:
                        System.out.println("Thanks for visiting.........");
                        break;
                    default:
                        System.out.println("Invalid choice....");
                        break;
                }
        }
}