package Service;


import DAO.ProductMapper;
import Database.Database;
import Entity.Product;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
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
                    product.getProduct_quantity());
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

    public static Product getaddProduct() throws IOException {
        int typeChoice;
        String targetType;
        Product newProducts = new Product();
        Scanner newProductScanner = new Scanner(System.in);
        do {
            System.out.println("Choose Product Type:");
            System.out.println("1 > Rod");
            System.out.println("2 > Reel");
            System.out.println("3 > Line");
            System.out.println("4 > Lure");
            System.out.println("5 > Accessory");
            typeChoice = newProductScanner.nextInt();

            switch (typeChoice) {
                case 1:
                    targetType = "Rod";
                    newProducts.setProduct_type(targetType);
                    break;
                case 2:
                    targetType = "Reel";
                    newProducts.setProduct_type(targetType);
                    break;
                case 3:
                    targetType = "Line";
                    newProducts.setProduct_type(targetType);
                    break;
                case 4:
                    targetType = "Lure";
                    newProducts.setProduct_type(targetType);
                    break;
                case 5:
                    targetType = "Accessory";
                    newProducts.setProduct_type(targetType);
                    break;
                default:
                    typeChoice = -1;
                    System.out.println("Invalid Input. Try Again.");
                    System.in.read();
                    break;
            }
        } while (typeChoice == -1);
            newProductScanner.nextLine();
            System.out.print("\nEnter product name: ");
            newProducts.setProduct_name(newProductScanner.nextLine());
            System.out.print("\nEnter product price: ");
            newProducts.setProduct_price(newProductScanner.nextDouble());

            System.out.print("\n\n");
            System.out.println("Product inserted into Database!");
            return newProducts;

    }

    //Database connection
    public static  void addProduct() throws IOException {
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
                String targetType = "";
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

                    switch (typeSorter) {
                        case 1:
                            targetType = "Rod";
                            selectProductType(targetType);
                            break;
                        case 2:
                            targetType = "Reel";
                            selectProductType(targetType);
                            break;
                        case 3:
                            targetType = "Line";
                            selectProductType(targetType);
                            break;
                        case 4:
                            targetType = "Lure";
                            selectProductType(targetType);
                            break;
                        case 5:
                            targetType = "Accessory";
                            selectProductType(targetType);
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
                    do {
                        System.out.print("Enter minimum price: ");
                        minPrice = priceSc.nextDouble();
                        System.out.print("Enter maximum price: ");
                        maxPrice = priceSc.nextDouble();

                        if (minPrice > maxPrice) {
                            System.out.println("\nInvalid Range. Try Again.");
                        }
                    } while (minPrice > maxPrice);
                    List<Product> productsPrice;
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        ProductMapper productMapper = conn.getMapper( ProductMapper.class);
                        productsPrice = productMapper.selectMaxandMinPrice(minPrice, maxPrice);
                    }

                    for (Product product : productsPrice) {
                        System.out.println(product);
                    }
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

    private static void selectProductType(String targetType) throws IOException {

        List<Product> productList;
        try (SqlSession conn = Database.getInstance().openSession()) {
            ProductMapper productMapper = conn.getMapper( ProductMapper.class);
            productList=productMapper.selectTargetType(targetType);
        }

        for (Product product : productList) {
            System.out.println(product);
        }
    }


    public static void updateProduct() throws IOException {

        Product targetProduct = new Product();
        String targetID;
        int choice;
        Scanner targetProductScanner = new Scanner(System.in);
        Scanner choiceScanner = new Scanner(System.in);

        System.out.print("Enter Target Product ID: ");
        targetID = targetProductScanner.next();

        try (SqlSession conn = Database.getInstance().openSession()) {
            ProductMapper productMapper = conn.getMapper( ProductMapper.class);
            targetProduct=productMapper.selectById(targetID);
        }
        if(targetProduct==null){
            System.out.println("Target Product Not Found");
        }
        else {
            do {
                System.out.println("Choose value to modify:");
                System.out.println("1 > Type");
                System.out.println("2 > Name");
                System.out.println("3 > Price");
                System.out.println("4 > Return");

                choice = choiceScanner.nextInt();
                choiceScanner.nextLine();
                switch (choice) {
                    case 1:
                        Scanner typeSc = new Scanner(System.in);
                        String targetType = "";
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

                            switch (typeSorter) {
                                case 1:
                                    targetType = "Rod";
                                    targetProduct.setProduct_type(targetType);
                                    typeSorter = 6;
                                    System.out.println("Type Update pending!");
                                    break;
                                case 2:
                                    targetType = "Reel";
                                    targetProduct.setProduct_type(targetType);
                                    typeSorter = 6;
                                    System.out.println("Type Update pending!");
                                    break;
                                case 3:
                                    targetType = "Line";
                                    targetProduct.setProduct_type(targetType);
                                    typeSorter = 6;
                                    System.out.println("Type Update pending!");
                                    break;
                                case 4:
                                    targetType = "Lure";
                                    targetProduct.setProduct_type(targetType);
                                    typeSorter = 6;
                                    System.out.println("Type Update pending!");
                                    break;
                                case 5:
                                    targetType = "Accessory";
                                    targetProduct.setProduct_type(targetType);
                                    typeSorter = 6;
                                    System.out.println("Type Update pending!");
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
                        System.out.print("Enter new Name: ");
                        targetProduct.setProduct_name(choiceScanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter new Price: ");
                        targetProduct.setProduct_price(choiceScanner.nextDouble());
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid Input. Try Again.");
                        System.in.read();
                        break;
                }
                // update modify function

                try (SqlSession conn = Database.getInstance().openSession()) {
                    ProductMapper productMapper = conn.getMapper(ProductMapper.class);
                    productMapper.updateModifyData(targetProduct);
                    conn.commit();
                }
            } while (choice != 4);
            System.out.println("Item Successfully Modified!");
        }


    }


    public static void deleteProduct() throws IOException {
        boolean invalid;
        String confirmation;
        String targetID = "";
        Scanner targetProductScanner = new Scanner(System.in);
        Scanner confirmationScanner = new Scanner(System.in);

        do {
            invalid = false;
            System.out.print("\nEnter product ID (Eg. P00001): ");
            targetID = targetProductScanner.next();
            if (targetID.matches("^P\\d{5}$")) {
            } else {
                invalid = true;
                System.out.println("\nInvalid product ID format. Try Again.");
                System.in.read();
            }
        } while (invalid);

        Product targetProduct = new Product();
        try (SqlSession conn = Database.getInstance().openSession()) {
            ProductMapper productMapper = conn.getMapper( ProductMapper.class);
            targetProduct=productMapper.selectById(targetID);
        }

        System.out.printf("%-6s | %-10s | %-20s | %-7.2f | %-5d\n",
                targetProduct.getProduct_id(),
                targetProduct.getProduct_type(),
                targetProduct.getProduct_name(),
                targetProduct.getProduct_price(),
                targetProduct.getProduct_quantity());

        if (targetProduct.getProduct_quantity() > 0) {
            System.out.print("\nWARNING: STOCK RECORD PRESENT FOR THE TARGETED ITEM. ARE YOU SURE YOU WOULD LIKE TO REMOVE THIS PRODUCT FROM THE DATABASE?\n");
        }
        else
        {
            System.out.println("Are you sure you would like to remove this product from the database?\n");
        }
        System.out.print("Enter 1 to delete item, enter any other key to return > ");
        confirmation = confirmationScanner.nextLine();

        if (Objects.equals(confirmation, "1")) {
            try (SqlSession sqlSession = Database.getInstance().openSession()){
                ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
                mapper.deleteProductById(targetProduct.getProduct_id());
                sqlSession.commit();
            }
            System.out.println("Item deleted successfully.");
        }
        else;

    }


}
