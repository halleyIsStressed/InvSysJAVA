package DAO;

import Entity.User;


public interface InventoryManagerMapper {


    User selectByIdAndPassword( String id);
}