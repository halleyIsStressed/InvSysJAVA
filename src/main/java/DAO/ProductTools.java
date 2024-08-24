package DAO;

import Database.SQLConnection;
import Entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

    public static List<Product> getAllProducts() {
        // TODO: Do code for getting all products in PRODUCT table here.
        // If we have many products, you may need to paginate the output.
        // Eg. 10 items per page. I will write the next page/previous page logic myself.
        // Delete this once you start work
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
