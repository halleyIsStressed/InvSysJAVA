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
        } while (roMenuOptions != 3);

    }

    public static void createReturnOrder() {
        ReturnOrder newReturnOrder = getNewReturnOrder();
        try (SqlSession conn = Database.getInstance().openSession()) {
            ProductReturnMapper roMapper = conn.getMapper(ProductReturnMapper.class);
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
        newRo.setQuantity(newRoScanner.nextInt());
        newRoScanner.nextLine();
        System.out.print("\nEnter supplier ID to return to (Eg. 1,2,3): ");
        newRo.setSupplier_id(newRoScanner.nextLine());
        System.out.print("\nEnter reason of return (Max 20 Characters): ");
        newRo.setReturn_reason(newRoScanner.nextLine());

        System.out.print("\n\n");
        System.out.println("Return Order Created. Quantity has been deducted.");
        return newRo;

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
                    System.out.print("Enter Supplier ID: ");
                    targetSupplier = supplierSc.nextLine();

                    List<ReturnOrder> targetList;
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        ProductReturnMapper roMapper = conn.getMapper(ProductReturnMapper.class);
                        targetList = roMapper.selectRoFromSupplier(targetSupplier);
                    }
                    if (targetList == null || targetList.isEmpty()) {
                        System.out.println("No purchase orders found for the given date range.");
                    } else {
                        for (ReturnOrder ro : targetList) {
                            System.out.printf("%-12s | %-10s | %-10s | %-10d | %-20s |\n",
                                    ro.getReturn_date(),
                                    ro.getReturn_id(),
                                    ro.getProduct_id(),
                                    ro.getQuantity(),
                                    ro.getReturn_reason());
                        }
                    }
                    break;

                case 2:
                    Scanner productSc = new Scanner(System.in);
                    String targetProduct = "";
                    System.out.print("Enter Product ID (Eg. P00001): ");
                    targetProduct = productSc.nextLine();
                    ReturnOrder targetRo = new ReturnOrder();
                    List<ReturnOrder> targetPList;
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        ProductReturnMapper roMapper = conn.getMapper(ProductReturnMapper.class);
                        targetPList = roMapper.selectRoByProduct(targetProduct);
                    }

                    if (targetPList == null || targetPList.isEmpty()) {
                        System.out.println("No purchase orders found for the given date range.");
                    } else {
                        for (ReturnOrder ro : targetPList) {
                            System.out.printf("%-12s | %-10s | %-10s | %-10d | %-20s |\n",
                                    ro.getReturn_date(),
                                    ro.getReturn_id(),
                                    ro.getSupplier_id(),
                                    ro.getQuantity(),
                                    ro.getReturn_reason());
                        }
                    }
                    break;

                case 3:
                    String startDate, endDate;
                    List<ReturnOrder> returnList;
                    System.out.println("Enter start date.");
                    startDate = getDate();
                    System.out.println("\nEnter end date.");
                    endDate = getDate();

                    try (SqlSession conn = Database.getInstance().openSession()) {
                        ProductReturnMapper roMapper = conn.getMapper(ProductReturnMapper.class);
                        returnList= roMapper.selectReturnByDate(startDate, endDate);
                    }
                    if (returnList == null || returnList.isEmpty()) {
                        System.out.println("No purchase orders found for the given date range.");
                    } else {
                        for (ReturnOrder ro : returnList) {
                            System.out.printf("%-12s | %-10s | %-10s | %-10s | %-10d | %-20s |\n",
                                    ro.getReturn_date(),
                                    ro.getReturn_id(),
                                    ro.getProduct_id(),
                                    ro.getSupplier_id(),
                                    ro.getQuantity(),
                                    ro.getReturn_reason());
                        }
                    }
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
        int month, year,day = 0;
        String date;
        Scanner dateSc = new Scanner(System.in);

        do {
            System.out.print("Year (YYYY): ");
            year = dateSc.nextInt();

            if (year > 2024) {
                System.out.println("\nInvalid Year. Try Again.");
            }
        } while (year > 2024);

        do {
            System.out.print("Month (MM): ");
            month = dateSc.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("\nInvalid Month. Please enter a month between 1 and 12.");
            }
        } while (month < 1 || month > 12);


        boolean validDay;
        do {
            validDay = true;
            System.out.print("Day (DD): ");
            day = dateSc.nextInt();
            if (month == 2) { // February
                if (isLeapYear(year)) {
                    if (day < 1 || day > 29) {
                        validDay = false;
                        System.out.println("\nInvalid Day for February in a Leap Year. Try Again.");
                    }
                } else {
                    if (day < 1 || day > 28) {
                        validDay = false;
                        System.out.println("\nInvalid Day for February. Try Again.");
                    }
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) { // Months with 30 days
                if (day < 1 || day > 30) {
                    validDay = false;
                    System.out.println("\nInvalid Day. This month has 30 days. Try Again.");
                }
            } else { // Months with 31 days
                if (day < 1 || day > 31) {
                    validDay = false;
                    System.out.println("\nInvalid Day. This month has 31 days. Try Again.");
                }
            }
        } while (!validDay);

        date = String.format("%04d-%02d-%02d", year, month, day);
        return date;
    }
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


}
