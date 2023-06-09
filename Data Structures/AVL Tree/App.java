public class App {
    public static void main(String[] args) {
        Avltree avlTree = new Avltree();

        avlTree.Insert(90);
        avlTree.Insert(200);
        avlTree.Insert(80);
        avlTree.Insert(70);
        avlTree.Insert(85);
        avlTree.Insert(88);

        avlTree.Delete(90);
        avlTree.Delete(70);
        avlTree.Delete(85);

        avlTree.PostfixPrint();

        avlTree.PrefixPrint();
        System.out.println("\n");

    }

}
