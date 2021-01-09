public class UserRecord {
    private String userName;
    private double balance;
    private int request;
    private double change;

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

    public int getRequestInt() {
        return request;
    }

    public String getRequestStr() {
        return switch (request) {
            case 0 -> "open an account";
            case 1 -> "close an account";
            case 2 -> "check balance";
            case 3 -> "save money";
            case 4 -> "withdraw money";
            default -> "NO REQUEST!";
        };
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getChange() {
        return change;
    }

    public double getBalance() {
        return balance;
    }

    public void setRequest(int request)
    {this.request = request;}

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
