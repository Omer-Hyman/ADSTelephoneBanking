import java.io.FileNotFoundException;

public class List{
    private Node head;
    private Node tail;
    private Node iterator;
    private int size = 0;

    public List(Node head)
    {
        this.head = head;
        tail = head;
    }

    public void addNode(UserRecord data)
    {
        if (head==null)
        {
            head = new Node(data, null);
            tail = head;
        }
        else
        {
            Node newNode =  new Node(data, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Node getHead() {
        return head;
    }

    public int getSize()
    {return size;}

    public Node searchListByIndex(int index)
    {
        iterator = head;
        int i = 0;
        if (index <= this.size)
            while (i != index)
            {
                iterator = iterator.next;
                i++;
            }
        return iterator;
    }

    public void popList()
    {
        this.head = this.head.next;
        size--;
    }

}
