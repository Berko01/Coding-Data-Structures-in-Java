
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    int V;
    Linkedlist list[];

    public Graph(int V) {
        this.V = V;
        list = new Linkedlist[V];
        for (int i = 0; i < V; i++) {
            list[i] = new Linkedlist();
        }

    }

    public void add(int source, int destination) {
        list[source].addtoTail(destination);
        list[destination].addtoTail(source);
    }

    void Colloring() {
        int color[] = new int[V];

        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        color[0] = 0;

        boolean available[] = new boolean[V];
        // satırlar çıkanlar sütunlar ona gelenler
        for (int i = 0; i < V; i++) {
            available[i] = true;
        }

        for (int i = 1; i < V; i++) {
            Node temp = null;
            temp = list[i].head;
            while (temp.HaveNext()) {

                if (color[temp.data] != -1) {
                    available[color[temp.data]] = false;
                }
                temp = temp.getNext();

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
            default:
                return null;
        }

    }

    public void print() {
        for (int i = 0; i < V; i++) {
            if (list[i].size() > 0) {
                System.out.println("element " + i + " connected to -->");
                Node temp = null;
                temp = list[i].head;
                for (int j = 0; j < list[i].size(); j++) {
                    temp.Display();
                    temp = temp.getNext();

                }
            }
        }
    }

    public int rank(int v) {
        int counter = 0;
        Node temp = null;
        temp = list[v].head;
        while (temp != null) {
            counter++;
            temp = temp.getNext();
        }
        return counter;
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

            Node temp = null;
            temp = list[s].head;
            while (temp.HaveNext()) {
                temp = temp.getNext();
                if (temp != null && visited[temp.data] == false)
                    stack.push(temp.data);

            }

        }
    }

    Node temp = null;

    void DFS(int v, boolean visited[]) {

        visited[v] = true;
        System.out.print(v + " ");

        temp = list[v].head;
        while (temp != null) {
            int n = temp.data;
            temp = temp.getNext();
            if (!visited[n])
                DFS(n, visited);
        }
    }

    void DFS(int StartPoint) {

        boolean visited[] = new boolean[V];

        DFS(StartPoint, visited);

    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            Node temp = null;
            temp = list[s].head;
            while (temp.HaveNext()) {

                int n = temp.data;
                temp = temp.getNext();
                if (visited[n] == false) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}