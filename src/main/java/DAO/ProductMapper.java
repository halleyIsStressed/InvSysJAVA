package DAO;

import Entity.Product;
import org.apache.ibatis.annotations.Param;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProductMapper {

    void insertProduct(Product product);

    List<Product> selectALLProduct();

    List<Product> selectTargetType(String product_type);

    Product selectById (String product_id);

    void deleteProductById (@NotNull String product_id);

    void updateModifyData(Product product);

    List<Product> selectMaxandMinPrice(@Param("param1") double minPrice, @Param("param2") double maxPrice);
}
