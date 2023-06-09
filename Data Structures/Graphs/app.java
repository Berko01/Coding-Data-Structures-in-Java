public class app {
    public static void main(String[] args) {
        graph graph1 = new graph(10);

        graph1.add(1, 0);
        graph1.add(2, 0);
        graph1.add(3, 0);
        graph1.add(4, 1);
        graph1.add(2, 4);
        graph1.add(1, 7);
        graph1.add(5, 4);
        graph1.add(7, 3);
        graph1.add(5, 6);
        graph1.add(8, 7);
        graph1.add(8, 3);
        graph1.add(9, 0);
        graph1.add(9, 3);
        graph1.add(9, 8);

        graph1.print();
        System.out.print("DFS:");
        graph1.DFS(0);
        System.out.println();
        System.out.print("DFS with stack:");
        graph1.DFSwithStack(0);
        System.out.print("BFS with queue:");
        graph1.BFS(0);

        System.out.println();
        System.out.print("Rank of value: ");
        System.out.println(graph1.rank(0));

        graph1.Colloring();
    }

}
