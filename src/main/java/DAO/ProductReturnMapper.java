package DAO;

import Entity.Purchase_Order;
import Entity.ReturnOrder;
import org.apache.ibatis.annotations.Param;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProductReturnMapper {

    void insertRo(ReturnOrder newReturnOrder);

    List<ReturnOrder> selectRoFromSupplier(String supplier_id);

    List<ReturnOrder> selectRoByProduct(String product_id);

    List<ReturnOrder>selectReturnByDate (@Param("param1") String startDate, @Param("param2") String endDate);

    List<ReturnOrder> selectAllRo ();
}
