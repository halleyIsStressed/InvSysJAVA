package DAO;

import Entity.Product;
import Entity.Stock_Transfer;

import java.util.List;

public interface TransferMapper {
    List<Stock_Transfer> selectPendingTransfers();

    void updateStatus(Stock_Transfer stock_transfer);

    Stock_Transfer selectBYID(String transfer_id);

    void deleteTransferQequest(Stock_Transfer stock_transfer);

    List<Stock_Transfer> selectTransfers();
}
