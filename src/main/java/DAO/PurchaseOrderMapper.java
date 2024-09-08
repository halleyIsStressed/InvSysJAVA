package DAO;
import Entity.Product;
import Entity.Purchase_Order;
import Entity.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public interface PurchaseOrderMapper {
    List<Purchase_Order> selectALLpo();

    void insertPo(Purchase_Order purchase_order);

    List<Purchase_Order> selectIDfortaget(String supplier_id);

    Purchase_Order selectBYPOID(String product_id);

    void cancelPoByID (@NotNull String po_number);

    void updateModifyData(Purchase_Order product);

}
