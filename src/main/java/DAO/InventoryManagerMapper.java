package DAO;

import Entity.InventoryManager;
import Entity.Product;

import java.util.List;

public interface InventoryManagerMapper {

    void insert(InventoryManager inventoryManager);

    List<InventoryManager> selectALL();

    InventoryManager selectByIdAndPassword(int id, String password);
}