package Service;

import DAO.InventoryManagerMapper;
import DAO.StaffMapper;
import Database.Database;
import Design.Design;
import Entity.Staff;
import Entity.User;
import com.sun.tools.javac.Main;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Scanner;

public class ProfileMenu {

    public static void profileList(String id,int choice) throws IOException {
        Staff currentUser;
        Scanner sc = new Scanner(System.in);
        if(choice==2) {
            try (SqlSession conn = Database.getInstance().openSession()) {
                StaffMapper staffMapper = conn.getMapper(StaffMapper.class);
                currentUser = staffMapper.selectStaffByIdAndPassword(id);
            }

            switch (currentUser.getPosition()) {
                case "Inventory Clerk" -> {
                    boolean keepRunning = true;
                    while (keepRunning) {
                        System.out.println(currentUser);
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
                                System.out.println("Return to Main page...");
                                keepRunning = false;
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    }
                }
                case "Warehouse Staff" -> {
                    boolean keepRunning = true;
                    while (keepRunning) {
                        System.out.println(currentUser);
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
                                System.out.println("Return to Main page...");
                                keepRunning = false;
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    }
                }
                case "Logistics Coordinator" -> {
                    boolean keepRunning = true;
                    while (keepRunning) {
                        System.out.println(currentUser);
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
                                System.out.println("Return to Main page...");
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
         else{
                boolean keepRunning = true;
                while (keepRunning) {
                    User inventoryManager;
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        InventoryManagerMapper IMMapper = conn.getMapper(InventoryManagerMapper.class);
                        inventoryManager=IMMapper.selectByIdAndPassword(id);
                    }
                    System.out.println(" \n*****************************************");
                    System.out.println(         "Inventory Manager Profile");
                    System.out.println("*****************************************\n");
                    System.out.println(inventoryManager);
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
                            break;
                        case 8:
                            System.out.println("Return to Main page...");
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
