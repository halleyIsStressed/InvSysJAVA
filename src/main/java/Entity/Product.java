package Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder


public class Product {


    private int product_id;
    private String product_type;
    private String product_name;
    private double product_price;
    private int product_qty;

    public Product(int product_id, String product_type, String product_name, double product_price, int product_quantity) {
        this.product_id = product_id;
        this.product_type =product_type;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_qty = product_quantity;
    }

    public Product(String product_type, String product_name, double productPrice) {
        this.product_type = product_type;
        this.product_name = product_name;
        this.product_price = productPrice;
    }

    public Product(int product_id) {
        this.product_id = product_id;
    }


    public Product() {

    }
}
