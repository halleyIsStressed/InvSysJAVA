package DAO;

import Entity.Branch;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface BranchMapper {

     List<Branch> selectAll();

     void deleteById(@NotNull String branchID);

     Branch selectById(@NotNull String branchID);

     Branch selectByLocation(@NotNull String location);

}
