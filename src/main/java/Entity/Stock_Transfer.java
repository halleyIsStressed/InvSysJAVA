package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Stock_Transfer {
    private  String transfer_id;
    private  String product_id;
    private  String branch_id;
    private int transfer_quantity;
    private String request_date;
    private String status;

    public Stock_Transfer( String transfer_id, String product_id,  String branch_id, int transfer_quantity, String transfer_date, String status) {
        this.transfer_id = transfer_id;
        this.product_id = product_id;
        this.branch_id = branch_id;
        this.transfer_quantity = transfer_quantity;
        this.request_date = transfer_date;
        this.status = status;
    }
}
