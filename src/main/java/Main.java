import Service.InventoryManagerFunction;
import Design.Design;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            Design.DesignLOGO();
            System.out.print("""
                1) Sign Up
                2) Log In
                3) Exit
                Enter your option:
                """);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    InventoryManagerFunction.signUp();
                    break;
                case 2:
                    InventoryManagerFunction.getLogin();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

}
