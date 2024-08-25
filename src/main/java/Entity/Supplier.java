package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Supplier {
    private int supplierID;
    private String supplierName;
    private String supplierTel;
    private String supplierAddress;
    private String supplierEmail;

    //Constructor
    public Supplier(int id, String name, String tel, String address, String email){
        this.supplierID = id;
        this.supplierName = name;
        this.supplierTel = tel;
        this.supplierAddress = address;
        this.supplierEmail = email;
    }
}
