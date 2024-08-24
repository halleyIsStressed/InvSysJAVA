import Design.Design;
import Service.InventoryManagerFunction;
import Service.ProductMenuFunction;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            Design.DesignLOGO();
            System.out.print("""
                    1) Add
                    2) Listing
                    3) Exit
                    Enter your option:
                    """);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    ProductMenuFunction.addProduct();
                    break;
                case 2:
                    ProductMenuFunction.productListing();
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
