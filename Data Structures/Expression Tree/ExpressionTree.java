import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionTree {
    Node root;

    public ExpressionTree() {
        this.root = null;
    }

    // 23*84/+

    public boolean IsNumber(char c) {
        if (c == '*' || c == '/' || c == '+' || c == '-') {
            return false;
        } else {
            return true;
        }

    }

    public void GenerateExpTree(String postfix) {
        Stack stack = new Stack<Node>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (IsNumber(c) == true) {
                Node newNode = new Node(c);
                stack.push(newNode);
            } else {
                Node newNode = new Node(c);
                newNode.right = (Node) stack.pop();
                newNode.left = (Node) stack.pop();
                stack.push(newNode);

            }
        }
        this.root = (Node) stack.pop();
    }

    public void PostOrderTraverse(Node node) {
        if (node != null) {
            PostOrderTraverse(node.left);
            PostOrderTraverse(node.right);
            node.DisplayData();
        }

    }

    public void PostOrderTraverse() {
        PostOrderTraverse(this.root);
    }

    public void PreOrderTraverse(Node node) {
        if (node != null) {
            node.DisplayData();
            PreOrderTraverse(node.left);
            PreOrderTraverse(node.right);
        }
    }

    public void PreOrderTraverse() {
        PreOrderTraverse(root);
    }

    public void InOrderTraverse(Node node) {
        if (node != null) {
            InOrderTraverse(node.left);
            node.DisplayData();
            InOrderTraverse(node.right);
        }
        return;

    }

    public void InOrderTraverse() {
        InOrderTraverse(root);
    }

    public void LevelOrderTraverse(Node node) {
        Queue queue = new LinkedList();
        queue.add(node);
        Node temp = node;
        while (!queue.isEmpty()) {
            temp = (Node) queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            temp.DisplayData();
        }

    }

    public void LevelOrderTraverse() {
        LevelOrderTraverse(root);
    }

}
