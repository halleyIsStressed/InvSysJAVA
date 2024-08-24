package Entity;
import DAO.InventoryManagerDAO;
import SQLTools.InventoryManagerTools;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

@Data
@AllArgsConstructor
public class Product {
    int product_id;
    String product_type;
    String product_name;
    double product_price;
    int product_qty;


    public void productListing() {
        int num = placeholder;
        /*
            TODO: AHDAN

            Here, I want to get ALL product details and print it below.
            I want you do set "placeholder" as the amount of products we have via COUNT query.



        */
        System.out.printf("%-5s | %-10s | %-8s | %-7s | %-5s", "ID", "Type", "Name", "Price", "Qty");
        for (Product product: dao.getAllProducts()) {
            System.out.printf("%-5d | %-10s | %-8s | %-7.2f | %-5s", product_id, product_type, product_name, product_price, product_qty);
        }
    }
}
