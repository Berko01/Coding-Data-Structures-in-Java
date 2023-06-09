public class Node {
    int data;
    Node next;

    public Node() {
        this.data = 0;
        this.next = null;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;

    }

    public boolean HaveNext() {
        if (next != null) {
            return true;
        } else {
            return false;
        }
    }

    public Node getNext() {
        return next;
    }

    public void Display() {
        System.out.println(data);
    }
}
