import Service.InventoryManagerDAO;
import Design.Design;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            Design.DesignLOGO();
            System.out.println("""
                1) Sign Up
                2) Log In 
                3) Exit      
                Enter your option: """);
            int option = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    InventoryManagerDAO.signUp();
                    break;
                case 2:
                    InventoryManagerDAO.loginFunction();
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
