package DAO;

import Entity.InventoryManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface InventoryManagerDao {

    @Insert("INSERT INTO InventoryManager (PASSWORD, NAME, AGE, GENDER, PHONE, POSITION) VALUES (#{password}, #{name}, #{age}, #{gender}, #{phone}, #{position})")
    void insert(InventoryManager inventoryManager);

    @Select("SELECT * FROM InventoryManager WHERE ID = #{id} AND PASSWORD = #{password}")
    InventoryManager selectByIdAndPassword(InventoryManager inventoryManager);

}