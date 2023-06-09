public class Stack {
    int topofStack = 0;
    int[] stack;
    int size;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
        topofStack = -1;
    }

    public void push(int value) {
        if (topofStack == size - 1) {
            System.out.println("Stack has full capacity!!");
        } else {
            topofStack++;
            stack[topofStack] = value;

        }
    }

    public int pop(){
        if(topofStack<0)
        {
            System.out.println("Stack has none capacity!!");
        }
        int copy=topofStack;
        topofStack--;
        return stack[copy];
        }

}
