public class LinkedList {

    public Node head; // head: listein baslangıcını tutan degisken

    public LinkedList() {
        this.head = null; // liste bos olarak yaratılır
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        newNode.next = head;
        this.head = newNode;
    }

    public void insert(int value, int index) {
        Node newNode = new Node(value);
        Node temp = head;
        int Counter = 1;
        while (temp.next != null) {
            if (Counter + 1 == index) {
                newNode.next = temp.next;
                temp.next = newNode;

            }
            Counter++;
            temp = temp.next;
        }
    }

    public void addToEnd(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public void list() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.num);
            temp = temp.next;

        }

        System.out.println(temp.num);

    }

    public void elemannum() {
        Node temp = head;
        int Counter = 1;
        while (temp.next != null) {
            Counter++;
            temp = temp.next;
        }

        System.out.println(Counter);

    }

    public boolean search(int eleman) {
        boolean isThere = false;
        Node temp = head;
        int Counter = 1;
        while (temp != null) {
            if (temp.num == eleman) {
                isThere = true;
                break;
            }
            temp = temp.next;
            Counter++;
        }

        System.out.println(Counter);

        return isThere;

    }

    public int delete(int index) {

        Node temp, temp2;
        temp = head;
        int Counter = 1;

        while (temp.next != null) {
            if (index == 1) {
                head = null;
                head = temp.next;
                break;
            }
            if (Counter + 1 == index) {
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
            Counter++;
        }

        return 0;

    }

}
