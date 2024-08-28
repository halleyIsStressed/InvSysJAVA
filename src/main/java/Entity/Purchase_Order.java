package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Purchase_Order {
    private String po_number;
    private String supplier_id;
    private  String product_id;
    private int purchase_qty;
    private double order_price;
    private String order_date;


}
