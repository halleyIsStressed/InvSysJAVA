package DAO;

import Entity.User;


public interface InventoryManagerMapper {

    void insert(User inventoryManager);


    User selectByIdAndPassword( String id);
}