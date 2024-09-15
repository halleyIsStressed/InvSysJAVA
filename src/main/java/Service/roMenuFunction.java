package Service;

import DAO.ProductReturnMapper;
import Database.Database;
import Entity.ReturnOrder;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class roMenuFunction {
    public static void returnOrderListing() throws IOException {
        int roMenuOptions;
        Scanner optionScanner = new Scanner(System.in);
        do {
            System.out.println("Choose Option:");
            System.out.println("1 > Return Item");
            System.out.println("2 > Search Return History");
            System.out.println("3 > Return");
            roMenuOptions = optionScanner.nextInt();
            switch (roMenuOptions) {
                case 1:
                    createReturnOrder();
                    System.out.println("C");
                    break;
                case 2:
                    searchReturnOrder();
                    System.out.println("R");
                    break;
                case 3:
                    // fuckOff();
                    break;
                default:
                    System.out.println("Invalid Option. Try Again.");
                    System.in.read(); // This is supposed to be unread, dw
                    System.out.print("\n\n");
            }
        } while (roMenuOptions != 5);

    }

    public static void createReturnOrder() {
        ReturnOrder newReturnOrder = getNewReturnOrder();
        try (SqlSession conn = Database.getInstance().openSession()) {
            ProductReturnMapper roMapper = conn.getMapper( ProductReturnMapper.class);
            roMapper.insertRo(newReturnOrder);
            conn.commit();
           }

    }

    public static ReturnOrder getNewReturnOrder(){

        ReturnOrder newRo = new ReturnOrder();
        Scanner newRoScanner = new Scanner(System.in);
        System.out.print("\nEnter product ID to return (Eg. P00001): ");
        newRo.setProduct_id(newRoScanner.nextLine());
        System.out.print("\nEnter quantity: ");
        newRo.setReturn_quantity(newRoScanner.nextInt());
        System.out.print("\nEnter supplier ID to return to (Eg. 1,2,3): ");
        newRo.setSupplier_id(newRoScanner.nextLine());
        System.out.print("\nEnter reason of return (Max 20 Characters): ");
        newRo.setSupplier_id(newRoScanner.nextLine());

        System.out.print("\n\n");
        System.out.println("Return Order Created. Quantity has been deducted.");
        return newRo;

        // TODO Ahdan - Write .xml logic for creating new Return Order. Deduct product_quantity with return_quantity here.

    }


    public static void searchReturnOrder() throws IOException {
        // More akin to a Filtering function.
        Scanner sc = new Scanner(System.in);
        int filterOptions;
        do {
            System.out.println("Choose Filter Method:");
            System.out.println("1 > Supplier ID");
            System.out.println("2 > Product ID");
            System.out.println("3 > Return Date");
            System.out.println("4 > Return");
            filterOptions = sc.nextInt();

            switch (filterOptions) {
                case 1:
                    Scanner supplierSc = new Scanner(System.in);
                    String targetSupplier = "";
                    System.out.print("Enter Supplier ID (Eg. 1, 2, 3): ");
                    targetSupplier = supplierSc.nextLine();

                    List<ReturnOrder> targetList;
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        ProductReturnMapper roMapper = conn.getMapper(ProductReturnMapper.class);
                        targetList = roMapper.selectRoFromSupplier(targetSupplier);
                    }
                    // TODO Ahdan - Find all Return Orders linked to targetSupplier and display all rows.

                    break;

                case 2:
                    Scanner productSc = new Scanner(System.in);
                    String targetProduct = "";
                    System.out.print("Enter Product ID (Eg. P00001): ");
                    targetProduct = productSc.nextLine();
                    ReturnOrder targetRo = new ReturnOrder();
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        ProductReturnMapper roMapper = conn.getMapper(ProductReturnMapper.class);
                        targetRo= roMapper.selectRoByProduct(targetProduct);
                    }
                    // TODO Ahdan - Find all Return Orders linked to targetProduct and display all rows.

                    break;

                case 3:
                    String startDate, endDate;

                    System.out.println("Enter start date.");
                    startDate = getDate();
                    System.out.println("\nEnter end date.");
                    endDate = getDate();

                    // TODO Ahdan - Find Return Orders that fall between startDate and endDate. Format is MM/YYYY.
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
