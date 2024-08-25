package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Purchase_Order {
    private int po_number;
    private int product_id;
    private int purchase_qty;
    private double order_price;
    private int supplier_id;

    public Purchase_Order(int po_number, int product_id, int purchase_qty, double order_price, int supplier_id) {
        this.po_number = po_number;
        this.product_id = product_id;
        this.purchase_qty = purchase_qty;
        this.order_price = order_price;
        this.supplier_id = supplier_id;
    }
}
