package Service;

import DAO.TransferMapper;
import Database.Database;
import Entity.Stock_Transfer;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TransferMenuFunction {
    public static void confirmationMenu() throws IOException {
        int confirmationOptions;
        String targetTransferID;
        String confirmation;
        Scanner optionScanner = new Scanner(System.in);
        Scanner idScanner = new Scanner(System.in);
        Scanner confirmationScanner = new Scanner(System.in);

        List<Stock_Transfer> trList;
        try (SqlSession conn = Database.getInstance().openSession()) {
            TransferMapper trMapper = conn.getMapper(TransferMapper.class);
            trList = trMapper.selectPendingTransfers();
        }

        System.out.println("\nPENDING OUTWARD TRANSFER REQUESTS\n");
        System.out.printf("%-12s | %-11s | %-10s | %-9s | %-13s\n\n", "Transfer ID","Product ID","Branch ID","Quantity","Request Date");
        for (Stock_Transfer tr : trList) {
            System.out.printf("%-12s | %-11s | %-10s | %-9d | %-13s\n",
                    tr.getTransfer_id(),
                    tr.getProduct_id(),
                    tr.getBranch_id(),
                    tr.getTransfer_quantity(),
                    tr.getRequest_date());
        }

        do {


            System.out.println("\nChoose Option:");
            System.out.println("1 > Confirm Request");
            System.out.println("2 > Deny Request");
            System.out.println("3 > Return");
            confirmationOptions = optionScanner.nextInt();
            switch (confirmationOptions) {
                case 1:
                    System.out.println("Enter Transfer ID to Confirm(Eg. TR00001): ");
                    targetTransferID = idScanner.nextLine();

                    System.out.println("Are you sure you want to confirm this transfer request?");
                    System.out.print("Enter 1 to cancel, enter any other key to return > ");
                    confirmation = confirmationScanner.nextLine();

                    if (Objects.equals(confirmation, "1")) {
                        try (SqlSession sqlSession = Database.getInstance().openSession()) {
                            System.out.println("Not Implemented");
                            // TODO Ahdan - Write logic to UPDATE Stock_Transfer object of targetTransferID.status into "Confirmed".

                            // TODO Ahdan - Write logic to UPDATE Product table, and deduct PRODUCT_QUANTITY with TRANSFER_QUANTITY.

                        }

                        System.out.println("Request Confirmed! Quantity of product deducted from local database.");
                    } else ;

                    break;
                case 2:
                    System.out.println("Enter Transfer ID to Deny(Eg. TR00001): ");
                    targetTransferID = idScanner.nextLine();

                    System.out.println("Are you sure you want to deny this transfer request?");
                    System.out.print("Enter 1 to cancel, enter any other key to return > ");
                    confirmation = confirmationScanner.nextLine();

                    if (Objects.equals(confirmation, "1")) {
                        try (SqlSession sqlSession = Database.getInstance().openSession()) {
                            System.out.println("Not Implemented");
                            // TODO Ahdan - Write logic to delete transfer request of targetTransferID.
                        }

                        System.out.println("Request Denied.");
                    } else ;


                    break;
                case 3:
                    // fuckOff();
                    break;
                default:
                    System.out.println("Invalid Option. Try Again.");
                    System.in.read(); // This is supposed to be unread, dw
                    System.out.print("\n\n");
            }
        } while (confirmationOptions != 3);

    }
}
