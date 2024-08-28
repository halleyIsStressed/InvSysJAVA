package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReturnOrder {
    private String return_id;
    private String supplier_id;
    private String product_id;
    private int return_quantity;
    private String return_date;
    private String return_reason;






}
