package Entity;


public class Supplier {
    private String supplierID;
    private String supplierName;
    private String supplierTel;
    private String supplierAddress;
    private String supplierEmail;
    private String supplierDateTimeCreated;

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierDateTimeCreated() {
        return supplierDateTimeCreated;
    }

    public void setSupplierDateTimeCreated(String supplierDateTimeCreated) {
        this.supplierDateTimeCreated = supplierDateTimeCreated;
    }



    //Constructor
    public Supplier(String id, String name, String tel, String address, String email, String dateTime){
        this.supplierID = id;
        this.supplierName = name;
        this.supplierTel = tel;
        this.supplierAddress = address;
        this.supplierEmail = email;
        this.supplierDateTimeCreated = dateTime;
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
                "\nDate & Time created: "+supplierDateTimeCreated+
                "\n*****************************************";
    }
}
