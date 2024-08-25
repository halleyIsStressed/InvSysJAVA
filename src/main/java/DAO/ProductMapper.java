package DAO;

import Entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    List<Product> selectALLProduct();



    void insertProduct(Product product);
}
