package DAO;

import Entity.InventoryManager;

public interface InventoryManagerMapper {

    void insert(InventoryManager inventoryManager);

    InventoryManager selectByIdAndPassword(int id, String password);
}