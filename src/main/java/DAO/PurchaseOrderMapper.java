package DAO;
import Entity.Product;
import Entity.Purchase_Order;

import java.util.List;


public interface PurchaseOrderMapper {
    List<Purchase_Order> selectALLpo();

    public interface POMapper {

        List<Purchase_Order> selectALLpo();

    }

}
