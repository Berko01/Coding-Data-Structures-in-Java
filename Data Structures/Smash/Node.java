public class Node {
    int value;
    Node next;
    public Node(int value) {
        this.value = value;
        next=null;
    }
    

    public void Display()
    {
        System.out.println(value);
    }
}