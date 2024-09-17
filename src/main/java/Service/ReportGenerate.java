package Service;

import DAO.BranchMapper;
import DAO.ProductMapper;
import DAO.PurchaseOrderMapper;
import DAO.SupplierMapper;
import Database.Database;
import Entity.Branch;
import Entity.Product;
import Entity.Purchase_Order;
import Entity.Supplier;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ReportGenerate {
    public static void reportGenerate(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n************************************");
            System.out.println("\t\t  Report Generation ");
            System.out.println("************************************");
            System.out.println("1. Suppliers Report");
            System.out.println("2. Branches Report");
            System.out.println("3. Products Report");
            System.out.println("4. Purchase Orders Report");
            System.out.println("5. Stock Transfers Report");
            System.out.println("6. Order Return Report");
            System.out.println("7. Exit Report Generation");
            System.out.println("Please select the report you wish to generate?: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n************************************");
                    System.out.println("\t\t  Suppliers Report ");
                    System.out.println("************************************");
                    List<Supplier> suppliers;
                    try (SqlSession sqlSession = Database.getInstance().openSession()) {
                        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
                        suppliers = mapper.selectAllSuppliers();
                    }

                    if (suppliers.isEmpty())
                        System.out.println("***No supplier found!***");
                    else{
                        System.out.printf("%-10s | %-11s | %-10s | %-7s | %-12s | %-12s \n\n", "Supplier ID", "Supplier Name", "Supplier Telephone Number", "Supplier Address", "Supplier Email", "Supplier Date & Time Created");
                        for (Supplier supplier : suppliers) {
                            System.out.printf("%-10s | %-11s | %-10s | %-7.2s | %-12s | %-12s\n",
                                    supplier.getSupplierID(),
                                    supplier.getSupplierName(),
                                    supplier.getSupplierTel(),
                                    supplier.getSupplierAddress(),
                                    supplier.getSupplierEmail(),
                                    supplier.getSupplierDateTimeCreated());
                        }
                    }

                    System.out.print("Press Enter to return back to the Report Generation Menu: ");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("\n************************************");
                    System.out.println("\t\t  Branches Report ");
                    System.out.println("************************************");
                    List<Branch> branchList;
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        BranchMapper branchMapper = conn.getMapper(BranchMapper.class);
                        branchList = branchMapper.selectAll();
                    }

                    if (branchList.isEmpty())
                        System.out.println("***No branch found!***");
                    else{
                        System.out.printf("%-10s | %-11s | %-10s | %-7s | %-12s \n\n", "Branch ID", "Branch Location", "Branch Phone Number", "Branch Manager Name", "Branch Date Created");
                        for (Branch branch : branchList) {
                            System.out.printf("%-10s | %-11s | %-10s | %-7.2s | %-12s \n",
                                    branch.getBranchID(),
                                    branch.getBranchLocation(),
                                    branch.getBranchPhoneNo(),
                                    branch.getBranchMgrName(),
                                    branch.getBranchDateCreated());
                        }
                    }

                    System.out.print("Press Enter to return back to the Report Generation Menu: ");
                    sc.nextLine();
                    break;

                case 3:
                    System.out.println("\n************************************");
                    System.out.println("\t\t  Products Report ");
                    System.out.println("************************************");
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

                    System.out.print("Press Enter to return back to the Report Generation Menu: ");
                    sc.nextLine();
                    break;

                case 4:
                    System.out.println("\n************************************");
                    System.out.println("\t\t  Purchase Orders Report ");
                    System.out.println("************************************");
                    List<Purchase_Order> poList;
                    try (SqlSession conn = Database.getInstance().openSession()) {
                        PurchaseOrderMapper poMapper = conn.getMapper(PurchaseOrderMapper.class);
                        poList = poMapper.selectALLpo();
                    }

                    System.out.printf("%-10s | %-11s | %-10s | %-7s | %-12s | %-11s\n\n", "PO Number", "Product ID", "Quantity", "Cost", "Supplier ID", "Status");
                    for (Purchase_Order po : poList) {
                        System.out.printf("%-10s | %-11s | %-10d | %-7.2f | %-12s | %-11s\n",
                                po.getPo_number(),
                                po.getProduct_id(),
                                po.getPurchase_quantity(),
                                po.getOrder_price(),
                                po.getSupplier_id(),
                                po.getStatus());
                    }

                    System.out.print("Press Enter to return back to the Report Generation Menu: ");
                    sc.nextLine();
                    break;

                case 5:
                    System.out.println("\n************************************");
                    System.out.println("\t\t  Stock Transfers Report ");
                    System.out.println("************************************");

                    //TODO: AHTAN SELECT ALL INFOMATIONS FROM STOCK TRANSFERS IN DATABASE, THEN HELP ME TO EDIT BELOW CODE TO DISPLAY THEM OUT...

//                    System.out.printf("%-10s | %-11s | %-10s | %-7s | %-12s | %-11s\n\n", "PO Number", "Product ID", "Quantity", "Cost", "Supplier ID", "Status");
//                    for (Purchase_Order po : poList) {
//                        System.out.printf("%-10s | %-11s | %-10d | %-7.2f | %-12s | %-11s\n",
//                                po.getPo_number(),
//                                po.getProduct_id(),
//                                po.getPurchase_quantity(),
//                                po.getOrder_price(),
//                                po.getSupplier_id(),
//                                po.getStatus());
//                    }

                    System.out.print("Press Enter to return back to the Report Generation Menu: ");
                    sc.nextLine();
                    break;

                case 6:
                    System.out.println("\n************************************");
                    System.out.println("\t\t  Order Return Report ");
                    System.out.println("************************************");

                    //TODO: AHTAN SELECT ALL INFORMATIONS FROM RETURN ORDER IN DATABASE, THEN HELP ME TO EDIT BELOW CODE TO DISPLAY THEM OUT...

//                    System.out.printf("%-10s | %-11s | %-10s | %-7s | %-12s | %-11s\n\n", "PO Number", "Product ID", "Quantity", "Cost", "Supplier ID", "Status");
//                    for (Purchase_Order po : poList) {
//                        System.out.printf("%-10s | %-11s | %-10d | %-7.2f | %-12s | %-11s\n",
//                                po.getPo_number(),
//                                po.getProduct_id(),
//                                po.getPurchase_quantity(),
//                                po.getOrder_price(),
//                                po.getSupplier_id(),
//                                po.getStatus());
//                    }

                    System.out.print("Press Enter to return back to the Report Generation Menu: ");
                    sc.nextLine();
                    break;

                case 7:
                    //Exit report generate function

                default:
                    System.out.println("***Invalid selection! Please try again...***");
                    System.in.read();
            }
        }while (choice != 7);
    }
}
