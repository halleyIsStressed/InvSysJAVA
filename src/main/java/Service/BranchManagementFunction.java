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

            System.out.print("Branch location: ");
            branch.setBranchLocation(sc.nextLine());
            System.out.print("Branch phone number: ");
            branch.setBranchPhoneNo(sc.nextLine());
            System.out.print("Branch manager name: ");
            branch.setBranchMgrName(sc.nextLine());

            System.out.print("CONFIRM to CREATE new branch?");
            confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                try (SqlSession conn = Database.getInstance().openSession()) {
                    BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                    branchMapper.insertNewBranch(branch);
                    conn.commit();
                }
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
            System.out.print("Search branch by: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter branch ID to search: ");
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                        branch = branchMapper.selectById(sc.next());
                    }
                    break;

                case 2:
                    System.out.print("Enter branch location to search: ");
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                        branch = branchMapper.selectByLocation(sc.next());
                    }
                    break;

                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (branch == null)
                System.out.println("***Branch NOT found!***");
            else
                System.out.println(branch);

            System.out.print("Continue to search another branch?: ");
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
            System.out.print("Search branch to update by: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter branch ID to update: ");
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                        branch = branchMapper.selectById(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.print("Enter branch location to update: ");
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
                System.out.print("Please select the category you would like to update: ");
                category = sc.nextInt();
                sc.nextLine();
                switch (category) {
                    case 1:
                        System.out.print("Enter the new Branch location: ");
                        branch.setBranchLocation(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter the new Branch phone number: ");
                        branch.setBranchPhoneNo(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter the new Branch manager name: ");
                        branch.setBranchMgrName(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Enter the new Branch location");
                        branch.setBranchLocation(sc.nextLine());
                        System.out.print("Enter the new Branch phone number: ");
                        branch.setBranchPhoneNo(sc.nextLine());
                        System.out.print("Enter the new Branch manager name: ");
                        branch.setBranchMgrName(sc.nextLine());
                        break;
                    default:
                        System.out.println("***Invalid category! Please try again...***");
                }
                //Prompt user for confirmation
                System.out.println("Updated details:");
                System.out.println(branch);
                System.out.print("CONFIRM to UPDATE these changes?: ");
                confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                    if (choice == 1) {
                        try (SqlSession conn = Database.getInstance().openSession()) {
                            BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                            branchMapper.updateById(branch);
                            conn.commit();
                        }
                    } else {
                        try (SqlSession conn = Database.getInstance().openSession()) {
                            BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                            branchMapper.updateByLocation(branch);
                            conn.commit();
                        }
                    }

                    System.out.println("***Changes saved successfully!***");
                } else
                    System.out.println("***Changes DISCARDED! Branch details reverted to original.***");
            }

            System.out.print("Continue to update branch's details?: ");
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
            System.out.print("Search branch to delete by: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter branch ID to delete: ");
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                        branch = branchMapper.selectById(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.print("Enter branch location to delete: ");
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
                System.out.print("CONFIRM to DELETE this branch?: ");
                confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                       branchMapper.deleteById(branch.getBranchID());
                       conn.commit();
                    }

                    System.out.println("***Branch deleted successfully!***");
                } else
                    System.out.println("***Branch NOT delete successfully!***");
            }

            System.out.print("Continue to delete branch?: ");
            confirm = sc.nextLine();
        } while (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes"));
    }

    //Display all branches
    public static void displayBranches() {
        System.out.println("\n************************************");
        System.out.println("\t\tDisplay All Branches");
        System.out.println("************************************");

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

            System.out.print("Press Enter to return back to the Branch Management Menu: ");
            sc.nextLine();
    }

}
