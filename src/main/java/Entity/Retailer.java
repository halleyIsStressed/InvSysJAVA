package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Retailer {


    private String retailer_id;
    private String retailer_location;
    private String contact_no;

    public Retailer(String retailer_id, String retailer_location, String contact_no) {
        this.retailer_id = retailer_id;
        this.retailer_location = retailer_location;
        this.contact_no = contact_no;
    }

}
