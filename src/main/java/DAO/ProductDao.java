package DAO;

import Entity.InventoryManager;
import Entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    @Select("SELECT * FROM PRODUCT")
    List<Product> selectALLProduct();

    @Insert("INSERT INTO PRODUCT (PRODUCT_TYPE,PRODUCT_NAME,PRODUCT_PRICE) VALUES (#{product_type},#{product_name},#{product_price})")
    void insertProduct(Product product);
}
