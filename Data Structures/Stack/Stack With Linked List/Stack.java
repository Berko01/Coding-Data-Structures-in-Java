public class Stack {
    int size;
    int counter;
    Node topofStack;

    public Stack(int size) {
        this.size = size;
        counter = 0;
        topofStack = null;
    }

    public void push(char value) {
        if (counter == size) {
            System.out.println("Stack is full!!!");
        }
        Node yeni = new Node(value);
        yeni.next = topofStack;
        topofStack = yeni;
        counter++;
    }

    public int pop() {
        if (counter == 0) {
            System.out.println("Stack is empty!!!");
        }
        char copy;
        copy = topofStack.value;
        topofStack = topofStack.next;
        counter--;
        return copy;

    }

    public char peek() {
        return topofStack.value;
    };

    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        } else {
            return false;
        }
    }

}