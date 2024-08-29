package Service;

import Entity.Supplier;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SupplierManagementFunction {
    static ArrayList<Supplier> suppliers = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static int nextID = 1;
    public static String cont;
    public static String confirm;
    public static boolean found = false;

    //Add supplier
    public static void createSupplier() {
        System.out.println("\n************************************");
        System.out.println("\t\t  Create Supplier");
        System.out.println("************************************");
        System.out.println("Please enter the details of the supplier:");
        do {
            System.out.print("Supplier name (Company name): ");
            String name = sc.nextLine();
            System.out.print("Supplier address: ");
            String address = sc.nextLine();
            System.out.print("Supplier telephone number: ");
            String telephone = sc.nextLine();
            System.out.print("Supplier email: ");
            String email = sc.nextLine();
            //To check validation of email address.
            while (!isValidEmail(email)) {
                System.out.println("***Invalid email address! A valid email address must include '@ & '.com'. Please try again.***");
                System.out.print("Supplier email: ");
                email = sc.nextLine();
            }

            System.out.print("CONFIRM to CREATE new supplier?: ");
            confirm = sc.nextLine().toUpperCase();
            //To confirm add new supplier with user.
            if (confirm.equals("Y") || confirm.equals("YES")) {
                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String formattedDateTime = dateTimeFormat.format(new Date());
                Supplier supplier = new Supplier(nextID++, name, telephone, address, email, formattedDateTime);
                suppliers.add(supplier);
                System.out.println("***Supplier created successfully!***");
            } else {
                System.out.println("***Supplier NOT created successfully!***");
            }
            //To ask user continue to add another supplier or not.
            System.out.print("Continue to create another supplier?: ");
            cont = sc.nextLine().toUpperCase();
        } while (cont.equals("Y") || cont.equals("YES"));
    }

    //Search supplier
    public static void readSupplier() {
        System.out.println("\n************************************");
        System.out.println("\t\t  Search Supplier");
        System.out.println("************************************");
        do {
            found = false;
            System.out.println("Searching to view supplier details:");
            System.out.println("1. Supplier ID");
            System.out.println("2. Supplier name");
            System.out.print("Search supplier by:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter supplier ID to search: ");
                    int id = Integer.parseInt(sc.nextLine());
                    for (Supplier supplier : suppliers) {
                        if (supplier.getSupplierID() == id) {
                            System.out.println(supplier);
                            found = true;
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter supplier name to search: ");
                    String name = sc.nextLine();
                    for (Supplier supplier : suppliers) {
                        if (supplier.getSupplierName().equals(name)) {
                            System.out.println(supplier);
                            found = true;
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (!found) {
                System.out.println("***Supplier NOT found!***");
            }

            System.out.print("Continue to search another supplier?: ");
            cont = sc.nextLine().toUpperCase();
        } while (cont.equals("Y") || cont.equals("YES"));
    }

    //Modify supplier
    public static void updateSupplier() {
        int choice;
        int category;
        System.out.println("\n************************************");
        System.out.println("\t\t  Update Supplier");
        System.out.println("************************************");
        do {
            found = false;
            System.out.println("1. Supplier ID");
            System.out.println("2. Supplier name");
            System.out.print("Search supplier to update by:");
            choice = sc.nextInt();
            sc.nextLine();
            @NotNull Supplier selectedSupplier = null;
            switch (choice) {
                case 1:
                    System.out.print("Enter supplier ID to update: ");
                    int id = Integer.parseInt(sc.nextLine());
                    for (Supplier supplier : suppliers) {
                        if (supplier.getSupplierID() == id) {
                            selectedSupplier = supplier;
                            System.out.println("Supplier current details: ");
                            System.out.println(supplier);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("***Supplier NOT found!***");
                        break;
                    }
                    break;

                case 2:
                    System.out.print("Enter supplier name to update: ");
                    String name = sc.nextLine();
                    for (Supplier supplier : suppliers) {
                        if (supplier.getSupplierName().equals(name)) {
                            selectedSupplier = supplier;
                            System.out.println("Supplier current details: ");
                            System.out.println(supplier);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("***Supplier NOT found!***");
                        break;
                    }
                    break;

                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (found) {
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
                        String newName = sc.nextLine();
                        selectedSupplier.setSupplierName(newName);
                        break;
                    case 2:
                        System.out.print("Enter the new Supplier telephone: ");
                        String newTelephone = sc.nextLine();
                        selectedSupplier.setSupplierTel(newTelephone);
                        break;
                    case 3:
                        System.out.print("Enter the new Supplier address: ");
                        String newAddress = sc.nextLine();
                        selectedSupplier.setSupplierAddress(newAddress);
                        break;
                    case 4:
                        System.out.print("Enter the new Supplier email: ");
                        String newEmail = sc.nextLine();
                        //To check validation of email address.
                        while (!isValidEmail(newEmail)) {
                            System.out.println("***Invalid email address! A valid email address must include '@ & '.com'. Please try again.***");
                            System.out.print("Enter the new Supplier email: ");
                            newEmail = sc.nextLine();
                        }
                        selectedSupplier.setSupplierEmail(newEmail);
                        break;
                    case 5:
                        System.out.print("Enter the new Supplier name (Company name): ");
                        newName = sc.nextLine();
                        selectedSupplier.setSupplierName(newName);
                        System.out.print("Enter the new Supplier telephone number: ");
                        newTelephone = sc.nextLine();
                        selectedSupplier.setSupplierTel(newTelephone);
                        System.out.print("Enter the new Supplier address: ");
                        newAddress = sc.nextLine();
                        selectedSupplier.setSupplierAddress(newAddress);
                        System.out.print("Enter the new Supplier email: ");
                        newEmail = sc.nextLine();
                        //To check validation of email address.
                        while (!isValidEmail(newEmail)) {
                            System.out.println("***Invalid email address! A valid email address must include '@ & '.com'. Please try again.***");
                            System.out.print("Enter the new Supplier email: ");
                            newEmail = sc.nextLine();
                        }
                        selectedSupplier.setSupplierEmail(newEmail);
                        break;
                    default:
                        System.out.println("***Invalid category! Please try again...***");
                }
                // Prompt user for confirmation
                System.out.println("Updated details: ");
                System.out.println(selectedSupplier);
                System.out.print("CONFIRM to UPDATE these changes?: ");
                confirm = sc.nextLine().toUpperCase();

                if (confirm.equals("Y") || confirm.equals("YES")) {
                    System.out.println("***Changes saved successfully!***");
                } else {
                    System.out.println("***Changes DISCARDED! Supplier details reverted to original.***");
                }
            }

            System.out.print("Continue to update supplier's details?: ");
            cont = sc.nextLine().toUpperCase();
        } while (cont.equals("Y") || cont.equals("YES"));
    }

    //Remove supplier
    public static void deleteSupplier() {
        int choice;
        System.out.println("\n************************************");
        System.out.println("\t\t  Delete Supplier");
        System.out.println("************************************");
        do {
            found = false;
            System.out.println("1. Supplier ID");
            System.out.println("2. Supplier name");
            System.out.print("Search supplier to delete by:");
            choice = sc.nextInt();
            sc.nextLine();
            Supplier selectedSupplier = null;
            switch (choice) {
                case 1:
                    System.out.print("Enter supplier ID to delete: ");
                    int id = Integer.parseInt(sc.nextLine());
                    for (Supplier supplier : suppliers) {
                        if (supplier.getSupplierID() == id) {
                            selectedSupplier = supplier;
                            System.out.println(supplier);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("***Supplier NOT found!***");
                        break;
                    }
                    break;

                case 2:
                    System.out.print("Enter supplier name to delete: ");
                    String name = sc.nextLine();
                    for (Supplier supplier : suppliers) {
                        if (supplier.getSupplierName().equals(name)) {
                            selectedSupplier = supplier;
                            System.out.println(supplier);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("***Supplier NOT found!***");
                        break;
                    }
                    break;

                default:
                    System.out.println("***Invalid choice! Please try again...***");
            }

            if (found) {
                System.out.print("CONFIRM to DELETE this supplier?: ");
                confirm = sc.nextLine().toUpperCase();
                if (confirm.equals("Y") || confirm.equals("YES")) {
                    suppliers.remove(selectedSupplier);
                    System.out.println("***Supplier deleted successfully!***");
                } else {
                    System.out.println("***Supplier NOT deleted successfully!***");
                }
            }

            System.out.print("Continue to delete supplier?: ");
            cont = sc.nextLine().toUpperCase();
        } while (cont.equals("Y") || cont.equals("YES"));
    }

    //Display all suppliers
    public static void displaySuppliers() {
        System.out.println("\n************************************");
        System.out.println("\t\tDisplay All Suppliers");
        System.out.println("************************************");
        if (suppliers.isEmpty()) {
            System.out.println("***No supplier found!***");
        } else {
            for (Supplier s : suppliers) {
                System.out.println(s);
            }
        }

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
