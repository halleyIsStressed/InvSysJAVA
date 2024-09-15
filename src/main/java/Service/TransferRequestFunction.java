package Service;

import DAO.TransferMapper;
import Database.Database;
import Entity.Stock_Transfer;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Scanner;


public class TransferRequestFunction {
    public static void requestMenu() throws IOException {
        int requestOptions;
        Scanner optionScanner = new Scanner(System.in);
        do {
            System.out.println("\nChoose Option:");
            System.out.println("1 > Transfer to Branch");
            System.out.println("2 > Request for Product");
            System.out.println("3 > Return");
            requestOptions = optionScanner.nextInt();
            switch (requestOptions) {
                case 1:
                    System.out.println("C");
                    break;
                case 2:
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
        } while (requestOptions != 3);

    }


}
