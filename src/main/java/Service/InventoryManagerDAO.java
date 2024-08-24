package Service;

import Entity.InventoryManager;
import DAO.InventoryManagerTools;

import java.util.List;
import java.util.Scanner;

public class InventoryManagerDAO {


    public static InventoryManager getInput(){

            String position = "";
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Inventory ID: ");
            int id = in.nextInt();
            System.out.println("Enter Password: ");
            String password = in.next();
            System.out.println("Enter name: ");
            String name = in.next();
            System.out.println("Enter age: ");
            int age = in.nextInt();
            System.out.println("Enter gender: ");
            String gender = in.next();
            System.out.println("Enter phone: ");
            String phone = in.next();
            System.out.println("""
                1) Inventory Manager
                2)Staff
                Enter your position :
                """);
            int opption = in.nextInt();
            if (opption==1){
                position="Inventory Manager";
            }
            else if (opption==2){
                position="Staff";
            }

            return new InventoryManager(id,name,password, age, gender, phone, position);
    }

    public static void signUp(){
        InventoryManagerTools.createTableInventoryManager();
        InventoryManager insertInventoryM=getInput();
        InventoryManagerTools.insertInventoryManager(insertInventoryM);
    }

    public static void loginFunction(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your id: ");
        int id = in.nextInt();
        System.out.println("Enter your password: ");
        String password = in.next();
        information(id,password);
    }

    public static void information(int id, String password){
        List<InventoryManager> inventoryManagers = InventoryManagerTools.checkLogin(id,password);

        if (!inventoryManagers.isEmpty()) {
            for (InventoryManager inventoryManager : inventoryManagers) {
            System.out.println("Name: " + inventoryManager.getName());
            System.out.println("Age: " + inventoryManager.getAge());
            System.out.println("Gender: " + inventoryManager.getGender());
            System.out.println("Phone: " + inventoryManager.getPhone());
            System.out.println("Position: " + inventoryManager.getPosition());
            }
        } else {
            System.out.println("Inventory Manager not found.");
        }
    }

}
