package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Stock_Transfer {
    private  String product_id;
    private  String retailer_id;
    private int transfer_quantity;
    private String transfer_date;

    public Stock_Transfer( String product_id,  String retailer_id, int transfer_quantity, String transfer_date) {
        this.product_id = product_id;
        this.retailer_id = retailer_id;
        this.transfer_quantity = transfer_quantity;
        this.transfer_date = transfer_date;
    }
}
