package Entity;

public class InventoryManager {

     private String password;
     private String name;
     private int age;
     private String gender;
     private String phone;
     private String position;

     public InventoryManager(String password, String name, int age, String gender, String phone, String position) {
          this.password = password;
          this.name = name;
          this.age = age;
          this.gender = gender;
          this.phone = phone;
          this.position = position;
     }
     public int getAge() {
          return age;
     }

     public void setAge(int age) {
          this.age = age;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getGender() {
          return gender;
     }

     public void setGender(String gender) {
          this.gender = gender;
     }

     public String getPhone() {
          return phone;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public String getPosition() {
          return position;
     }

     public void setPosition(String position) {
          this.position = position;
     }
}
