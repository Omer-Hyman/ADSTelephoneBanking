public class Node {
    public UserRecord data;
    public Node next;


    public Node(UserRecord newNode, Node nextNode) {
        this.data = newNode;
        this.next = nextNode;
    }
}