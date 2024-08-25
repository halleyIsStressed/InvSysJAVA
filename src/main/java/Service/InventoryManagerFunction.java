package Service;

import DAO.InventoryManagerMapper;
import DAO.ProductMapper;
import Database.Database;
import Entity.InventoryManager;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class InventoryManagerFunction {
    public static InventoryManager getInput() {

        String position = "";
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
        System.out.print("""
                1) Inventory Manager
                2) Staff
                Enter your position :""");
        option = in.nextInt();
        if (option == 1) {
            position = "Inventory Manager";
        } else if (option == 2) {
            position = "Staff";
        }
        return new InventoryManager(password, name, age, gender, phone, position);
    }

    public static void signUp(){
        InventoryManager insertInventoryM = getInput();

        try (SqlSession conn = Database.getInstance().openSession()) {
            InventoryManagerMapper inventoryManagerMapper = conn.getMapper(InventoryManagerMapper.class);
            inventoryManagerMapper.insert(insertInventoryM);
            conn.commit();
        }

    }

    public static void getLogin() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your id: ");
        int id = in.nextInt();
        System.out.println("Enter your password: ");
        String password = in.next();
        information(id, password);
    }

    public static InventoryManager information(int id, String password)  {
        InventoryManager currentInventoryManager;
        try (SqlSession conn = Database.getInstance().openSession()) {
            InventoryManagerMapper inventoryManagerMapper = conn.getMapper(InventoryManagerMapper.class);
            inventoryManagerMapper.selectByIdAndPassword(id, password);
            currentInventoryManager = inventoryManagerMapper.selectByIdAndPassword(id, password);
        }

        if (currentInventoryManager != null) {
            System.out.println("Name:" + currentInventoryManager.getName());
            System.out.println("Gender:" + currentInventoryManager.getGender());
            System.out.println("Age:" + currentInventoryManager.getAge());
            System.out.println("Phone:" + currentInventoryManager.getPhone());
            System.out.println("Position:" + currentInventoryManager.getPosition());
        } else {
            System.out.println("No user found with the given ID and password.");
        }
        return  currentInventoryManager;
    }

}
