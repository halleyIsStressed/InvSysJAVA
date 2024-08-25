package DAO;

import Entity.Supplier;

import java.util.List;
import java.util.Scanner;

public interface SupplierMapper {

    void insertAddSuplier(Supplier supplier);

    List<Supplier> selectAllSuppliers();
}
