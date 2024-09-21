package DAO;

import Entity.InventoryManager;
import Entity.User;


public interface InventoryManagerMapper {


    InventoryManager selectByIdAndPassword(String id);
}