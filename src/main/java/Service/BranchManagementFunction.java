package Service;

import DAO.BranchMapper;
import DAO.PurchaseOrderMapper;
import Database.Database;
import Entity.Branch;
import Entity.Purchase_Order;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
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

    //Modify Branch
    public static void updateBranch() {
        String confirm;
        int choice;
        int category;
        System.out.println("\n************************************");
        System.out.println("\t\t  Update Branch");
        System.out.println("************************************");
        do {
            Branch branch = null;

            System.out.println("1. Branch ID");
            System.out.println("2. Branch location");
            System.out.println("Search branch to update by: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter branch ID to update: ");
                    //TODO: AHTAN COMPARE THE USER INPUT WITH THE BRANCH ID IN THE DATABASE
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                        branch = branchMapper.selectById(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Enter branch location to update: ");
                    //TODO: AHTAN COMPARE USER INPUT WITH THE BRANCH LOCATION IN THE DATABASE
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                        branch = branchMapper.selectByLocation(sc.nextLine());
                    }
                    break;
                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (branch == null)
                System.out.println("***Branch NOT found!***");
            else {
                System.out.println("1. Branch location");
                System.out.println("2. Branch phone number");
                System.out.println("3. Branch manager name");
                System.out.println("4. ALL");
                System.out.println("Please select the category you would like to update: ");
                category = sc.nextInt();
                sc.nextLine();
                switch (category) {
                    case 1:
                        System.out.println("Enter the new Branch location: ");
                        branch.setBranchLocation(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter the new Branch phone number: ");
                        branch.setBranchPhoneNo(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter the new Branch manager name: ");
                        branch.setBranchMgrName(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter the new Branch location");
                        branch.setBranchLocation(sc.nextLine());
                        System.out.println("Enter the new Branch phone number: ");
                        branch.setBranchPhoneNo(sc.nextLine());
                        System.out.println("Enter the new Branch manager name: ");
                        branch.setBranchMgrName(sc.nextLine());
                        break;
                    default:
                        System.out.println("***Invalid category! Please try again...***");
                }
                //Prompt user for confirmation
                System.out.println("Updated details:");
                System.out.println(branch);
                System.out.println("CONFIRM to UPDATE these changes?: ");
                confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                    if (choice == 1) {
                        //TODO: AHTAN UPDATE THE BRANCH BY ID

                    } else {
                        //TODO: AHTAN UPDATE THE BRANCH BY LOCATION

                    }

                    System.out.println("***Changes saved successfully!***");
                } else
                    System.out.println("***Changes DISCARDED! Branch details reverted to original.***");
            }

            System.out.println("Continue to update branch's details?: ");
            confirm = sc.nextLine();
        } while (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes"));
    }

    //Close Branch
    public static void deleteBranch() {
        String confirm;
        int choice;
        System.out.println("\n************************************");
        System.out.println("\t\t  Delete Branch");
        System.out.println("************************************");
        do {
            Branch branch = null;

            System.out.println("1.Branch ID");
            System.out.println("2. Branch location");
            System.out.println("Search branch to delete by: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter branch ID to delete: ");
                    //TODO: AHTAN SELECT BRANCH BY ID
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                        branch = branchMapper.selectById(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Enter branch location to delete: ");
                    //TODO: AHTAN SELECT BRANCH BY LOCATION
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                        branch = branchMapper.selectByLocation(sc.nextLine());
                    }
                    break;
                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (branch == null)
                System.out.println("***Branch NOT found!***");
            else {
                System.out.println(branch);
                System.out.println("CONFIRM to DELETE this branch?: ");
                confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                    //TODO: AHTAN DELETE THE BRANCH BY ID
                    // TODO DONE
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                       branchMapper.deleteById(branch.getBranchID());
                       conn.commit();
                    }

                    System.out.println("***Branch deleted successfully!***");
                } else
                    System.out.println("***Branch NOT delete successfully!***");
            }

            System.out.println("Continue to delete branch?: ");
            confirm = sc.nextLine();
        } while (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes"));
    }

    //Display all branches
    public static void displayBranches() {
        System.out.println("\n************************************");
        System.out.println("\t\tDisplay All Branches");
        System.out.println("************************************");

        //TODO: AHTAN SELECT ALL BRANCHES FROM DATABASE
        // TODO DONE
        List<Branch> branchList;
        try (SqlSession conn = Database.getInstance().openSession()) {
            BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
            branchList = branchMapper.selectAll();
        }

       if (branchList.isEmpty())
           System.out.println("***No branch found!***");
        else
          for (Branch b : branchList)
               System.out.println(b);

            System.out.println("Press Enter to return back to the Branch Management Menu: ");
            sc.nextLine();
    }

}
