package Service;

import java.io.IOException;
import java.util.Scanner;

public class BranchMenuFunction {
    public static void branchManagement() throws IOException {
        int choice;
        do {
            System.out.println("\n************************************");
            System.out.println("\t\tBranches Management");
            System.out.println("************************************");
            System.out.println("1. Add Branch");
            System.out.println("2. Search Branch");
            System.out.println("3. Modify Branch");
            System.out.println("4. Close Branch");
            System.out.println("5. Display All Branches");
            System.out.println("6. Exit Branches Management");
            System.out.println("Please enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    BranchManagementFunction.createBranch();
                    break;
                case 2:
                    BranchManagementFunction.readBranch();
                    break;
                case 3:
                    BranchManagementFunction.updateBranch();
                    break;
                case 4:
                    BranchManagementFunction.deleteBranch();
                    break;
                case 5:
                    BranchManagementFunction.displayBranches();
                    break;
                case 6:

                    break;
                default:
                    System.out.println("***Invalid choice! Please try again...***");
                    System.in.read();
            }
        } while (choice != 0);
    }
}