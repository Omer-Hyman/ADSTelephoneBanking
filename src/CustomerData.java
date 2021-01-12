import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerData {
    Vector records = new Vector();
    CustomerRequest request = new CustomerRequest();
    int x =0;
    CustomerData() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("BankUserDataset100.csv"))) {
            int i = 0;
            scanner.useDelimiter("\r\n");
            while(scanner.hasNext()){
                String[] currentLine = scanner.next().split(",");
                String currentID = currentLine[0];
                double currentBalance = Double.parseDouble(currentLine[1]);

                UserRecord user = new UserRecord(currentID, currentBalance);
                records.append(user);

                i++;
            }
        }
        catch (FileNotFoundException e){
            System.err.println(e.getLocalizedMessage());
        }
    }

    public UserRecord[] getRecords()
    {return records.getArray();}


    public boolean addCustomer(UserRecord user)
    {
        if (findCustomer(user.getUserName()) == -1)
        {
            records.append(user);
            System.out.println("\nNew Customer: " + user.getUserName() + " added to database!");
            return true;
        }
        else {
            System.err.println("Customer " + user.getUserName() + " already exists!");
            return false;
        }

    }

    public int getX() {
        return x;
    }

    public int findCustomer(String user)
    {
        int i = getX();
        for ( x = getX() ; x < records.getLength();x++) {
            if (records.getArray()[x].getUserName().equals(user)) {
                x = i;
                return x;
            }
        }
        x = i;
        return -1;
    }

    public void deleteCustomer(String user){
        records.getArray()[findCustomer(user)] = null;
        System.out.println("User: " + user + " has been deleted!");
        x++;

    }

    public void showRecords(){
        for (int x = 0; x < records.getLength();x++)
        {
            if (records.getArray()[x] != null)
                System.out.println(records.getArray()[x].getUserName() + ","  + records.getArray()[x].getBalance());
        }
    }

}
