package SQLTools;

import Database.SQLConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductTools {
    public static void CreateTableProduct() {
        SQLConnection sqlConnection = new SQLConnection();

        try {
            Connection connection = sqlConnection.getConnection();
            Statement stmt = connection.createStatement();
            String createTableProduct = """
                   CREATE TABLE IF NOT EXISTS PRODUCT (
                        PRODUCT_ID INT PRIMARY KEY,
                        PRODUCT_TYPE VARCHAR(20) NOT NULL,
                        PRODUCT_NAME VARCHAR(20) NOT NULL,
                        PRODUCT_PRICE DOUBLE NOT NULL, 
                        PRODUCT_QUANTITY INT NOT NULL
                   );
                  """;
            stmt.executeUpdate(createTableProduct);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
