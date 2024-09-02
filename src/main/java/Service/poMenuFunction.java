package Service;

import DAO.ProductMapper;
import DAO.PurchaseOrderMapper;
import Database.Database;
import Entity.Product;
import Entity.Purchase_Order;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class poMenuFunction {
    public static void poListing() throws IOException {
        int poMenuOptions;
        Scanner poScanner = new Scanner(System.in);
        List<Purchase_Order> poList;
        try (SqlSession conn = Database.getInstance().openSession()) {
            PurchaseOrderMapper poMapper = conn.getMapper(PurchaseOrderMapper.class);
            poList = poMapper.selectALLpo();
        }

        System.out.printf("%-10s | %-11s | %-10s | %-5s | %-12s\n\n", "PO Number", "Product ID", "Quantity", "Cost", "Supplier ID");
        for (Purchase_Order po : poList) {
            System.out.printf("%-10s | %-11s | %-10d | %-5f | %-12s\n",
                    po.getPo_number(),
                    po.getProduct_id(),
                    po.getPurchase_quantity(),
                    po.getOrder_price(),
                    po.getSupplier_id());
        }
        do {
            System.out.println("Choose Option:");
            System.out.println("1 > Create Purchase Order");
            System.out.println("2 > Search Order History");
            System.out.println("3 > Edit Order");
            System.out.println("4 > Cancel Order");
            System.out.println("5 > Return");
            poMenuOptions = poScanner.nextInt();
            switch (poMenuOptions) {
                case 1:
                    // createPO();
                    break;
                case 2:
                    // searchPO();
                    break;
                case 3:
                    // editPO();
                    break;
                case 4:
                    // cancelPO();
                    break;
                case 5:
                    // fuckOff();
                    break;
                default:
                    System.out.println("Invalid Option. Try Again.");
                    System.in.read(); // This is supposed to be unread, dw
                    System.out.print("\n\n");
            }
        } while (poMenuOptions != 5);
    }


    public static void searchProduct() throws IOException {
        // More akin to a Filtering function.
        Scanner sc = new Scanner(System.in);
        int filterOptions;
        do {
            System.out.println("Choose Filter Method:");
            System.out.println("1 > Supplier ID");
            System.out.println("2 > Product ID");
            System.out.println("3 > Order Date");
            System.out.println("4 > Return");
            filterOptions = sc.nextInt();

            switch (filterOptions) {
                case 1:
                    Scanner supplierSc = new Scanner(System.in);
                    String targetSupplier = "";
                    System.out.print("Enter Supplier ID: ");
                    targetSupplier = supplierSc.nextLine();

                    //Show all Purchase Orders done by targetSupplier. Print it out in the below format. NOTE: No need to select supplier_id column.
                    /*System.out.printf("%-10s | %-11s | %-10d | %-5f\n",
                            po.getPo_number(),
                            po.getProduct_id(),
                            po.getPurchase_quantity(),
                            po.getOrder_price(),
                       */
                    break;

                case 2:
                    Scanner productSc = new Scanner(System.in);
                    String targetProduct = "";
                    System.out.print("Enter Product ID: ");
                    targetProduct = productSc.nextLine();
                    break;

                case 3:
                    Scanner priceSc = new Scanner(System.in);
                    String startDate, endDate;
                    System.out.print("Enter start date: ");
                    startDate = priceSc.nextLine();
                    System.out.print("Enter end date: ");
                    endDate = priceSc.nextLine();
                    // Don't touch this yet lol
                    break;


                case 4:
                    break;

                default:
                    System.out.println("Invalid Option. Try Again.");
                    System.in.read();
                    break;

            }
        } while (filterOptions != 4);
    }



}
