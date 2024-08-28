package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Supplier {
    private  String supplierID;
    private String supplierName;
    private String supplierTel;
    private String supplierAddress;
    private String supplierEmail;

    //Constructor
    public Supplier( String id, String name, String tel, String address, String email){
        this.supplierID = id;
        this.supplierName = name;
        this.supplierTel = tel;
        this.supplierAddress = address;
        this.supplierEmail = email;
    }

    public Supplier(String supplierName, String supplierTel, String supplierAddress, String supplierEmail) {
        this.supplierName = supplierName;
        this.supplierTel = supplierTel;
        this.supplierAddress = supplierAddress;
        this.supplierEmail = supplierEmail;
    }


    public Supplier() {

    }
}
