import Design.Design;
import Service.ProductMenuFunction;
import Service.SupplierMenuFunction;
import Service.poMenuFunction;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            Design.DesignLOGO();
            System.out.print("""
                    1) Supplier Menu
                    2) Product Listing
                    6) Exit
                    Enter your option:""");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    SupplierMenuFunction.supplierManagement();
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
