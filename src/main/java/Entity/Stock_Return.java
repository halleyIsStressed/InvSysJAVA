package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Stock_Return {
    private  String retailer_id;
    private String product_id;
    private  String return_id;
    private int return_quantity;
    private String return_date;

    public Stock_Return( String retailer_id,  String product_id,  String return_id, int return_quantity, String return_date) {
        this.retailer_id = retailer_id;
        this.product_id = product_id;
        this.return_id = return_id;
        this.return_quantity = return_quantity;
        this.return_date = return_date;
    }
}
