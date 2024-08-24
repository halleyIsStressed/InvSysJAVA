package Entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class InventoryManager {

     private int id;
     private String password;
     private String name;
     private int age;
     private String gender;
     private String phone;
     private String position;

     public InventoryManager(int id, String password, String name, int age, String gender, String phone, String position) {
          this.id = id;
          this.password = password;
          this.name = name;
          this.age = age;
          this.gender = gender;
          this.phone = phone;
          this.position = position;
     }

     public InventoryManager(String password, String name, int age, String gender, String phone, String position) {
          this.password = password;
          this.name = name;
          this.age = age;
          this.gender = gender;
          this.phone = phone;
          this.position = position;
     }

     public InventoryManager(int id, String password) {
          this.id = id;
          this.password = password;
     }
}
