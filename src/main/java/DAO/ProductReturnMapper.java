package DAO;

import Entity.Purchase_Order;
import Entity.ReturnOrder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProductReturnMapper {

    void insertRo(ReturnOrder newReturnOrder);

    List<ReturnOrder> selectRoFromSupplier(String supplier_id);

    ReturnOrder selectRoByProduct(String product_id);

}
