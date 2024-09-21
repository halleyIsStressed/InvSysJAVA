package Entity;

public class Product {

    private String product_id;
    private String product_type;
    private String product_name;
    private double product_price;
    private int product_quantity;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public Product(String product_id, String product_type, String product_name, double product_price, int product_quantity) {
        this.product_id = product_id;
        this.product_type = product_type;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
    }

    public Product() {

    }


    @Override
    public String toString(){
        return  "*****************************************"+
                "\nID: "+ product_id +
                "\nType: "+product_type+
                "\nName: "+product_name+
                "\nPrice: "+product_price+
                "\nQuantity: "+product_quantity+
                "\n*****************************************";
    }
}
