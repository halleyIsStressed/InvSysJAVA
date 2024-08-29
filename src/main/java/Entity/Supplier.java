package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Supplier {
    private String supplierID;
    private String supplierName;
    private String supplierTel;
    private String supplierAddress;
    private String supplierEmail;
    private String dateTimeCreated;

    //Constructor
    public Supplier(String id, String name, String tel, String address, String email, String dateTime){
        this.supplierID = id;
        this.supplierName = name;
        this.supplierTel = tel;
        this.supplierAddress = address;
        this.supplierEmail = email;
        this.dateTimeCreated = dateTime;
    }

    public Supplier() {}

    @Override
    public String toString(){
        return  "*****************************************"+
                "\nSupplier's Info:"+
                "\nID: "+ supplierID +
                "\nName: "+supplierName+
                "\nTelephone: "+supplierTel+
                "\nAddress: "+supplierAddress+
                "\nEmail: "+supplierEmail+
                "\nDate & Time created: "+dateTimeCreated+
                "\n*****************************************";
    }

//    public Supplier(String supplierName, String supplierTel, String supplierAddress, String supplierEmail) {
//        this.supplierName = supplierName;
//        this.supplierTel = supplierTel;
//        this.supplierAddress = supplierAddress;
//        this.supplierEmail = supplierEmail;
//    }
//
//
//    public Supplier() {
//
//    }
}
