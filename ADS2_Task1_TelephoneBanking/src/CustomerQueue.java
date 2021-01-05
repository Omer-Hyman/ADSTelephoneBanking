import java.io.FileNotFoundException;

public class CustomerQueue{
    private UserRecord user = new UserRecord(null, 0);
    private int x = 0;
    private List queue = new List(null);//queue initialisation
    private List records = new List(null);//customer database initialisation


    // Default Constructor
    CustomerQueue() {
        for (x=0;x<10;x++) {
            //user = list.getRecords().getItemAtIndex(x).data;
            queue.addNode(user);//May not have to be in constructor
        }
    }

//    public void displayQueue()
//    {
//        queue.displayList();
//    }

    public void popQueue()
    {
        queue.deleteFirstNode();
    }

    public void pushQueue()
    {
        x++;
        queue.addNode(records.getItemAtIndex(x).data);
    }

    public int getNextCustIndex()
    {return x;}

    public List getQueue() {return queue;}
    public List getRecords() {return records;}

}
