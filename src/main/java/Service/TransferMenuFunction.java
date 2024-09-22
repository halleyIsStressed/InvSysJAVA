package Service;

import DAO.ProductMapper;
import DAO.TransferMapper;
import Database.Database;
import Entity.Product;
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
        boolean invalid;
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
            Stock_Transfer stockTransfer=null;
            switch (confirmationOptions) {
                case 1:
                    do {
                        invalid = false;
                        System.out.print("\nEnter Transfer ID to Confirm(Eg. TR00001): ");

                        targetTransferID = idScanner.nextLine();
                        if (targetTransferID.matches("^TR\\d{5}$")) {
                        } else {
                            invalid = true;
                            System.out.println("\nInvalid Transfer ID format. Try Again.");
                            System.in.read();
                        }
                    } while (invalid);



                    try (SqlSession conn = Database.getInstance().openSession()) {
                        TransferMapper trMapper = conn.getMapper(TransferMapper.class);
                        stockTransfer = trMapper.selectBYID(targetTransferID);
                    }
                    System.out.printf("%-12s | %-11s | %-10s | %-9d | %-13s\n",
                            stockTransfer.getTransfer_id(),
                            stockTransfer.getProduct_id(),
                            stockTransfer.getBranch_id(),
                            stockTransfer.getTransfer_quantity(),
                            stockTransfer.getRequest_date());



                    System.out.println("Are you sure you want to confirm this transfer request?");
                    System.out.print("Enter 1 to cancel, enter any other key to return > ");
                    confirmation = confirmationScanner.nextLine();

                    if (Objects.equals(confirmation, "1")) {
                        boolean transferCompleted = false;
                        do {
                            Product product = null;
                            try (SqlSession conn = Database.getInstance().openSession()) {
                                ProductMapper productMapper = conn.getMapper(ProductMapper.class);
                                product = productMapper.selectById(stockTransfer.getProduct_id());
                            }
                            if (product.getProduct_quantity()>stockTransfer.getTransfer_quantity()) {


                                int newQuantity;
                                int stockTQ = stockTransfer.getTransfer_quantity();
                                int productQ = product.getProduct_quantity();
                                newQuantity = productQ - stockTQ;
                                product.setProduct_quantity(newQuantity);

                                try (SqlSession conn = Database.getInstance().openSession()) {
                                    ProductMapper productMapper = conn.getMapper(ProductMapper.class);
                                    productMapper.updateModifyData(product);
                                    conn.commit();
                                }

                                stockTransfer.setStatus("Confirmed");
                                try (SqlSession conn = Database.getInstance().openSession()) {
                                    TransferMapper trMapper = conn.getMapper(TransferMapper.class);
                                    trMapper.updateStatus(stockTransfer);
                                    conn.commit();
                                }
                                System.out.println("Request Confirmed! Quantity of product deducted from local database.");
                                transferCompleted = true;
                            }
                        else{
                                System.out.println("Insufficient stock for this transfer. Transfer cannot be confirmed.");
                                System.out.print("Do you want to retry? (Enter 1 to retry, any other key to cancel): ");
                                confirmation = confirmationScanner.nextLine();

                                // If user doesn't want to retry, break the loop
                                if (!Objects.equals(confirmation, "1")) {
                                    transferCompleted = true;
                                    System.out.println("Transfer cancelled.");
                                }
                           }
                        }while (!transferCompleted);

                    } else ;

                    break;
                case 2:
                    do {
                        invalid = false;
                        System.out.print("\nEnter Transfer ID to Deny (Eg. TR00001): ");

                        targetTransferID = idScanner.nextLine();
                        if (targetTransferID.matches("^TR\\d{5}$")) {
                        } else {
                            invalid = true;
                            System.out.println("\nInvalid Transfer ID format. Try Again.");
                            System.in.read();
                        }
                    } while (invalid);


                    try (SqlSession conn = Database.getInstance().openSession()) {
                        TransferMapper trMapper = conn.getMapper(TransferMapper.class);
                        stockTransfer = trMapper.selectBYID(targetTransferID);
                    }
                    System.out.printf("%-12s | %-11s | %-10s | %-9d | %-13s\n",
                            stockTransfer.getTransfer_id(),
                            stockTransfer.getProduct_id(),
                            stockTransfer.getBranch_id(),
                            stockTransfer.getTransfer_quantity(),
                            stockTransfer.getRequest_date());


                    System.out.println("Are you sure you want to deny this transfer request?");
                    System.out.print("Enter 1 to cancel, enter any other key to return > ");
                    confirmation = confirmationScanner.nextLine();
                    if (Objects.equals(confirmation, "1")) {
                        try (SqlSession conn = Database.getInstance().openSession()) {
                            TransferMapper trMapper = conn.getMapper(TransferMapper.class);
                            trMapper.deleteTransferRequest(stockTransfer);
                            conn.commit();
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
