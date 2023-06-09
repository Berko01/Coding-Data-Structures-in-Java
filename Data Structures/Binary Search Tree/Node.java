public class Node {
    Node left;
    Node right;
    int counter;
    int data;
    int level;

    public Node(int data) {
        this.left = null;
        this.right = null;
        this.counter = 1;
        this.data = data;
        this.level=1;
    }

    public void Display(){
        System.out.print(this.data+" ");
    }

    public int getCounter() {
        return counter;
    }

    
}
