public class Node {
    Node right;
    Node left;
    Character data;
    public Node(Character data) {
        this.right = null;
        this.left = null;
        this.data = data;
    }

    public void DisplayData(){
        System.out.print(data);
    }

    
    
}
