package Service;

import DAO.InventoryManagerMapper;
import Database.Database;
import Entity.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Scanner;

public class UserMenuFunction {
    public static User getInventoryMInput() {

        String position = "Inventory Manager";
        String gender = "";
        Scanner in = new Scanner(System.in);
        int option;
        System.out.print("Enter Password: ");
        String password = in.next();
        System.out.print("Enter name: ");
        String name = in.next();
        System.out.print("Enter age: ");
        int age = in.nextInt();
        System.out.print("""
                1) Male
                2) Female
                Enter gender:""");
        option = in.nextInt();
        if (option == 1) {
            gender = "Male";
        } else if (option == 2) {
            gender = "Female";
        }
        System.out.print("Enter phone: ");
        String phone = in.next();
        return new User(password, name, age, gender, phone, position);
    }

    public static User getStaffInput(){
        String position = "Staff";
        String gender = "";
        Scanner in = new Scanner(System.in);
        int option;
        System.out.print("Enter Password: ");
        String password = in.next();
        System.out.print("Enter name: ");
        String name = in.next();
        System.out.print("Enter age: ");
        int age = in.nextInt();
        System.out.print("""
                1) Male
                2) Female
                Enter gender:""");
        option = in.nextInt();
        if (option == 1) {
            gender = "Male";
        } else if (option == 2) {
            gender = "Female";
        }
        System.out.print("Enter phone: ");
        String phone = in.next();
        return new User(password, name, age, gender, phone, position);
    }


    public static void signUp(){
        User insertInventoryM = getInventoryMInput();

        try (SqlSession conn = Database.getInstance().openSession()) {
            InventoryManagerMapper inventoryManagerMapper = conn.getMapper(InventoryManagerMapper.class);
            inventoryManagerMapper.insert(insertInventoryM);
            conn.commit();
        }

    }

    public static void getLogin() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your id: ");
        String id = in.next();
        System.out.println("Enter your password: ");
        String password = in.next();
        information(id, password);
    }

    public static User information( String id, String password)  {
        User currentInventoryManager = null;
        try (SqlSession conn = Database.getInstance().openSession()) {
             InventoryManagerMapper inventoryManagerMapper = conn.getMapper(InventoryManagerMapper.class);
             currentInventoryManager = inventoryManagerMapper.selectByIdAndPassword(id);
        }

        if (currentInventoryManager != null) {
            if (currentInventoryManager.getPassword().equals(password)) {
                System.out.println("Name:" + currentInventoryManager.getName());
                System.out.println("Gender:" + currentInventoryManager.getGender());
                System.out.println("Age:" + currentInventoryManager.getAge());
                System.out.println("Phone:" + currentInventoryManager.getPhone());
                System.out.println("Position:" + currentInventoryManager.getPosition());
            }
            else {
                System.out.println("Wrong Password");
            }
        } else {
            System.out.println("No user found.");
        }


        return  currentInventoryManager;
    }

}
