package Entity;



public class Stock_Transfer {
    private  String transfer_id;
    private  String product_id;
    private  String branch_id;
    private int transfer_quantity;
    private String request_date;
    private String status;


    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(String transfer_id) {
        this.transfer_id = transfer_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getTransfer_quantity() {
        return transfer_quantity;
    }

    public void setTransfer_quantity(int transfer_quantity) {
        this.transfer_quantity = transfer_quantity;
    }

    public String getRequest_date() {
        return request_date;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Stock_Transfer( String transfer_id, String product_id,  String branch_id, int transfer_quantity, String transfer_date, String status) {
        this.transfer_id = transfer_id;
        this.product_id = product_id;
        this.branch_id = branch_id;
        this.transfer_quantity = transfer_quantity;
        this.request_date = transfer_date;
        this.status = status;
    }

    public Stock_Transfer() {

    }
}
