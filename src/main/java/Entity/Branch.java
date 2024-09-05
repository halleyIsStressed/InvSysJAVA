package Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Branch {

    private String branchID;
    private String branchLocation;
    private String branchPhoneNo;
    private String branchMgrName;
    private String branchDateCreated;

    //Constructor
    public Branch(String id, String location, String phoneNo, String mgrName, String dateCreated) {
        this.branchID = id;
        this.branchLocation = location;
        this.branchPhoneNo = phoneNo;
        this.branchMgrName = mgrName;
        this.branchDateCreated = dateCreated;
    }

    public Branch(){}

    @Override
    public String toString(){
        return  "*****************************************"+
                "\nBranch's Info:"+
                "\nID: "+ branchID +
                "\nLocation: "+branchLocation+
                "\nPhone number: "+branchPhoneNo+
                "\nManager name: "+branchMgrName+
                "\nDate created: "+branchDateCreated+
                "\n*****************************************";
    }

}
