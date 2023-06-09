import javax.swing.text.html.HTMLDocument.RunElement;

public class Linkedlist {

    public Node head; // head: listein baslangıcını tutan degisken
    public Node tail;

    public Linkedlist() {
        this.head = null; // liste bos olarak yaratılır
        this.tail = null;
    }

    public void addtoHead(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        this.head = newNode;
    }

    public void addtoBetween(int data, int index) {
        Node newNode = new Node(data);
        Node temp = head;
        int counter = 1;
        while (temp.next != null) {
            if (counter + 1 == index) {
                newNode.next = temp.next;
                temp.next = newNode;

            }
            counter++;
            temp = temp.next;
        }
    }

    public int data() {
        return this.data();
    }

    public void addtoTail(int data) {

        if (this.head == null) {
            Node newNode = new Node(data);
            head = newNode;
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public void addWithOrder(int data) {
        if (this.head == null) {
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
            return;
        } else {
            Node newNode = new Node(data);
            Node temp = head;
            if (data < head.data) {
                newNode.next = head;
                head = newNode;
                return;
            } else if (tail.data < data) {
                tail.next = newNode;
                return;
            }
            while (temp.next != null && temp.next.data > data) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void print() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;

        }

        System.out.println(temp.data);

    }

    public int size() {
        Node temp = head;
        int counter = 1;
        while (temp.next != null) {
            counter++;
            temp = temp.next;
        }

        return counter;
    }

    public boolean search(int element) {
        boolean IsAnyoneThere = false;
        Node temp = head;
        int counter = 1;
        while (temp != null) {
            if (temp.data == element) {
                IsAnyoneThere = true;
                break;
            }
            temp = temp.next;
            counter++;
        }

        System.out.println(counter);

        return IsAnyoneThere;

    }

    public int Delete(int index) {

        Node temp, temp2;
        temp = head;
        int counter = 1;

        while (temp.next != null) {
            if (index == 1) {
                head = null;
                head = temp.next;
                break;
            }
            if (counter + 1 == index) {
                temp2 = temp;
                temp = temp.next;
                temp2.next = temp.next;
                temp = null;

                break;
            }
            if (temp.next == null) {
                temp = null;
                break;
            }

            temp = temp.next;
            counter++;
        }

        return 0;

    }

}