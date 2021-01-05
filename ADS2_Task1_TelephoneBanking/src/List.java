public class List {
    private Node head;
    private Node tail;
    private int size;

    public List(Node head)
    {
        this.head = head;
        tail = head;
    }


    public void deleteCustomer(int x)
    {
        this.getItemAtIndex(x-1).next = this.getItemAtIndex(x+1);
        size--;
    }

    public void setCustomer(UserRecord data)
    {
        this.addNode(data);
    }

    public Node getItemAtIndex(int index)
    {
        return head.getNodeAtIndex(index);
    }

    public int getSize()
    {
        return size;
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

    public void displayList()
    {
        Node counter = head;
        while (counter != null)
        {
            System.out.println(counter.data.getUsername() + ", " + counter.data.getBalance());
            counter = counter.next;
        }
        System.out.println("Size = " + size);
    }

    public void deleteFirstNode()
    {
        head = head.next;
    }

    public int searchList(String userName) {
        Node tmp = new Node(null, null);
        tmp = this.head;
        for (int i = 0; i < this.getSize(); i++)
        {
            if (userName.equals(tmp.data.getUsername()))
                return i;
            tmp = tmp.next;
        }
        return -1;
    }

}
