import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class graph {
    int V;
    LinkedList<Integer> list[];

    public graph(int V) {
        this.V = V;
        list = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            list[i] = new LinkedList<>();
        }

    }

    public int rank(int v) {
        Iterator<Integer> i = list[v].listIterator();
        int counter = 0;
        while (i.hasNext()) {
            counter++;
            i.next();
        }
        return counter;
    }

    public void add(int source, int destination) {
        list[source].add(destination);
        list[destination].add(source);
    }

    public void print() {
        for (int i = 0; i < V; i++) {
            if (list[i].size() > 0) {
                System.out.println("element " + i + " connected to -->");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.println(list[i].get(j));
                }
            }
        }
    }

    void DFS(int v, boolean visited[]) {

        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = list[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFS(n, visited);
        }
    }

    void DFS(int StartPoint) {

        boolean visited[] = new boolean[V];

        DFS(StartPoint, visited);

    }

    void DFSwithStack(int s) {
        boolean visited[] = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(s);

        while (!stack.empty()) {
            s = stack.peek();
            stack.pop();

            if (visited[s] == false) {
                System.out.print(s + " ");
                visited[s] = true;
            }
            Iterator<Integer> itr = list[s].iterator();

            while (itr.hasNext()) {
                int v = itr.next();
                if (visited[v] == false)
                    stack.push(v);
            }

        }
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> i = list[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (visited[n] == false) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void Colloring() {
        int color[] = new int[V];

        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        color[0] = 0;

        boolean available[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            available[i] = true;
        }

        for (int i = 1; i < V; i++) {
            Iterator<Integer> it = list[i].iterator();
            while (it.hasNext()) {
                if (color[j] != -1) {
                    available[color[j]] = false;
                }
                int j = it.next();


            }
            int c;
            for (c = 0; c < V; c++) {
                if (available[c])
                    break;
            }

            color[i] = c;

            for (int k = 0; k < V; k++) {
                available[k] = true;
            }

        }

        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " --->  Color "
                    + colorNamer(color[u]));
    }

    String colorNamer(int c) {

        switch (c) {
            case 0:
                return "black";

            case 1:
                return "brown";

            case 2:
                return "red";
            case 3:
                return "orange";
            case 4:
                return "yellow";
            case 5:
                return "green";
            case 6:
                return "blue";
            case 7:
                return "purple";
            case 8:
                return "grey";
            case 9:
                return "white";
                default: return null;
        }

    }

}
