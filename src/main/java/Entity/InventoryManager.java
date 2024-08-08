package Entity;

import DAO.InventoryManagerDAO;
import SQLTools.InventoryManagerTools;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

@Data
@AllArgsConstructor
public class InventoryManager {
     private int id;
     private String password;
     private String name;
     private int age;
     private String gender;
     private String phone;
     private String position;
}
