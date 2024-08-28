package Service;

import DAO.PurchaseOrderMapper;
import Database.Database;
import Entity.Purchase_Order;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;


public class poMenuFunction {
    public static void productListing() {

        Scanner poMenuOptions = new Scanner(System.in);
        List<Purchase_Order> poList;
        // TODO - Check if this try statement is correct
        try (SqlSession conn = Database.getInstance().openSession()) {
            PurchaseOrderMapper poMapper = conn.getMapper(PurchaseOrderMapper.class);
            poList = poMapper.selectALLpo();
        }

        System.out.printf("%-10s | %-11s | %-10s | %-5s | %-12s\n\n", "PO Number", "Product ID", "Quantity", "Cost", "Supplier ID");
        for (Purchase_Order po : poList) {
            System.out.printf("%-10s | %-11s | %-10d | %-5f | %-12s\n",
                    po.getPo_number(),
                    po.getProduct_id(),
                    po.getPurchase_qty(),
                    po.getOrder_price(),
                    po.getSupplier_id());
        }
        System.out.println("Choose Option:");
        System.out.println("1 > Create Purchase Order");
        System.out.println("2 > Search Order History");
        System.out.println("3 > Edit Order");
        System.out.println("4 > Cancel Order");
        System.out.println("5 > Return");

        switch (poMenuOptions.nextInt()) {
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
        }

    }
}
