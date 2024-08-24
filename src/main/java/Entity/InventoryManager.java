package Entity;

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

     public int getAge() {
          return age;
     }

     public void setAge(int age) {
          this.age = age;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
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
