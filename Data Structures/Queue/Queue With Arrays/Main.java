public class Main {
    public static void main(String[] args) {
        Queue queue1=new Queue(5);

        queue1.enQueue(6);
        queue1.enQueue(9);
        queue1.enQueue(5);
        queue1.enQueue(7);
        queue1.enQueue(7);

       
        System.out.println( queue1.deQueue());
        System.out.println( queue1.deQueue());
        System.out.println( queue1.deQueue());
        System.out.println( queue1.deQueue());
    }
    
}
