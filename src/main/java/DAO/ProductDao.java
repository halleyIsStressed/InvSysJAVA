package DAO;

import Entity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    @Select("SELECT * FROM PRODUCT")
    List<Product> selectALLProduct();

}
