package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Staff {
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;
    private String position;

    public Staff(String name, int age, String gender, String address, String phone, String position) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.position = position;
    }



}