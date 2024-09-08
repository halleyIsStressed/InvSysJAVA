package Service;

import DAO.ProductReturnMapper;
import Database.Database;
import Entity.ReturnOrder;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProductReturnMenuFunction {
    public static void returnOrderListing() throws IOException {
        int roMenuOptions;
        Scanner optionScanner = new Scanner(System.in);
        do {
            System.out.println("Choose Option:");
            System.out.println("1 > Return Item");
            System.out.println("2 > Search Return History");
            System.out.println("3 > Edit Return Details");
            System.out.println("4 > Cancel Return");
            System.out.println("5 > Return");
            roMenuOptions = optionScanner.nextInt();
            switch (roMenuOptions) {
                case 1:
                    //createReturnOrder();
                    System.out.println("C");
                    break;
                case 2:
                    //searchReturnOrder();
                    System.out.println("R");
                    break;
                case 3:
                    //editReturnOrder();
                    System.out.println("U");
                    break;
                case 4:
                    //cancelReturnOrder();
                    System.out.println("D");
                    break;
                case 5:
                    // fuckOff();
                    break;
                default:
                    System.out.println("Invalid Option. Try Again.");
                    System.in.read(); // This is supposed to be unread, dw
                    System.out.print("\n\n");
            }
        } while (roMenuOptions != 5);
    }


}
