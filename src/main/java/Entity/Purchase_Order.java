package Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Purchase_Order {
    private String po_number;
    private String supplier_id;
    private String product_id;
    private int purchase_quantity;

    public Purchase_Order(String po_number, String supplier_id, String product_id, int purchase_quantity, double order_price, String order_date, String status) {
        this.po_number = po_number;
        this.supplier_id = supplier_id;
        this.product_id = product_id;
        this.purchase_quantity = purchase_quantity;
        this.order_price = order_price;
        this.order_date = order_date;
        this.status = status;
    }

    private double order_price;
    private String order_date;
    private String status;


    public Purchase_Order() {

    }
}
