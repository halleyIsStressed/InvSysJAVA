package SQLTools;

import Database.SQLConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Return_OrderTools {
    public static void createTableReturnOrder() {
        SQLConnection sqlConnection = new SQLConnection();
        try {
            Connection connection = sqlConnection.getConnection();
            Statement stmt = connection.createStatement();
            String createTableReturnOrder = """
                   CREATE TABLE IF NOT EXISTS RETURN_ORDER (
                       RETURN_ID INT PRIMARY KEY,
                       SUPPLIER_ID INT PRIMARY KEY,
                       PRODUCT_ID INT PRIMARY KEY,
                       QUANTITY INT NOT NULL,
                       RETURN_DATE DATE NOT NULL,
                       RETURN_REASON VARCHAR(200) NOT NULL,
                       FOREIGN KEY (SUPPLIER_ID) REFERENCES SUPPLIER(SUPPLIER_ID),
                       FOREIGN KEY  (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)
                   );
                  """;
            stmt.executeUpdate(createTableReturnOrder);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
