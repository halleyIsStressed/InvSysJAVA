package DAO;

import Entity.Supplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface SupplierMapper {

    void insertAddSuplier(Supplier supplier);

    List<Supplier> selectAllSuppliers();

    @Nullable Supplier selectById(@NotNull String supplierId);

    @Nullable Supplier selectByName(@NotNull String supplierName);

    void deleteSupplierById(@NotNull String supplierId);

    void updateSupplierByName(Supplier supplier);

    void updateSupplierById(Supplier supplier);
}
