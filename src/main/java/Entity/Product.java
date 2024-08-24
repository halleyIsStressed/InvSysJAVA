package Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    int product_id;
    productType product_type;
    String product_name;
    double product_price;
    int product_qty;

}
