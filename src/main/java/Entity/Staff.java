package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff extends User{
    private String position;


    public String toString(){
        return  "\n************************************\n      "
                + position+ " Profile \n"
                +"\n************************************\n"
                +super.toString();
    }
}

