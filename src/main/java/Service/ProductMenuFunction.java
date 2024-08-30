package Service;


import DAO.ProductMapper;
import Database.Database;
import Entity.Product;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ProductMenuFunction {
    public static void productListing() throws IOException {

        int productMenuOptions;
        do {
            Scanner sc = new Scanner(System.in);
            List<Product> productList;
            try (SqlSession conn = Database.getInstance().openSession()) {
                ProductMapper productMapper = conn.getMapper(ProductMapper.class);
                productList = productMapper.selectALLProduct();
            }


            System.out.printf("%-6s | %-10s | %-20s | %-7s | %-5s\n\n", "ID", "Type", "Name", "Price", "Qty");
            for (Product product : productList) {
                System.out.printf("%-6s | %-10s | %-20s | %-7.2f | %-5d\n",
                    product.getProduct_id(),
                    product.getProduct_type(),
                    product.getProduct_name(),
                    product.getProduct_price(),
                    product.getProduct_qty());
            }
            System.out.print("\n\n");
            System.out.println("Choose Option:");
            System.out.println("1 > Add Product");
            System.out.println("2 > Search Product");
            System.out.println("3 > Edit Product");
            System.out.println("4 > Delete Product");
            System.out.println("5 > Return");
            productMenuOptions = sc.nextInt();

            switch (productMenuOptions) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    searchProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    // fuckOff();
                    break;
                default:
                    System.out.println("Invalid Option. Try Again.");
                    System.in.read(); // This is supposed to be unread, dw
                    System.out.print("\n\n");
            }
        } while (productMenuOptions != 5);
    }

    public static Product getaddProduct(){

        Product newProducts = new Product();
        Scanner newProductScanner = new Scanner(System.in);
        System.out.print("\nEnter product type (Rod, Reel, Line, Lure, Accessory): ");
        newProducts.setProduct_type(newProductScanner.nextLine());
        System.out.print("\nEnter product name: ");
        newProducts.setProduct_name(newProductScanner.nextLine());
        System.out.print("\nEnter product price: ");
        newProducts.setProduct_price(newProductScanner.nextDouble());

        System.out.print("\n\n");
        System.out.println("Product inserted into Database!");
        return newProducts;
    }

    //Database connection
    public static  void addProduct(){
        Product newProducts = getaddProduct();
        try (SqlSession conn = Database.getInstance().openSession()) {
            ProductMapper productMapper = conn.getMapper( ProductMapper.class);
            productMapper.insertProduct(newProducts);
            conn.commit();
        }
    }

    public static void searchProduct() throws IOException {
        // More akin to a Filtering function.
        Scanner sc = new Scanner(System.in);
        int filterOptions;
        do {
        System.out.println("Choose Filter Method:");
        System.out.println("1 > Type");
        System.out.println("2 > Price");
        System.out.println("3 > Return");
        filterOptions = sc.nextInt();

            switch (filterOptions) {
            case 1:
                Scanner typeSc = new Scanner(System.in);
                String targetType;
                int typeSorter;
                do {
                    System.out.println("Choose Type:");
                    System.out.println("1 > Rod");
                    System.out.println("2 > Reel");
                    System.out.println("3 > Line");
                    System.out.println("4 > Lure");
                    System.out.println("5 > Accessory");
                    System.out.println("6 > Return");
                    typeSorter = typeSc.nextInt();

                    // TODO Ahdan - Use a singular function, receive "targetType" as a parameter for query using WHERE. Display all products that fit that condition.
                    switch (typeSorter) {
                        case 1:
                            targetType = "Rod";
                            // Here

                            break;
                        case 2:
                            targetType = "Reel";
                            // Here

                            break;
                        case 3:
                            targetType = "Line";
                            // Here

                            break;
                        case 4:
                            targetType = "Lure";
                            // Here

                            break;
                        case 5:
                            targetType = "Accessory";
                            // Here

                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Invalid Input. Try Again.");
                            System.in.read();
                            break;
                    }
                } while(typeSorter != 6);
                break;

                case 2:
                    Scanner priceSc = new Scanner(System.in);
                    double minPrice, maxPrice;
                        System.out.print("Enter minimum price: ");
                        minPrice = priceSc.nextDouble();
                        System.out.print("Enter maximum price: ");
                        maxPrice = priceSc.nextDouble();

                        // TODO AhDan - Use minPrice and maxPrice to SELECT products using WHERE product_price BETWEEN statement.
                break;

                case 3:
                break;

                default:
                System.out.println("Invalid Option. Try Again.");
                System.in.read();
                break;

            }
        } while (filterOptions != 3);
    }



    public static void updateProduct() {

        Product targetProduct = new Product();
        int targetID;
        int choice;
        double newPrice;
        String newValue;
        Scanner targetProductScanner = new Scanner(System.in);
        Scanner choiceScanner = new Scanner(System.in);

        System.out.print("Enter Target Product ID: ");
        targetID = targetProductScanner.nextInt();

        // TODO Ahdan : Search PRODUCT table for matching ID using WHERE statement. Return the whole row into targetProduct.

        do {
            System.out.println("Choose value to modify:");
            System.out.println("1 > Type");
            System.out.println("2 > Name");
            System.out.println("3 > Price");
            System.out.println("4 > Return");

            choice = choiceScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter new Type (Rod, Reel, Line, Lure, Accessory): ");
                    targetProduct.setProduct_type(choiceScanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter new Name: ");
                    targetProduct.setProduct_name(choiceScanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter new Price: ");
                    targetProduct.setProduct_price(choiceScanner.nextDouble());
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);

        System.out.println("Item Successfully Modified!");
    }

    public static void deleteProduct() {
        int confirmation;
        int targetID;
        Scanner targetProductScanner = new Scanner(System.in);
        Scanner confirmationScanner = new Scanner(System.in);

        //  TODO Ahdan : Find product using targetID, save row into targetProduct, display contents and check quantity.
        System.out.print("Enter Product ID: ");
        targetID = targetProductScanner.nextInt();
        Product targetProduct = new Product();

        System.out.printf("%-6s | %-10s | %-20s | %-7.2f | %-5d\n",
                targetProduct.getProduct_id(),
                targetProduct.getProduct_type(),
                targetProduct.getProduct_name(),
                targetProduct.getProduct_price(),
                targetProduct.getProduct_qty());

        if (targetProduct.getProduct_qty() > 0) {
            System.out.print("\nWARNING: STOCK RECORD PRESENT FOR THE TARGETED ITEM. ARE YOU SURE YOU WOULD LIKE TO REMOVE THIS PRODUCT FROM THE DATABASE?\n");
        }
        else
        {
            System.out.println("Are you sure you would like to remove this product from the database?\n");
        }
        System.out.print("Enter 1 to delete item, enter any other key to return > ");
        confirmation = confirmationScanner.nextInt();

        if (confirmation == 1) {
            // TODO - Ahdan: Logic for deleting item is to be placed here
            System.out.println("Item deleted successfully.");
        }

    }
}
