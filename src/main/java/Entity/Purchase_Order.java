package Entity;

public class Purchase_Order {
    private String po_number;
    private String supplier_id;
    private String product_id;
    private int purchase_quantity;
    private double order_price;
    private String order_date;
    private String status;

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public String getPo_number() {
        return po_number;
    }

    public void setPo_number(String po_number) {
        this.po_number = po_number;
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

    public int getPurchase_quantity() {
        return purchase_quantity;
    }

    public void setPurchase_quantity(int purchase_quantity) {
        this.purchase_quantity = purchase_quantity;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Purchase_Order(String po_number, String supplier_id, String product_id, int purchase_quantity, double order_price, String order_date, String status) {
        this.po_number = po_number;
        this.supplier_id = supplier_id;
        this.product_id = product_id;
        this.purchase_quantity = purchase_quantity;
        this.order_price = order_price;
        this.order_date = order_date;
        this.status = status;
    }




    public Purchase_Order() {

    }
}
