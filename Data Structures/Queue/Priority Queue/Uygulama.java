public class Uygulama{
    public static void main(String[] args) {
        PriorityQueue queue=new PriorityQueue(9);
        queue.Enqueue("beko",90);
        queue.Enqueue("seum",3);
        queue.Enqueue("mami",45);
        queue.Enqueue("celo",11);
        queue.Enqueue("sabo",11);
        queue.Enqueue("Ahmet", 90);


        




        queue.delete("mami");

        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());

        
        
    }
}