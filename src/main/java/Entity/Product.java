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
    private int product_quantity;

    public Product(String product_id, String product_type, String product_name, double product_price, int product_qty) {
        this.product_id = product_id;
        this.product_type = product_type;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
    }

    public Product() {

    }


    @Override
    public String toString(){
        return  "*****************************************"+
                "\nID: "+ product_id +
                "\nType: "+product_type+
                "\nName: "+product_name+
                "\nPrice: "+product_price+
                "\nQuantity: "+product_quantity+
                "\n*****************************************";
    }
}
