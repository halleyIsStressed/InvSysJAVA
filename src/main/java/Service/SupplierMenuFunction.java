package Service;

import DAO.SupplierMapper;
import Database.Database;
import Entity.Supplier;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class SupplierMenuFunction {
    //Add supplier(change to getter form to essay store and insert data to database)
    public static Supplier getaddSupplier() {
        Supplier addSupplier =new Supplier();
        Scanner newProductScanner = new Scanner(System.in);

        System.out.println("Please enter the details of the supplier:");
        System.out.print("Supplier name: ");
        addSupplier.setSupplierName(newProductScanner.next());
        System.out.print("Supplier address: ");
        addSupplier.setSupplierAddress(newProductScanner.next());
        System.out.print("Supplier telephone number: ");
        addSupplier.setSupplierTel(newProductScanner.next());
        System.out.print("Supplier email: ");
        addSupplier.setSupplierEmail(newProductScanner.next());
        System.out.println("Supplier added successfully!");
        return addSupplier;
    }

    //Database connection
    public static void addSupplier() {
     Supplier insertSupplier = getaddSupplier();
        try (SqlSession conn = Database.getInstance().openSession()) {
            SupplierMapper supplierMapper = conn.getMapper(SupplierMapper.class);
            supplierMapper.insertAddSuplier(insertSupplier);
            conn.commit();
        }
    }

    //Display all suppliers
    public static void displaySuppliers(){
        //Database connection
        List<Supplier> supplierList;
        try (SqlSession conn = Database.getInstance().openSession()) {
            SupplierMapper supplierMapper = conn.getMapper(SupplierMapper.class);
            supplierList = supplierMapper.selectAllSuppliers();
        }
        if(supplierList.isEmpty()){
            System.out.println("No supplier found!");
        }
        else{
            for(Supplier s: supplierList){
                System.out.printf("%-5s | %-10s | %-20s | %-7s | %-5s\n\n", "ID", "Name", "Tel", "Address", "Email");
                System.out.println(s.getSupplierID()  +  s.getSupplierName() +  s.getSupplierAddress() +  s.getSupplierTel() +  s.getSupplierEmail());
            }
        }
    }

}
