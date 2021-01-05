import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerData {
    UserRecord[] records = new UserRecord[120];
    CustomerData() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("BankUserDataset100.csv"))) {
            int i = 0;
            scanner.useDelimiter("\r\n");
            while(scanner.hasNext()){
                String currentLine[] = scanner.next().split(",");
                String currentID = currentLine[0];
                double currentBalance = Double.parseDouble(currentLine[1]);

//              MAYBE CHANGE TO BIG DECIMAL

                UserRecord user =new UserRecord(currentID, currentBalance);
                records[i] = user;

                i++;
            }
            displayRecords();
        }
        catch (FileNotFoundException e){
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void displayRecords()
    {
        for(int x = 0; x < records.length; x++)
        {
            while (records[x].getUsername() != null)
                System.out.println(records[x].getUsername() + ", " + records[x].getBalance());
        }
    }



}
