import java.util.Queue;
import java.util.Stack;

public class PriorityQueue {
    Node front;
    Node rear;

    public PriorityQueue(int size) {
        front = null;
        rear = null;
    }

    public void Enqueue(String value, int oncelik) {

        Node yeni = new Node(value, oncelik);
        if (front == null && rear == null) {
            front = yeni;
            rear = yeni;

        } else {

            if (yeni.oncelik < front.oncelik) {
                yeni.next = front;
                front = yeni;
            } else if ((yeni.oncelik == front.oncelik)) {
                yeni.next = front.next;
                front.next = yeni;

            } else if (yeni.oncelik >= rear.oncelik) {
                rear.next = yeni;
                rear = rear.next;
            } else {
                Node temp = front;
                while (yeni.oncelik >= temp.next.oncelik) {
                    temp = temp.next;
                }

                yeni.next=temp.next;
                temp.next =yeni;

            }

        }

    }

    public void delete(String value){
        Node temp;
        temp=front;
        while (!temp.next.value.equals(value)) {
           temp = temp.next;
        }
        temp.next=temp.next.next;
        
    }

    public String Dequeue() {
        if (front == null && rear == null) {
            return "Queue is empty!!!";
        }

        else {
            String copy = front.value;
            front = front.next;
            return copy;

        }

    }

    public String peek() {
        return front.value;
    }

}
