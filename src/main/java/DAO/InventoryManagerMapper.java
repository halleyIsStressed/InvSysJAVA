package DAO;

import Entity.User;

import java.util.List;

public interface InventoryManagerMapper {

    void insert(User inventoryManager);

    List<User> selectALL();

    User selectByIdAndPassword( String id);
}