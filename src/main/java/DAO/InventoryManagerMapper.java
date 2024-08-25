package DAO;

import Entity.InventoryManager;

import java.util.List;

public interface InventoryManagerMapper {

    void insert(InventoryManager inventoryManager);

    List<InventoryManager> selectALL();

    InventoryManager selectByIdAndPassword(int id);
}