import Service.UserMenuFunction;
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
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    UserMenuFunction.mainMenu(choice);
                    break;
                case 2:
                    UserMenuFunction.mainMenu(choice);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }
        } while (choice != 3);

    }

}
