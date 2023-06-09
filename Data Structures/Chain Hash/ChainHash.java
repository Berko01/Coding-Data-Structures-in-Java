import java.util.Random;

public class ChainHash {
    public static void main(String[] args) {
        int key, value;
        int size = 100;
        tekBagliListe[] Chainhash = new tekBagliListe[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            key = 10000 + random.nextInt(90000);
            value = key % size;

            if (Chainhash[value] == null) {
                tekBagliListe tekbaglist = new tekBagliListe();
                tekbaglist.basaEkle(key);
                Chainhash[value] = tekbaglist;
                System.out.println(key + " numarali anahtar" + value + " numarali alana eklendi.");
            } else {
                Chainhash[value].basaEkle(key);
                System.out.println(key + " numarali anahtar " + value + " numarali value'nun basina eklendi.");
            }
        }

        for (int i = 0; i < size; i++) {
            if (Chainhash[i] != null) {
                Chainhash[i].listele();

            }
        }

    }

    

}