package DAO;

import Entity.Product;
import Entity.Stock_Transfer;

import java.util.List;

public interface TransferMapper {
    List<Stock_Transfer> selectPendingTransfers();

    void insertRequest(Stock_Transfer stock_transfer);
}
