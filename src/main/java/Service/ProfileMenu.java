package Service;

import DAO.InventoryManagerMapper;
import DAO.StaffMapper;
import Database.Database;
import Design.Design;
import Entity.User;
import org.apache.ibatis.session.SqlSession;

public class ProfileMenu {

    public static void profileList(String id,int choice){
        User currentUser = new User();
        switch (choice) {
            case 1:
                try (SqlSession conn = Database.getInstance().openSession()) {
                    InventoryManagerMapper inventoryManagerMapper = conn.getMapper(InventoryManagerMapper.class);
                    currentUser = inventoryManagerMapper.selectByIdAndPassword(id);
                }
                break;
            case 2:
                try (SqlSession conn = Database.getInstance().openSession()) {
                    StaffMapper staffMapper = conn.getMapper(StaffMapper.class);
                    currentUser = staffMapper.selectByIdAndPassword(id);
                }
                break;
        }

        Design.designLine();
        System.out.println(currentUser.getPosition() + "Profile");
        Design.designLine();
        System.out.println("Name:" + currentUser.getName());
        System.out.println("Gender:" + currentUser.getGender());
        System.out.println("Age:" + currentUser.getAge());
        System.out.println("Phone:" + currentUser.getPhone());
    }

}
