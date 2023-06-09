import java.util.Queue;
import java.util.Stack;

public class PriorityQueue {
    Node front;
    Node rear;

    public PriorityQueue(int size) {
        front = null;
        rear = null;
    }

    public void Enqueue(String value) {
            System.err.println("Queue is full!!!");
        Node newNode = new Node(value);
        if (front == null) {
            front = newNode;
            rear = newNode;

        } else {
            rear.next = newNode;
            rear = rear.next;
            rear.next=front;

        }
        

    }

    public void delete(String value) {
        Node temp;
        temp = front;
        if (front.value.equals(value)) {
            front = front.next;
        } else {
            while (!temp.next.value.equals(value)) {
                temp = temp.next;
            }
            temp.next = temp.next.next;


        }

    }

    public String Dequeue() {
        if (front == null && rear == null) {
            return "Queue is empty!!!";
        }

        else {
            String copy = front.value;
            rear.next=front.next;
            front = front.next;
            return copy;

        }

    }

    public String peek() {
        return front.value;
    }

    public void IkiTurYaz(){
        Node temp;
        temp = front;
        int round=0;
        while(round!=2)
        {
            System.out.println(temp.value);
            temp=temp.next;
            if(temp==front)
            {
                round++;
            }
        }

    }

}
