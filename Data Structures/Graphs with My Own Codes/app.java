public class app {
    public static void main(String[] args) {
        Graph graph1 = new Graph(3);

        graph1.add(0, 1);
        graph1.add(1, 2);
        graph1.add(2, 0);
        graph1.print();
        System.out.println(graph1.rank(0));

        graph1.DFS(1);
        System.out.println();
        graph1.DFSwithStack(1);
        System.out.println();
        graph1.Colloring();
        graph1.BFS(2);
    }

}
