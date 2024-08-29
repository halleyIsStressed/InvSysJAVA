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
    private String dateTimeCreated;

    //Constructor
    public Supplier(int id, String name, String tel, String address, String email, String dateTime){
        this.supplierID = id;
        this.supplierName = name;
        this.supplierTel = tel;
        this.supplierAddress = address;
        this.supplierEmail = email;
        this.dateTimeCreated = dateTime;
    }

    //Getters and Setters
    public int getSupplierID(){
        return supplierID;
    }
    public void setSupplierID(int id){
        this.supplierID = id;
    }
    public String getSupplierName(){
        return supplierName;
    }
    public void setSupplierName(String name){
        this.supplierName = name;
    }
    public String getSupplierTel(){
        return supplierTel;
    }
    public void setSupplierTel(String tel){
        this.supplierTel = tel;
    }
    public String getSupplierAddress(){
        return supplierAddress;
    }
    public void setSupplierAddress(String address){
        this.supplierAddress = address;
    }
    public String getSupplierEmail(){
        return supplierEmail;
    }
    public void setSupplierEmail(String email){
        this.supplierEmail= email;
    }

    public String getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(String dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

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
