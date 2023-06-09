public class App {
    public static void main(String[] args) {
        ExpressionTree expTree = new ExpressionTree();

        String postfix = "23*84/+";
        expTree.GenerateExpTree(postfix);
        System.out.print("PreOrder:");
        expTree.PreOrderTraverse();
        System.out.print("\nPostOrder:");
        expTree.PostOrderTraverse();
        System.out.print("\nInOrder:");
        expTree.InOrderTraverse();
        System.out.print("\nLevelOrder:");
        expTree.LevelOrderTraverse();

        
    }
}