package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReturnOrder {
    private String return_id;
    private String supplier_id;
    private String product_id;
    private String return_date;
    private String return_reason;
    private int return_quantity;

    public ReturnOrder(String return_id, String supplier_id, String product_id, String return_reason, String return_date, int return_quantity) {
        this.return_id = return_id;
        this.supplier_id = supplier_id;
        this.product_id = product_id;
        this.return_reason = return_reason;
        this.return_date = return_date;
        this.return_quantity = return_quantity;
    }



}
