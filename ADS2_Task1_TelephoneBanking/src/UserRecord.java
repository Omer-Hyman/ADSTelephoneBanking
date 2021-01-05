public class UserRecord {
    private String username;
    private double balance;


    public UserRecord(String username, double balance)
    {
        this.username=username;
        this.balance = this.truncateTwoDecimal(balance);
    }

    public double getBalance() { return balance; }
    public String getUsername() { return username; }

    public double truncateTwoDecimal(double unroundedNumber)
    {
        double roundedNumber = unroundedNumber * 100;
        int numberAsInt = (int) unroundedNumber;
        roundedNumber = ((double) numberAsInt);
        return roundedNumber;
    }




}
