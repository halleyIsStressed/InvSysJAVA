package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Purchase_Order {
    private int po_number;
    private int supplier_id;
    private int product_id;
    private int purchase_qty;
    private double order_price;
    private String order_date;

    public Purchase_Order(int po_number, int product_id, int purchase_qty, double order_price, int supplier_id) {
        this.po_number = po_number;
        this.product_id = product_id;
        this.purchase_qty = purchase_qty;
        this.order_price = order_price;
        this.supplier_id = supplier_id;
    }

    public Purchase_Order(int po_number, int supplier_id, int product_id, double order_price, int purchase_qty, String order_date) {
        this.po_number = po_number;
        this.supplier_id = supplier_id;
        this.product_id = product_id;
        this.order_price = order_price;
        this.purchase_qty = purchase_qty;
        this.order_date = order_date;
    }
}
