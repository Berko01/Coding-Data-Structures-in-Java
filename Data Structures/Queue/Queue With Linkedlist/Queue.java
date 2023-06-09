public class Queue {
    Node front;
    Node rear;
    int counter;
    int size;

    public Queue(int size) {
        this.size = size;
        counter = 0;
        front = null;
        rear = null;
    }

    public void Enqueue(int value) {
        if (counter == size)
            System.err.println("Queue is full!!!");
        Node yeni = new Node(value);
        if (counter == 0) {
            front = yeni;
            rear = yeni;

        } else {
            rear.next = yeni;
            rear = rear.next;

        }
        counter++;

    }

    public int Dequeue() {
        if (counter == 0)
            System.err.println("Queue is empty!!!");
        int copy = front.value;
        front = front.next;
        return copy;

    }

    public int peek(){
        return front.value;
    }
    
    

}
