package Entity;


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

    public String getBranchPhoneNo() {
        return branchPhoneNo;
    }

    public void setBranchPhoneNo(String branchPhoneNo) {
        this.branchPhoneNo = branchPhoneNo;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getBranchMgrName() {
        return branchMgrName;
    }

    public void setBranchMgrName(String branchMgrName) {
        this.branchMgrName = branchMgrName;
    }

    public String getBranchDateCreated() {
        return branchDateCreated;
    }

    public void setBranchDateCreated(String branchDateCreated) {
        this.branchDateCreated = branchDateCreated;
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
