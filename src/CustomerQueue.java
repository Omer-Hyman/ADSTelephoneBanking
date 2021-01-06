import java.io.FileNotFoundException;

public class CustomerQueue {
    List queue = new List(null);

    // Default Constructor
    CustomerQueue() throws FileNotFoundException {

        CustomerData user = new CustomerData();
        for (int i=0 ; i < 10; i++)
        {
            queue.addNode(user.getRecords()[i]);
        }
    }

    public void displayList()
    {
        Node iterator = queue.getHead();
        for (int x = 0; x < queue.getSize(); x++)
        {
            System.out.println(iterator.data.getUserName() + ", " + iterator.data.getBalance());
            iterator = iterator.next;
        }
        System.out.println("Size: " +queue.getSize());
    }

    public void popQueue()
    {
        queue.popList();
    }

    public void pushQueue() throws FileNotFoundException {
        CustomerData user = new CustomerData();
        queue.addNode(user.getRecords()[queue.getSize()]);
    }

}
