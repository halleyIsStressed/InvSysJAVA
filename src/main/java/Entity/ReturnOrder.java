package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReturnOrder {
    private int return_id;
    private int supplier_id;
    private int product_id;
    private int return_quantity;
    private String return_date;
    private String return_reason;

    public ReturnOrder(int return_id, int supplier_id, int product_id, int return_quantity, String return_date, String return_reason) {
        this.return_id = return_id;
        this.supplier_id = supplier_id;
        this.product_id = product_id;
        this.return_quantity = return_quantity;
        this.return_date = return_date;
        this.return_reason = return_reason;
    }


}
