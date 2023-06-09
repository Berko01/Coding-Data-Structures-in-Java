public class Node {
    Node left,right,parent;
    
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    public Node(Node left, Node right, Node parent, int data) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.data = data;
    }
    
    int data;
    public Node() {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.data = 0;
    }

    public void Display(){
        System.out.print(data+" ");
    }
    

    

    
}
