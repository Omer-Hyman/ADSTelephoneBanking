import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerData {
    UserRecord[] records = new UserRecord[120];
    int i = 0;
    CustomerData() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("BankUserDataset100.csv"))) {
            scanner.useDelimiter("\r\n");
            while(scanner.hasNext()){
                String currentLine[] = scanner.next().split(",");
                String currentID = currentLine[0];
                double currentBalance = Double.parseDouble(currentLine[1]);

                UserRecord user = new UserRecord(currentID, currentBalance);

                records[i] = user;
                i++;
            }
            /*for (int x = 0; x < i;x++)
                System.out.println(records[x].getUserName() + ","  + records[x].getBalance());*/
        }
        catch (FileNotFoundException e){
            System.err.println(e.getLocalizedMessage());
        }
    }

    public UserRecord[] getRecords()
    {return records;}

    public void addCustomer(UserRecord user)
    {
        records[i] = user;
        i++;
        System.out.println("\nNew Customer: " + user.getUserName() +", "+ user.getBalance() +" added to database!\n");
        for (int x = 0; x < i;x++)
            System.out.println(records[x].getUserName() + ","  + records[x].getBalance());
    }

}
