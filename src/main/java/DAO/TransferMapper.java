package DAO;

import Entity.Stock_Transfer;

import java.util.List;

public interface TransferMapper {
    List<Stock_Transfer> selectPendingTransfers();


}
