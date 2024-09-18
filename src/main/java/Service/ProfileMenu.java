package Service;

import DAO.InventoryManagerMapper;
import DAO.StaffMapper;
import Database.Database;
import Design.Design;
import Entity.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Scanner;

public class ProfileMenu {

    public static void profileList(String id,int choice) throws IOException {
        User currentUser = new User();
        switch (choice) {
            case 1:
                try (SqlSession conn = Database.getInstance().openSession()) {
                    InventoryManagerMapper inventoryManagerMapper = conn.getMapper(InventoryManagerMapper.class);
                    currentUser = inventoryManagerMapper.selectByIdAndPassword(id);
                }
                break;
            case 2:
                try (SqlSession conn = Database.getInstance().openSession()) {
                    StaffMapper staffMapper = conn.getMapper(StaffMapper.class);
                    currentUser = staffMapper.selectByIdAndPassword(id);
                }
                break;
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("\n************************************");
        System.out.print(currentUser.getPosition() + " Profile ");
        System.out.println("\n************************************");

        System.out.println("Name:" + currentUser.getName());
        System.out.println("Gender:" + currentUser.getGender());
        System.out.println("Age:" + currentUser.getAge());
        System.out.println("Phone:" + currentUser.getPhone());

        if (currentUser.getPosition().equals("Inventory Manager")){
            boolean keepRunning = true;
            while (keepRunning) {

                System.out.print("""
                    1) Supplier Menu
                    2) Product Listing
                    3) Purchase Order Listing
                    4) Branch Menu
                    5) Return Order Listing
                    6) Reply to Product Requests
                    7) Generate report
                    8) Exit
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
                        poMenuFunction.poListing();
                        break;
                    case 4:
                        BranchMenuFunction.branchManagement();
                        break;
                    case 5:
                        roMenuFunction.returnOrderListing();
                        break;
                    case 6:
                        TransferMenuFunction.confirmationMenu();
                        break;
                    case 7:
                        ReportGenerate.reportGenerate();
                    case 8:
                        System.out.println("Exiting the program...");
                        keepRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        }
        else {
            if (currentUser.getPosition().equals("Inventory Clerk")) {
                boolean keepRunning = true;
                while (keepRunning) {
                    System.out.print("""
                            1) Product Listing
                            2) Generate report
                            3) Exit
                            Enter your option:""");
                    int option = sc.nextInt();
                    switch (option) {
                        case 1:
                            ProductMenuFunction.productListing();
                            break;
                        case 2:
                            ReportGenerate.checkPositionToGenerateReport(currentUser.getPosition());
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
            } else if (currentUser.getPosition().equals("Warehouse Staff")) {
                boolean keepRunning = true;
                while (keepRunning) {
                    System.out.print("""
                            1) Product Listing
                            2) Purchase Order Listing
                            3) Return Order Listing
                            4) Reply to Product Requests
                            5) Generate report
                            6) Exit
                            Enter your option:""");
                    int option = sc.nextInt();
                    switch (option) {
                        case 1:
                            ProductMenuFunction.productListing();
                            break;
                        case 2:
                            poMenuFunction.poListing();
                            break;
                        case 3:
                            roMenuFunction.returnOrderListing();
                            break;
                        case 4:
                            TransferMenuFunction.confirmationMenu();
                            break;
                        case 5:
                            ReportGenerate.checkPositionToGenerateReport(currentUser.getPosition());
                            break;
                        case 6:
                            System.out.println("Exiting the program...");
                            keepRunning = false;
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                }
            }
            else{
                boolean keepRunning = true;
                while (keepRunning) {
                    System.out.print("""
                            1) Purchase Order Listing
                            2) Return Order Listing
                            3) Reply to Product Requests
                            4) Generate report
                            5) Exit
                            Enter your option:""");
                    int option = sc.nextInt();
                    switch (option) {
                        case 1:
                            poMenuFunction.poListing();
                            break;
                        case 2:
                            roMenuFunction.returnOrderListing();
                            break;
                        case 3:
                            TransferMenuFunction.confirmationMenu();
                            break;
                        case 4:
                            ReportGenerate.checkPositionToGenerateReport(currentUser.getPosition());
                            break;
                        case 5:
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
    }


}
