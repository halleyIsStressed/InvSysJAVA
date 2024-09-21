package Entity;

public class Staff extends User{
    public Staff(String id, String password, String name, int age, String gender, String phone, String email, String position) {
        super(id, password, name, age, gender, phone, email);
        this.position = position;
    }

    private String position;

    public Staff() {

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }




    public String toString(){
        return  "\n************************************\n      "
                +      position+ " Profile \n"
                +"************************************\n"
                +super.toString();
    }
}

