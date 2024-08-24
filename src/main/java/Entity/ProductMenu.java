package Entity;

import DAO.ProductTools;

import java.util.Scanner;

public class ProductMenu {


    public static void productListing() {

        Scanner productMenuOptions = new Scanner(System.in);

        System.out.printf("%-5s | %-10s | %-8s | %-7s | %-5s\n\n", "ID", "Type", "Name", "Price", "Qty");
        for (Product product: ProductTools.getAllProducts()) {
            System.out.printf("%-5d | %-10s | %-8s | %-7.2f | %-5d\n", product.product_id, product.product_type.name(),
                    product.product_name, product.product_price, product.product_qty);
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

    public static void addProduct() {
        Product newProduct = new Product();


        Scanner newProductScanner = new Scanner(System.in);
        System.out.print("\nEnter product type (Rod, Reel, Hook, Line, Lure): ");
        newProduct.setProduct_type(productType.valueOf(newProductScanner.nextLine()));
        System.out.print("\nEnter product name: ");
        newProduct.setProduct_name(newProductScanner.nextLine());
        System.out.print("\nEnter product price: ");
        newProduct.setProduct_price(newProductScanner.nextDouble());

        // TODO AhDan: Insert newProduct into the PRODUCT table.

        System.out.print("\n\n");
        System.out.print("Product inserted into Database!");
    }

    public static void searchProduct() {

    }


    public static void updateProduct() {
        Product targetProduct = new Product();
        int targetID;


        Scanner targetProductScanner = new Scanner(System.in);
        System.out.print("Enter Target Product ID: ");
        targetID = targetProductScanner.nextInt();

        // TODO Ahdan: Search PRODUCT table for matching ID using WHERE statement. Return the whole row into targetProduct.

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
