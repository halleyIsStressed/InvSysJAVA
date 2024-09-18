package Service;

import DAO.InventoryManagerMapper;
import Database.Database;
import Design.Design;
import Entity.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Scanner;

public class InventoryManagerMenu {
      public static void InventoryManagerMenu(int choice) throws IOException {
            Scanner sc = new Scanner(System.in);
            boolean keepRunning = true;

            while (keepRunning) {
                  Design.DesignLOGO();

                  int option = 0;
                  boolean validInput = false;

                  while (!validInput) {
                        System.out.print("""
                    1) Log In
                    2) Exit
                    Enter your option:""");

                        if (sc.hasNextInt()) {
                              option = sc.nextInt();
                              validInput = true;
                        } else {
                              System.out.println("Invalid input. Please enter a number between 1 and 3.");
                              sc.next();
                        }
                  }

                  switch (option) {
                        case 1:
                              selectInformation(choice);
                              break;
                        case 2:
                              System.out.println("Exiting the program...");
                              keepRunning = false;
                              break;
                        default:
                              System.out.println("Invalid option. Please select a valid option between 1 and 3.");
                              break;
                  }
            }
      }

      public static User getLogin() {
            Scanner inp = new Scanner(System.in);
            User login = new User();
            System.out.println("Enter your id: ");
            login.setId(inp.next());
            System.out.println("Enter your password: ");
            login.setPassword(inp.next());
            return login;
      }

      public static void selectInformation(int choice) throws IOException {
            User login = getLogin();
            User currentUser = null;

            try (SqlSession conn = Database.getInstance().openSession()) {
                  InventoryManagerMapper IMMapper = conn.getMapper(InventoryManagerMapper.class);
                currentUser=IMMapper.selectByIdAndPassword(login.getId());
            }
            if (currentUser != null) {
                  if (currentUser.getPassword().equals(login.getPassword())) {
                        System.out.println("You have successfully logged in!");
                        System.out.println(" \n*****************************************\n");
                        System.out.println(         "Inventory Manager Profile");
                        System.out.println("\n*****************************************\n");
                        System.out.println(currentUser);
                        ProfileMenu.profileList(currentUser.getId(),choice);
                  } else {
                        System.out.println("Wrong Password");
                  }
            }
            else{
                  System.out.println("Wrong ID");
            }

      }
}
