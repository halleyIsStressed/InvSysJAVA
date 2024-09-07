package Service;

import DAO.PurchaseOrderMapper;
import Database.Database;
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

        System.out.printf("%-10s | %-11s | %-10s | %-7s | %-12s | %-11s\n\n", "PO Number", "Product ID", "Quantity", "Cost", "Supplier ID", "Status");
        for (Purchase_Order po : poList) {
            System.out.printf("%-10s | %-11s | %-10d | %-5.2f | %-12s | %-11s\n",
                    po.getPo_number(),
                    po.getProduct_id(),
                    po.getPurchase_quantity(),
                    po.getOrder_price(),
                    po.getSupplier_id(),
                    po.getStatus());
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
                    createPurchaseOrder();
                    break;
                case 2:
                    searchPurchaseOrder();
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

    public static void createPurchaseOrder() {
        Purchase_Order newPO = getNewPurchaseOrder();
        try (SqlSession conn = Database.getInstance().openSession()) {
            PurchaseOrderMapper productMapper = conn.getMapper( PurchaseOrderMapper.class);
            productMapper.insertPo(newPO); // TODO Ahdan - Write insert logic into .xml file. Also check if mappers are correct.
            conn.commit();            //TODO DONE
        }
    }

    public static Purchase_Order getNewPurchaseOrder(){

        Purchase_Order newPO = new Purchase_Order();
        Scanner newPoScanner = new Scanner(System.in);
        System.out.print("\nEnter product ID to order (Eg. P00001): ");
        newPO.setProduct_id(newPoScanner.nextLine());
        System.out.print("\nEnter quantity: ");
        newPO.setPurchase_quantity(newPoScanner.nextInt());
        System.out.print("\nEnter supplier ID to order from (Eg. 1,2,3): ");
        newPO.setSupplier_id(newPoScanner.nextLine());

        System.out.print("\n\n");
        System.out.println("Purchase Order Created. Awaiting response and payment calculations from Supplier.");
        return newPO;
    }
    //TODO DONE


    public static void searchPurchaseOrder() throws IOException {
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
                    System.out.print("Enter Supplier ID (Eg. 1, 2, 3): ");
                    targetSupplier = supplierSc.nextLine();

                    List<Purchase_Order> targetList;
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        PurchaseOrderMapper poMapper = conn.getMapper(PurchaseOrderMapper.class);
                        targetList = poMapper.selectIDfortaget(targetSupplier);
                    }
                    //TODO DONE
                    System.out.printf("%-10s | %-11s | %-10s | %-7s | %-12s | %-11s\n\n", "PO Number", "Product ID", "Quantity", "Cost", "Status");
                    // TODO Ahdan - Show all Purchase Orders done by targetSupplier. No need to select supplier_id column.
                    /*for (Logic here) {
                        System.out.printf("%-10s | %-11s | %-10d | %-5.2f | %-11s\n",
                                po.getPo_number(),
                                po.getProduct_id(),
                                po.getPurchase_quantity(),
                                po.getOrder_price(),
                                po.getStatus());
                    }*/
                    break;

                case 2:
                    Scanner productSc = new Scanner(System.in);
                    String targetProduct = "";
                    System.out.print("Enter Product ID (Eg. P00001): ");
                    targetProduct = productSc.nextLine();
                    // TODO Ahdan - Show all Purchase Orders that has the targetProduct ID. No need to print product_id column.
                    // TODO DONE
                    Purchase_Order targetPO = new Purchase_Order();
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        PurchaseOrderMapper poMapper = conn.getMapper(PurchaseOrderMapper.class);
                         targetPO= poMapper.selectBYPOID(targetProduct);
                    }
                    System.out.printf("%-10s | %-11s | %-10s | %-7s | %-12s | %-11s\n\n", "PO Number", "Quantity", "Cost", "Supplier ID", "Status");
                    /*System.out.printf("%-10s | %-10d | %-5.2f | %-12s | %-11s\n",
                                po.getPo_number(),
                                po.getPurchase_quantity(),
                                po.getOrder_price(),
                                po.getSupplier_id(),
                                po.getStatus());
                    }*/
                    break;

                case 3:
                    String startDate, endDate;

                    System.out.println("Enter start date.");
                    startDate = getDate();
                    System.out.println("\nEnter end date.");
                    endDate = getDate();

                    // TODO Ahdan - Find purchase orders that fall between startDate and endDate. Format is MM/YYYY.
                    System.out.println(startDate);
                    System.out.println(endDate);

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

    private static String getDate() {
        int month, year;
        String date;
        Scanner dateSc = new Scanner(System.in);

        do {
            System.out.print("Month (MM): ");
            month = dateSc.nextInt();

            if (month < 1 || month > 12) {
                System.out.println("\nInvalid Month. Try Again.");
            }
        } while (month < 1 || month > 12);

        do {
            System.out.print("Year (YYYY): ");
            year = dateSc.nextInt();

            if (year > 2024) {
                System.out.println("\nInvalid Year. Try Again.");
            }
        } while (year > 2024);

        date = month + "/" + year;
        return date;
    };


}
