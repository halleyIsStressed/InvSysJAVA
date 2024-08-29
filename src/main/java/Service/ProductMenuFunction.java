package Service;


import DAO.ProductMapper;
import Database.Database;
import Entity.Product;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProductMenuFunction {
    public static void productListing() throws IOException {

        Scanner productMenuOptions = new Scanner(System.in);
        List<Product> productList;
        try (SqlSession conn = Database.getInstance().openSession()) {
            ProductMapper productMapper = conn.getMapper(ProductMapper.class);
            productList = productMapper.selectALLProduct();
        }

        System.out.printf("%-5s | %-10s | %-20s | %-7s | %-5s\n\n", "ID", "Type", "Name", "Price", "Qty");
        for (Product product : productList) {
            System.out.printf("%-5s | %-10s | %-20s | %-7.2f | %-5d\n",
                    product.getProduct_id(),
                    product.getProduct_type(),
                    product.getProduct_name(),
                    product.getProduct_price(),
                    product.getProduct_qty());
        }
        System.out.println("Choose Option:");
        System.out.println("1 > Add Product");
        System.out.println("2 > Search Product");
        System.out.println("3 > Edit Product");
        System.out.println("4 > Delete Product");
        System.out.println("5 > Return");

        switch (productMenuOptions.nextInt()) {
            case 1:
                addProduct();
                break;
            case 2:
                // searchProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                // deleteProduct();
                break;
            case 5:
                // fuckOff();
                break;
        }

    }

    public static Product getaddProduct(){

        Product newProducts = new Product();
        Scanner newProductScanner = new Scanner(System.in);
        System.out.print("\nEnter product type (Rod, Reel, Hook, Line, Lure): ");
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

    public static void searchProduct() {
        // More akin to a searching function.
        Scanner filterOptions = new Scanner(System.in);
        
        System.out.println("Choose Filter Method:");
        System.out.println("1 > Type");
        System.out.println("2 > Price");
        System.out.println("3 > Return");


        switch (filterOptions.nextInt()) {
            case 1:
                Scanner typeSorter = new Scanner(System.in);
                String targetType;
                    
                System.out.println("Choose Type:");
                System.out.println("1 > Rod");
                System.out.println("2 > Reel");
                System.out.println("3 > Hook");
                System.out.println("4 > Line");
                System.out.println("5 > Lure");
                System.out.println("6 > Return");


                // TODO Ahdan - Use a singular function, receive "targetType" as a parameter for query using WHERE. Display all products that fit that condition.
                switch(typeSorter.nextInt()) {
                    case 1:
                        targetType = "Rod";
                        break;
                    case 2:
                        targetType = "Reel";
                        break;
                    case 3:
                        targetType = "Hook";
                        break;
                    case 4:
                        targetType = "Line";
                        break;
                    case 5:
                        targetType = "Lure";
                        break;
                    case 6:
                        System.out.println("TODO AhLee - Put this in a loop, use boolean true to return to the previous stage.");
                        break; 
                    default:
                        System.out.println("TODO AhLee - Put this in a loop, use boolean false to reprint the prompt, and receive input again.");
                        break;
                }

                
                break;
            case 2:
                System.out.println("lol");
                break;
            case 3:
                System.out.println("lol");
                break;
        }
    }


    public static void updateProduct() {

        Product targetProduct = new Product();
        int targetID;
        String newValue;

        Scanner targetProductScanner = new Scanner(System.in);
        System.out.print("Enter Target Product ID: ");
        targetID = targetProductScanner.nextInt();

        // TODO Ahdan : Search PRODUCT table for matching ID using WHERE statement. Return the whole row into targetProduct.

        System.out.println("Choose value to modify:");
        System.out.println("1 > Type");
        System.out.println("2 > Name");
        System.out.println("3 > Price");
        System.out.println("4 > Quantity (Why the fuck are you changing this)");
        System.out.println("5 > Return");

    }

    public static void deleteProduct() {

    }
}
