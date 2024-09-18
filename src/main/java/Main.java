import Service.InventoryManagerMenu;
import Service.StaffMenu;
import Design.Design;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        int choice;
        do {
            Design.DesignLOGO();
            System.out.print("""
        1) Inventory Manager
        2) Staff
        3) Exit
        Enter your option:""");

            Scanner sc = new Scanner(System.in);

            // Check if the input is an integer
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        InventoryManagerMenu.InventoryManagerMenu(choice); // Call mainMenu for Inventory Manager
                        break;
                    case 2:
                        StaffMenu.staffMenu(choice); // Call mainMenu for Staff
                        break;
                    case 3:
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("***Invalid choice! Please try again...***");
                        break;
                }
            } else {
                System.out.println("***Invalid input! Please enter a valid number...***");
                sc.next(); // Clear the invalid input
                choice = -1; // Set choice to an invalid number to continue the loop
            }
        } while (choice != 3);

    }
}
