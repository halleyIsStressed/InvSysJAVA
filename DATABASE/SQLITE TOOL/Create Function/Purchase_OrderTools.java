package SQLTools;

import Database.SQLConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class Purchase_OrderTools {
    public static void createTablePurchaseOrder() {
        SQLConnection sqlConnection = new SQLConnection();

        try {
            Connection connection = sqlConnection.getConnection();
            Statement stmt = connection.createStatement();
            String createTablePurchaseOrder = """
                   CREATE TABLE IF NOT EXISTS PURCHASE_ORDER (
                        PRODUCT_ID INT PRIMARY KEY,
                        SUPPLIER_ID INT PRIMARY KEY,
                        PO_NUMBER INT NOT NULL,
                        QUANTITY INT NOT NULL,
                        ORDER_DATE DATE NOT NULL,
                        PRICE INT NOT NULL,
                        FOREIGN KEY (SUPPLIER_ID) REFERENCES SUPPLIER(SUPPLIER_ID)
                   );
                  """;
            stmt.executeUpdate(createTablePurchaseOrder);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
