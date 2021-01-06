public class UserRecord {
    private String userName;
    private double balance;

    public UserRecord(String name, double balance)
    {
        this.userName = name;
        this.balance = balance;
    }

    public String getUserName() {
        return  userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }


}
