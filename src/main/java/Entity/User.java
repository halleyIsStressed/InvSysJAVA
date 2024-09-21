package Entity;


public class User {

     private String id;
     private String password;
     private String name;
     private int age;
     private String gender;
     private String phone;
     private String email;

     public User() {
          
     }

     public String getGender() {
          return gender;
     }

     public void setGender(String gender) {
          this.gender = gender;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getPhone() {
          return phone;
     }

     public void setPhone(String phone) {
          this.phone = phone;
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

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }



     public User(String id, String password, String name, int age, String gender, String phone,String email) {
          this.id = id;
          this.password = password;
          this.name = name;
          this.age = age;
          this.gender = gender;
          this.phone = phone;
          this.email = email;
     }

     public User(String password, String name, int age, String gender, String phone) {
          this.password = password;
          this.name = name;
          this.age = age;
          this.gender = gender;
          this.phone = phone;
     }

     public User(String id, String password) {
          this.id = id;
          this.password = password;
     }

     @Override
     public String toString(){
          return  "Name : " + name + "\n"
                  + "Gender : " + gender + "\n"
                  + "Age : " + age + "\n"
                  + "Phone : " + phone + "\n"
                  + "Email : " + email + "\n";
     }



}
