package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Supplier {
    private int supplier_id;
    private String supplier_name;
    private String contact_no;

    public Supplier(int supplier_id, String supplier_name, String contact_no) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.contact_no = contact_no;
    }
}
