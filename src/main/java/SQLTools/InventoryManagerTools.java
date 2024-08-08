package SQLTools;

import Database.SQLConnection;
import Entity.InventoryManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManagerTools {
    public static void insertInventoryManager (InventoryManager inventoryManager){
        Connection conn = SQLConnection.instance.getConnection();
        String insertDataSQL = "INSERT INTO InventoryManager (ID,PASSWORD,NAME,AGE ,GENDER,PHONE ,POSITION) VALUES (?,?, ?, ?, ?,?,?)";

        try (
                PreparedStatement pstmt = conn.prepareStatement(insertDataSQL)
        ){
            pstmt.setInt(1,inventoryManager.getId());
            pstmt.setString(2,inventoryManager.getPassword());
            pstmt.setString(3,inventoryManager.getName());
            pstmt.setInt(4, inventoryManager.getAge());
            pstmt.setString(5, inventoryManager.getGender());
            pstmt.setString(6, inventoryManager.getPhone());
            pstmt.setString(7, inventoryManager.getPosition());

            pstmt.executeUpdate();
            System.out.println("Data inserted successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createTableInventoryManager (){
        Connection conn = SQLConnection.instance.getConnection();

        try {
            Statement stmt = conn.createStatement();
                String createTableStaff = """
                   CREATE TABLE IF NOT EXISTS InventoryManager (
                        ID INT PRIMARY KEY,   
                        PASSWORD VARCHAR(20),      
                        NAME TEXT NOT NULL,
                        AGE INT,
                        GENDER TEXT,                  
                        PHONE TEXT,
                        POSITION TEXT NOT NULL
                   );
                  """;
                    stmt.executeUpdate(createTableStaff);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<InventoryManager> checkLogin(int id, String password) {
        List<InventoryManager> inventoryManagers = new ArrayList<>();
        Connection conn = SQLConnection.instance.getConnection();
       System.out.println("hello");
        try (
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM InventoryManager WHERE ID = ? AND PASSWORD = ?;")) {

            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                InventoryManager inventoryManager = new InventoryManager(
                        rs.getInt("ID"),
                        rs.getString("PASSWORD"),
                        rs.getString("NAME"),
                        rs.getInt("AGE"),
                        rs.getString("GENDER"),
                        rs.getString("PHONE"),
                        rs.getString("POSITION")
                );
                inventoryManagers.add(inventoryManager);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventoryManagers;
    }


}
