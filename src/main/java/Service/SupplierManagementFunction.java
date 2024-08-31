package Service;

import DAO.SupplierMapper;
import Database.Database;
import Entity.Supplier;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class SupplierManagementFunction {
    public static Scanner sc = new Scanner(System.in);

    //Add supplier
    public static void createSupplier() {
        String confirm;

        System.out.println("\n************************************");
        System.out.println("\t\t  Create Supplier");
        System.out.println("************************************");
        System.out.println("Please enter the details of the supplier:");
        do {
            Supplier supplier = new Supplier();

            System.out.print("Supplier name (Company name): ");
            supplier.setSupplierName(sc.nextLine());
            System.out.print("Supplier address: ");
            supplier.setSupplierAddress(sc.nextLine());
            System.out.print("Supplier telephone number: ");
            supplier.setSupplierTel(sc.nextLine());

            do {
                System.out.print("Supplier email: ");
                supplier.setSupplierEmail(sc.nextLine());

                if (isValidEmail(supplier.getSupplierEmail()))
                    break;

                System.out.println("***Invalid email address! A valid email address must include '@ & '.com'. Please try again.***");
            } while (true);

            System.out.print("CONFIRM to CREATE new supplier?: ");
            confirm = sc.nextLine();
            //To confirm add new supplier with user.
            if (confirm.equalsIgnoreCase("Y")
                    || confirm.equalsIgnoreCase("YES")) {
                try (SqlSession sqlSession = Database.getInstance().openSession()){
                    SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                    mapper.insertAddSuplier(supplier);
                    sqlSession.commit();
                }
                System.out.println("***Supplier created successfully!***");
            } else {
                System.out.println("***Supplier NOT created successfully!***");
            }
            //To ask user continue to add another supplier or not.
            System.out.print("Continue to create another supplier?: ");
            confirm = sc.nextLine();
        } while (confirm.equalsIgnoreCase("Y")
                || confirm.equalsIgnoreCase("YES"));
    }

    //Search supplier
    public static void readSupplier() {
        String confirm;

        System.out.println("\n************************************");
        System.out.println("\t\t  Search Supplier");
        System.out.println("************************************");
        do {
            Supplier supplier = null;

            System.out.println("Searching to view supplier details:");
            System.out.println("1. Supplier ID");
            System.out.println("2. Supplier name");
            System.out.print("Search supplier by:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter supplier ID to search: ");
                    try (SqlSession sqlSession = Database.getInstance().openSession()){
                        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                        supplier = mapper.selectById(sc.nextLine());
                    }
                    break;

                case 2:
                    System.out.print("Enter supplier name to search: ");
                    try (SqlSession sqlSession = Database.getInstance().openSession()){
                        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                        supplier = mapper.selectByName(sc.nextLine());
                    }
                    break;

                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (supplier == null)
                System.out.println("***Supplier NOT found!***");
            else
                System.out.println(supplier);

            System.out.print("Continue to search another supplier?: ");
            confirm = sc.nextLine().toUpperCase();
        } while (confirm.equals("Y") || confirm.equals("YES"));
    }

    //Modify supplier
    public static void updateSupplier() {
        String confirm;
        int choice;
        int category;
        System.out.println("\n************************************");
        System.out.println("\t\t  Update Supplier");
        System.out.println("************************************");
        do {
            Supplier supplier = null;

            System.out.println("1. Supplier ID");
            System.out.println("2. Supplier name");
            System.out.print("Search supplier to update by:");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter supplier ID to update: ");
                    try (SqlSession sqlSession = Database.getInstance().openSession()){
                        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                        supplier = mapper.selectById(sc.nextLine());
                    }
                    break;

                case 2:
                    System.out.print("Enter supplier name to update: ");
                    try (SqlSession sqlSession = Database.getInstance().openSession()){
                        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                        supplier = mapper.selectByName(sc.nextLine());
                    }
                    break;

                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (supplier == null)
                System.out.println("***Supplier NOT found!***");

            else {
                System.out.println("1. Supplier name");
                System.out.println("2. Supplier telephone number");
                System.out.println("3. Supplier address");
                System.out.println("4. Supplier email");
                System.out.println("5. ALL");
                System.out.print("Please select the category you would like to update: ");
                category = sc.nextInt();
                sc.nextLine();
                switch (category) {
                    case 1:
                        System.out.print("Enter the new Supplier name (Company name): ");
                        supplier.setSupplierName(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter the new Supplier telephone: ");
                        supplier.setSupplierTel(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter the new Supplier address: ");
                        supplier.setSupplierAddress(sc.nextLine());
                        break;
                    case 4:
                        do {
                            System.out.print("Enter the new Supplier email: ");
                            supplier.setSupplierEmail(sc.nextLine());

                            if (isValidEmail(supplier.getSupplierEmail()))
                                break;

                            System.out.println("***Invalid email address! A valid email address must include '@ & '.com'. Please try again.***");
                        } while (true);
                        break;
                    case 5:
                        System.out.print("Enter the new Supplier name (Company name): ");
                        supplier.setSupplierName(sc.nextLine());
                        System.out.print("Enter the new Supplier telephone number: ");
                        supplier.setSupplierTel(sc.nextLine());
                        System.out.print("Enter the new Supplier address: ");
                        supplier.setSupplierAddress(sc.nextLine());
                        do {
                            System.out.print("Enter the new Supplier email: ");
                            supplier.setSupplierEmail(sc.nextLine());

                            if (isValidEmail(supplier.getSupplierEmail()))
                                break;

                            System.out.println("***Invalid email address! A valid email address must include '@ & '.com'. Please try again.***");
                        } while (true);
                        break;
                    default:
                        System.out.println("***Invalid category! Please try again...***");
                }
                // Prompt user for confirmation
                System.out.println("Updated details: ");
                System.out.println(supplier);
                System.out.print("CONFIRM to UPDATE these changes?: ");
                confirm = sc.nextLine().toUpperCase();
                if (confirm.equals("Y") || confirm.equals("YES")) {
                    if(choice==1){
                        try (SqlSession sqlSession = Database.getInstance().openSession()){
                            SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                            mapper.updateSupplierById(supplier);
                            sqlSession.commit();
                        }
                    }
                    else{
                        try (SqlSession sqlSession = Database.getInstance().openSession()){
                            SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                            mapper.updateSupplierByName(supplier);
                            sqlSession.commit();
                        }
                    }

                    System.out.println("***Changes saved successfully!***");
                } else {
                    System.out.println("***Changes DISCARDED! Supplier details reverted to original.***");
                }
            }

            System.out.print("Continue to update supplier's details?: ");
            confirm = sc.nextLine().toUpperCase();
        } while (confirm.equals("Y") || confirm.equals("YES"));
    }

    //Remove supplier
    public static void deleteSupplier() {
        String confirm;
        int choice;
        System.out.println("\n************************************");
        System.out.println("\t\t  Delete Supplier");
        System.out.println("************************************");
        do {
            Supplier supplier = null;

            System.out.println("1. Supplier ID");
            System.out.println("2. Supplier name");
            System.out.print("Search supplier to delete by:");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter supplier ID to delete: ");
                    try (SqlSession sqlSession = Database.getInstance().openSession()){
                        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                        supplier = mapper.selectById(sc.nextLine());
                    }
                    break;

                case 2:
                    System.out.print("Enter supplier name to delete: ");
                    try (SqlSession sqlSession = Database.getInstance().openSession()){
                        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                        supplier = mapper.selectByName(sc.nextLine());
                    }
                    break;

                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (supplier == null)
                System.out.println("***Supplier NOT found!***");

            else {
                System.out.println(supplier);
                System.out.print("CONFIRM to DELETE this supplier?: ");
                confirm = sc.nextLine().toUpperCase();
                if (confirm.equals("Y") || confirm.equals("YES")) {
                    try (SqlSession sqlSession = Database.getInstance().openSession()){
                        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                        mapper.deleteSupplierById(supplier.getSupplierID());
                        sqlSession.commit();
                    }
                    System.out.println("***Supplier deleted successfully!***");
                } else {
                    System.out.println("***Supplier NOT deleted successfully!***");
                }
            }

            System.out.print("Continue to delete supplier?: ");
            confirm = sc.nextLine().toUpperCase();
        } while (confirm.equals("Y") || confirm.equals("YES"));
    }

    //Display all suppliers
    public static void displaySuppliers() {
        System.out.println("\n************************************");
        System.out.println("\t\tDisplay All Suppliers");
        System.out.println("************************************");

        List<Supplier> suppliers;
        try (SqlSession sqlSession = Database.getInstance().openSession()) {
            SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
            suppliers = mapper.selectAllSuppliers();
        }

        if (suppliers.isEmpty())
            System.out.println("***No supplier found!***");
        else
            for (Supplier s : suppliers)
                System.out.println(s);

        System.out.print("Press Enter to return back to the Supplier Management Menu: ");
        sc.nextLine();
    }

    // Method to perform email validation
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return email.contains("@") && email.endsWith(".com");
    }

}





//public class SupplierMenuFunction {
//    //Add supplier(change to getter form to essay store and insert data to database)
//    public static Supplier getaddSupplier() {
//        Supplier addSupplier =new Supplier();
//        Scanner newProductScanner = new Scanner(System.in);
//
//        System.out.println("Please enter the details of the supplier:");
//        System.out.print("Supplier name: ");
//        addSupplier.setSupplierName(newProductScanner.next());
//        System.out.print("Supplier address: ");
//        addSupplier.setSupplierAddress(newProductScanner.next());
//        System.out.print("Supplier telephone number: ");
//        addSupplier.setSupplierTel(newProductScanner.next());
//        System.out.print("Supplier email: ");
//        addSupplier.setSupplierEmail(newProductScanner.next());
//        System.out.println("Supplier added successfully!");
//        return addSupplier;
//    }
//
//    //Database connection
//    public static void addSupplier() {
//     Supplier insertSupplier = getaddSupplier();
//        try (SqlSession conn = Database.getInstance().openSession()) {
//            SupplierMapper supplierMapper = conn.getMapper(SupplierMapper.class);
//            supplierMapper.insertAddSuplier(insertSupplier);
//            conn.commit();
//        }
//    }
//
//    //Display all suppliers
//    public static void displaySuppliers(){
//        //Database connection
//        List<Supplier> supplierList;
//        try (SqlSession conn = Database.getInstance().openSession()) {
//            SupplierMapper supplierMapper = conn.getMapper(SupplierMapper.class);
//            supplierList = supplierMapper.selectAllSuppliers();
//        }
//        if(supplierList.isEmpty()){
//            System.out.println("No supplier found!");
//        }
//        else{
//            for(Supplier s: supplierList){
//                System.out.printf("%-5s | %-10s | %-20s | %-7s | %-5s\n\n", "ID", "Name", "Tel", "Address", "Email");
//                System.out.println(s.getSupplierID()  +  s.getSupplierName() +  s.getSupplierAddress() +  s.getSupplierTel() +  s.getSupplierEmail());
//            }
//        }
//    }
//
//}
