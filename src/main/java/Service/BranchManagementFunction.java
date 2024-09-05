package Service;

import Entity.Branch;

import java.util.Scanner;

public class BranchManagementFunction {
    public static Scanner sc = new Scanner(System.in);

    //Add Branch
    public static void createBranch() {
        String confirm;

        System.out.println("\n************************************");
        System.out.println("\t\t  Create Branch");
        System.out.println("************************************");
        System.out.println("Please enter the details of the branch:");
        do {
            Branch branch = new Branch();

            System.out.println("Branch location: ");
            branch.setBranchLocation(sc.nextLine());
            System.out.println("Branch phone number: ");
            branch.setBranchPhoneNo(sc.nextLine());
            System.out.println("Branch manager name: ");
            branch.setBranchMgrName(sc.nextLine());

            System.out.println("CONFIRM to CREATE new branch?");
            confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                //TODO: AHTAN ADD IN NEW BRANCH TO DATABASE
                System.out.println("***Branch created successfully!***");
            } else
                System.out.println("***Branch NOT create successfully***");

            System.out.println("Continue to create another branch?: ");
            confirm = sc.nextLine();
        } while (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes"));
    }

    //Search Branch
    public static void readBranch() {
        String confirm;
        int choice;

        System.out.println("\n************************************");
        System.out.println("\t\t  Search Branch");
        System.out.println("************************************");
        do {
            Branch branch = null;

            System.out.println("Searching to view branch details:");
            System.out.println("1. Branch ID: ");
            System.out.println("2. Branch location: ");
            System.out.println("Search branch by: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter branch ID to search: ");
                    //TODO: AHTAN COMPARE THE USER INPUT WITH THE BRANCH ID IN DATABASE
                    break;

                case 2:
                    System.out.println("Enter branch location to search: ");
                    //TODO: AHTAN COMPARE THE USER INPUT WITH THE BRANCH LOCATION IN DATABASE
                    break;

                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (branch == null)
                System.out.println("***Branch NOT found!***");
            else
                System.out.println(branch);

            System.out.println("Continue to search another branch?: ");
            confirm = sc.nextLine();
        } while (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes"));
    }

}
