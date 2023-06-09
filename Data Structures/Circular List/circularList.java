
public class circularList {

    public Node head; // head: listein baslangıcını tutan degisken
    public Node tail;

    public circularList() {
        this.head = null; // liste bos olarak yaratılır
        this.tail = null;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
            tail = this.head;

        }

        newNode.next = head;
        this.head = newNode;
        tail.next = newNode;

    }

    public void insert(int value, int index) {
        Node newNode = new Node(value);
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

    public void addToEnd(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
        tail = newNode;

    }

    public void listele() {
        Node temp = head;
        while (temp.next != head) {
            System.out.println(temp.num);
            temp = temp.next;

        }

        System.out.println(temp.num);

    }

    public void elementnum() {
        Node temp = head;
        int counter = 1;
        while (temp.next != head) {
            counter++;
            temp = temp.next;
        }

        System.out.println(counter);

    }

    public boolean search(int element) {
        boolean isThere = false;
        Node temp = head;
        int counter = 1;
        while (temp != head) {
            if (temp.num == element) {
                isThere = true;
                break;
            }
            temp = temp.next;
            counter++;
        }

        System.out.println(counter);

        return isThere;

    }

    public int deleteElement(int index) {

        Node temp, temp2, temp3;
        temp = head;
        temp3 = head;
        int counter = 1;
        int counter2 = 1;

        while (temp.next != head) {
            if (index == 1) {
                head = temp.next;
                tail.next = head;
                break;
            }
            if (counter + 1 == index) {

                if (temp.next == head) {

                    while (temp3.next.next != head) {
                        temp3 = temp3.next;
                    }
                    temp3.next = head;

                } else {
                    temp2 = temp;
                    temp = temp.next;
                    temp2.next = temp.next;
                    temp = null;

                    break;
                }
            }

            temp = temp.next;
            counter++;
        }

        return 0;

    }

    
    public void dubleList() {
        Node temp = head;
        int counter=1;
        while (temp.next != head) {
            System.out.println(temp.num);
            temp = temp.next;

        }

        System.out.println(temp.num);
        counter++;
        temp=temp.next;

        if(counter==2)
        {
            while (temp.next != head) {
                System.out.println(temp.num);
                temp = temp.next;
    
            }

        }

    }

}

