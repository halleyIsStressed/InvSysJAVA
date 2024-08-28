package Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder


public class Product {

    private String product_id;
    private String product_type;



    private String product_name;
    private double product_price;
    private int product_qty;

    public Product(String product_id, String product_type, String product_name, double product_price, int product_qty) {
        this.product_id = product_id;
        this.product_type = product_type;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_qty = product_qty;
    }
    public Product(String product_type, String product_name, double product_price) {
        this.product_type = product_type;
        this.product_name = product_name;
        this.product_price = product_price;
    }


    public Product() {
        
    }
}
