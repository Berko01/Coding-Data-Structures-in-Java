public class Main {
    public static void main(String[] args) {
        Queue queue=new Queue(5);
        queue.Enqueue(7);
        queue.Enqueue(3);
        queue.Enqueue(2);
        queue.Enqueue(1);
        queue.Enqueue(0);


        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        
    }
}