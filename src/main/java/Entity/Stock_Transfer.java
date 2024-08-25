package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Stock_Transfer {
    private int product_id;
    private int retailer_id;
    private int transfer_qty;
    private String transfer_date;

    public Stock_Transfer(int product_id, int retailer_id, int transfer_qty, String transfer_date) {
        this.product_id = product_id;
        this.retailer_id = retailer_id;
        this.transfer_qty = transfer_qty;
        this.transfer_date = transfer_date;
    }
}
