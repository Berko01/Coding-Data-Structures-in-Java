public class Node {
    Node right;
    Node left;
    int data;
    int level;

    public Node(int data) {
        this.right = null;
        this.left = null;
        this.data = data;
        this.level = 1;
    }

    public void Display(){
        System.out.print(data+" ");
    }

}
