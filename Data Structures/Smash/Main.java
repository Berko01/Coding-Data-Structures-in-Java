public class Main{
    public static void main(String[] args) {

        Stack stack=new Stack(5);

        stack.smash(14);
        stack.smash(10);
        stack.smash(7);
        stack.smash(13);
        System.out.println("bitti");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
    }
}