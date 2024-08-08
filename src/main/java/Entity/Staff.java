package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Staff {
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;
    private String position;

}
