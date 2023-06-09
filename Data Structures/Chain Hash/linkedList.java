public class tekBagliListe {

    public Dugum head; // head: listein baslangıcını tutan degisken

    public tekBagliListe() {
        this.head = null; // liste bos olarak yaratılır
    }

    public void basaEkle(int deger) {
        Dugum yeni = new Dugum(deger);

        yeni.next = head;
        this.head = yeni;
    }

        public void listele() {
        Dugum temp = head;
        while (temp.next != null) {
            
            System.out.println(temp.sayi);
            temp = temp.next;

        }

        System.out.println(temp.sayi);

    }
}