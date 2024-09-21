package Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ReturnOrder {
    private String return_id;
    private String supplier_id;
    private String product_id;
    private String return_date;
    private String return_reason;
    private int quantity;

    public String getReturn_reason() {
        return return_reason;
    }

    public void setReturn_reason(String return_reason) {
        this.return_reason = return_reason;
    }

    public String getReturn_id() {
        return return_id;
    }

    public void setReturn_id(String return_id) {
        this.return_id = return_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public ReturnOrder(String return_id, String supplier_id, String product_id, String return_reason, String return_date, int quantity) {
        this.return_id = return_id;
        this.supplier_id = supplier_id;
        this.product_id = product_id;
        this.return_reason = return_reason;
        this.return_date = return_date;
        this.quantity = quantity;
    }


}
