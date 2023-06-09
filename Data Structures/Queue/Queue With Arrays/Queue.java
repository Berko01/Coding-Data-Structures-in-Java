public class Queue {

    int indis = -1;
    int[] queue;
    int size;
    int front=0;

    public Queue(int size) {
        this.size = size;
        queue = new int[size];
    }

    public void enQueue(int value) {
        if(indis==size)
        {
            System.out.println("Queue is full!!!");
        }
        indis++;
        queue[indis] = value;
    }

    public int deQueue() {
        if(indis==0)
        {
            System.out.println("Queue is empty!!!");
        }
        int copy=queue[front];

        for (int i = 1; i <= indis; i++) {
            queue[i - 1] = queue[i];
        }
        indis--;
        return copy;

    }

}