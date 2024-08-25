package Service;

import Entity.Supplier;

import java.util.Scanner;
import java.util.ArrayList;

public class SupplierMenuFunction {
    static ArrayList<Supplier> suppliers = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int nextID = 1;

    //Add supplier
    public void addSupplier() {
        System.out.println("Please enter the details of the supplier:");
        System.out.print("Supplier name: ");
        String name = sc.nextLine();
        System.out.print("Supplier address: ");
        String address = sc.nextLine();
        System.out.print("Supplier telephone number: ");
        String telephone = sc.nextLine();
        System.out.print("Supplier email: ");
        String email = sc.nextLine();
        Supplier supplier = new Supplier(name, telephone, address, email);
        suppliers.add(supplier);
        System.out.println("Supplier added successfully!");
    }

    //Display all suppliers
    public void displaySuppliers(){
        if(suppliers.isEmpty()){
            System.out.println("No supplier found!");
        }
        else{
            for(Supplier s: suppliers){
                System.out.println(s);
            }
        }
    }

}
