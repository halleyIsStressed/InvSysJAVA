package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Stock_Return {
    private int retailer_id;
    private int product_id;
    private int return_id;
    private int return_qty;
    private String return_date;

    public Stock_Return(int retailer_id, int product_id, int return_id, int return_qty, String return_date) {
        this.retailer_id = retailer_id;
        this.product_id = product_id;
        this.return_id = return_id;
        this.return_qty = return_qty;
        this.return_date = return_date;
    }
}
