package Service;

import java.util.Scanner;

public class SupplierMenuFunction {
    public static void supplierManagement() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        int choice;
        do {
            System.out.println("\n************************************");
            System.out.println("\t\tSuppliers Management");
            System.out.println("************************************");
            System.out.println("1. Add Supplier");
            System.out.println("2. Search Supplier");
            System.out.println("3. Modify Supplier");
            System.out.println("4. Remove Supplier");
            System.out.println("5. Display All Suppliers");
            System.out.println("6. Exit Suppliers Management");
            System.out.print("Please enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    SupplierManagementFunction.createSupplier();
                    break;
                case 2:
                    SupplierManagementFunction.readSupplier();
                    break;
                case 3:
                    SupplierManagementFunction.updateSupplier();
                    break;
                case 4:
                    SupplierManagementFunction.deleteSupplier();
                    break;
                case 5:
                    SupplierManagementFunction.displaySuppliers();
                    break;
                case 6:
                    //Main.main(null);
                    break;
                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }
        } while (choice != 6);

    }
}
