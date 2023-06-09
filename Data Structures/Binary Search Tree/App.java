public class App {

    public static void IsAnyOneThere(int data, Bst bst) {
        if (bst.Search(data) == null) {
            System.out.println("No one there!!!");
        } else {
            System.out.println("I'm here, there!!!");
        }
    }

    public static void PrintTheTree(Bst bst) {
        System.out.print("Prefix: ");
        bst.PrefixPrint();
        System.out.print("\nPostfix: ");
        bst.PostfixPrint();
        System.out.print("\nInfix: ");
        bst.InfixPrint();
        System.out.print("\nLevelOrder:");
        bst.LevelOrder();
    }

    public static void MaxandMin(Bst bst, Node root) {
        System.out.println("Min:" + bst.Min(root).data);
        System.out.print("Max:" + bst.Max(root).data);
    }

    public static void LevelandBalanceDifference(Bst bst) {
        System.out.println("BST Level: " + bst.level());
        System.out.println("BST Balance Difference: " + bst.BalanceDifference());
    }

    public static void main(String[] args) {
        Bst bst = new Bst();
        Node root = bst.root;
        bst.Insert(90);
        bst.Insert(80);
        bst.Insert(70);
        bst.Insert(100);
        bst.Insert(85);
        bst.Insert(81);
        bst.Insert(120);
        bst.Insert(110);
        bst.Insert(88);

        bst.PostfixPrint();
        System.out.println();

        System.out.println(bst.Search(85).level);
        
        bst.Delete(90);
        bst.PostfixPrint();

        
        System.err.println();
        System.out.println(bst.Search(100).data);

 
    }
}