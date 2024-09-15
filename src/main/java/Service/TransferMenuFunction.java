package Service;

import java.io.IOException;
import java.util.Scanner;

public class TransferMenuFunction {
    public static void transferMenu() throws IOException {
        int transferMenuOptions;
        Scanner optionScanner = new Scanner(System.in);
        do {
            System.out.println("\nChoose Option:");
            System.out.println("1 > Reply to Product Requests");
            System.out.println("2 > Request for Product");
            System.out.println("3 > Return");
            transferMenuOptions = optionScanner.nextInt();
            switch (transferMenuOptions) {
                case 1:
                    TransferConfirmationFunction.confirmationMenu();
                    break;
                case 2:
                    TransferRequestFunction.requestMenu();
                    break;
                case 3:
                    // fuckOff();
                    break;
                default:
                    System.out.println("Invalid Option. Try Again.");
                    System.in.read(); // This is supposed to be unread, dw
                    System.out.print("\n\n");
            }
        } while (transferMenuOptions != 3);

    }
}
