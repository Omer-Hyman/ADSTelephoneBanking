public class Node {
    public UserRecord data;
    public Node next;

    public Node(UserRecord newNode, Node nextNode) 	{
        this.data=newNode;
        this.next=nextNode;
    }

    public Node getNodeAtIndex(int index)
    {
        if (index==0)
            return this;
        else
            return this.next.getNodeAtIndex(index-1);
    }

    public UserRecord getUserRecord()
    {
        return data;
    }



}
