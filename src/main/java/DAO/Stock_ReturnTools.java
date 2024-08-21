package DAO;

import Database.SQLConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Stock_ReturnTools {
    public static void createTableStockReturn() {
        SQLConnection sqlConnection = new SQLConnection();

        try {
            Connection connection = sqlConnection.getConnection();
            Statement stmt = connection.createStatement();
            String createTableStock_Return = """
                   CREATE TABLE IF NOT EXISTS STOCK_RETURN(
                    RETAILER_ID INT PRIMARY KEY,
                    PRODUCT_ID INT PRIMARY KEY,
                    RETURN_ID INT NOT NULL,
                    QUANTITY INT NOT NULL,
                    RETURN_DATE DATE NOT NULL,
                    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID),
                    FOREIGN KEY (RETAILER_ID) REFERENCES RETAILER(RETAILER_ID)
                   );
                  """;
            stmt.executeUpdate(createTableStock_Return);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
