package DAO;

import Entity.User;


public interface StaffMapper {
    void insert(User staff);


    User selectByIdAndPassword( String id);
}
