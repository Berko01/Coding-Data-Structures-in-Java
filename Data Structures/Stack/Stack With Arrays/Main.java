public class Main{
    public static void main(String[] args) {
        Stack stack=new Stack(5);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(7);
       
        
        System.err.println(stack.pop());
        System.err.println(stack.pop());
        System.err.println(stack.pop());
        System.err.println(stack.pop());
        System.err.println(stack.pop());
       
     
    }
}