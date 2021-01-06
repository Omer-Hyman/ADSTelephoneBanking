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

    public void increaseBalance(double balance)
    {
        System.out.println("The balance of "+this.userName+ " has successfully been increased from "+ this.balance + " to " + (this.balance+balance));
        this.balance += balance;
    }

    public void decreaseBalance(double balance)
    {
        System.out.println("The balance of "+this.userName+ " has successfully been decreased from "+ this.balance + " to " + (this.balance-balance));
        this.balance -= balance;
        if (this.balance - balance < 0)
            System.err.println("There is not enough money in this account to make that deduction!");
    }


}
