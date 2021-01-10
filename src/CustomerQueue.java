import java.io.FileNotFoundException;

public class CustomerQueue {
    List queue = new List(null);
    CustomerRequest request = new CustomerRequest();
    int i= 0;
    // Default Constructor
    CustomerQueue() throws FileNotFoundException {

        CustomerData user = new CustomerData();
        for (i=0 ; i < 10; i++)
        {
            request.newRequest();
            queue.addNode(user.getRecords()[i]);
            queue.searchListByIndex(i).data.setRequest(request.request);
            queue.searchListByIndex(i).data.setChange(request.amountToChange);
        }
    }

    public boolean checkFirstID(String name)
    {
        if (name.equals(queue.getPopped().getUserName()))
            return true;
        else
        {
            System.err.println("Username was incorrect!");//PROBLEM HERE WHEN ANY USERNAME INPUTTED FOR NEW ACCOUNT
            return false;
        }
    }

    public void displayList()
    {
        CustomerRequest request = new CustomerRequest();
        Node iterator = queue.getHead();
        for (int x = 0; x < queue.getSize(); x++)
        {
            request.newRequest();
            System.out.println(iterator.data.getUserName() + ", " + iterator.data.getBalance() + " :  " + iterator.data.getRequestStr());
            iterator = iterator.next;
        }
        System.out.println("Size: " +queue.getSize());
    }

    public boolean popQueue()//REMOVE FROM LIST
    {
        if (queue.getSize() == 0) {
            System.err.println("The customer queue is empty! Please queue a new customer.");
            return true;
        }
        else {
            queue.popList();
            i++;
            return false;
        }
    }

    public void pushQueue() throws FileNotFoundException {//ADD TO LIST
        CustomerData user = new CustomerData();
        if(i < 101)
        {
            request.newRequest();
            queue.addNode(user.getRecords()[i]);
            queue.searchListByIndex(i).data.setRequest(request.request);
            System.out.println("New customer queued!\nSize = " + queue.getSize());
            i++;
        }
        else
        {
            System.err.println("All customers have been queued!");
        }

    }

}
