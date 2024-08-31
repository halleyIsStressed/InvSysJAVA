package Service;

import DAO.InventoryManagerMapper;
import DAO.StaffMapper;
import Database.Database;
import Design.Design;
import Entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;


public class UserMenuFunction {

    public static void mainMenu(int choice) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            Design.DesignLOGO();
            System.out.print("""
                    1) Sign Up
                    2) Log In
                    3) Exit
                    Enter your option:
                    """);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    signUp(choice);
                    break;
                case 2:
                   selectInformation(choice);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static User getLogin() {
        Scanner in = new Scanner(System.in);
        User login = new User();
        System.out.println("Enter your id: ");
        login.setId(in.nextLine());
        System.out.println("Enter your password: ");
        login.setPassword(in.nextLine());
        return login;
    }

    public static void selectInformation(int choice)  {
        User login = getLogin();
        User currentUser = null;

        switch (choice) {
            case 1:
                try (SqlSession conn = Database.getInstance().openSession()) {
                    InventoryManagerMapper inventoryManagerMapper = conn.getMapper(InventoryManagerMapper.class);
                    currentUser = inventoryManagerMapper.selectByIdAndPassword(login.getId());
                }
                break;
            case 2:
                try (SqlSession conn = Database.getInstance().openSession()) {
                   StaffMapper staffMapper = conn.getMapper(StaffMapper.class);
                   currentUser = staffMapper.selectByIdAndPassword(login.getId());
                }
                break;
        }
        if (currentUser != null) {
            if (currentUser.getPassword().equals(login.getPassword())) {
                System.out.println("Name:" + currentUser.getName());
                System.out.println("Gender:" + currentUser.getGender());
                System.out.println("Age:" + currentUser.getAge());
                System.out.println("Phone:" + currentUser.getPhone());
                System.out.println("Position:" + currentUser.getPosition());
            } else {
                System.out.println("Wrong Password");
            }
        }
        else{
            System.out.println("Wrong ID");
        }


    }

    public static User getInput(int option) {


        User user = new User();
        if (option == 1) {
            user.setPosition("Inventory Manager");
        } else {
            user.setPosition("Staff");
        }
        boolean check = false;
        Scanner in = new Scanner(System.in);
        int selection;
        System.out.print("Enter name: ");
        user.setName(in.nextLine());
        System.out.print("Enter Password: ");
        user.setPassword(in.nextLine());
        System.out.print("Enter age: ");
        user.setAge(in.nextInt());
        System.out.print("""
                1) Male
                2) Female
                Enter gender:""");
        selection = in.nextInt();
        do {
            if (selection == 1) {
                user.setGender("Male");
                check = true;
            } else if (selection == 2) {
                user.setGender("Female");
                check = true;
            } else {
                System.out.print("Error");
            }
        } while (!check);
        in.nextLine();
        System.out.print("Enter phone: ");
        user.setPhone(in.nextLine());
        return user;
    }

    public static void signUp(int choice) {
        User insertInput = getInput(choice);
        if (choice == 1) {
            try (SqlSession conn = Database.getInstance().openSession()) {
                InventoryManagerMapper inventoryManagerMapper = conn.getMapper(InventoryManagerMapper.class);
                inventoryManagerMapper.insert(insertInput);
                conn.commit();
            }
        } else {
            try (SqlSession conn = Database.getInstance().openSession()) {
                StaffMapper staffMapper = conn.getMapper(StaffMapper.class);
                staffMapper.insert(insertInput);
                conn.commit();
            }
        }
    }
}