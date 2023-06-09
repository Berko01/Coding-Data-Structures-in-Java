public class Main {
    public static void main(String[] args) {

        LinkedList dugum1 = new LinkedList();
        dugum1.prepend(6);
        dugum1.prepend(40);
        dugum1.prepend(70);

        dugum1.addToEnd(67);
        dugum1.addToEnd(67);
        dugum1.addToEnd(79);

        /*
         * dugum1.insert(55, 5);
         * /*
         * dugum1.list();
         * 
         * dugum1.elemansayi();
         * 
         * System.out.println(dugum1.search(5));
         */

        dugum1.delete(1);
        dugum1.list();

    }

}