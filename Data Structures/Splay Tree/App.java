public class App {
    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        tree.insert(7);
        tree.insert(8);
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(12);
        tree.insert(4);
        tree.insert(1);


        System.out.println();
        System.out.println(tree.Search(7).data);

       

        

        tree.Delete(12);
        tree.SplaySearch(8);
        tree.Delete(8);
        System.out.println(tree.root.data);

        

        System.out.println();
        tree.preorder();
        System.out.println();
        tree.PostfixPrint();
        System.out.println();
        tree.InfixPrint();

        tree.SplaySearch(20);
        System.out.println(tree.root.data);

    }

}
