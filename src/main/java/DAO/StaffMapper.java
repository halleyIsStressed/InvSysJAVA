package DAO;

import Entity.Staff;
import Entity.User;


public interface StaffMapper {
    void insert(Staff staff);


    Staff selectStaffByIdAndPassword( String id);
}
