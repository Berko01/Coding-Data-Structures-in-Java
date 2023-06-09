import java.util.Random;

public class hash {
    public static void main(String[] args) {
        int key, value;
        int size = 100;
        int[] hashtable = new int[size];
        Random random = new Random();

        int full = 0;
        int Empty = 0;
        int conflict = 0;
        for (int i = 0; i < size; i++) {
            hashtable[i] = -1;
        }

        // LİNEAR PROBİNG
        /*
         * 
         * for (int i = 0; i < size; i++) {
         * key = 10000 + random.nextInt(90000);
         * value = key % size;
         * if (hashtable[value] < 0) {
         * hashtable[value] = key;
         * Empty++;
         * } else {
         * conflict++;
         * int a = 1;
         * while (value + a < size && hashtable[value + a] >= 0) {
         * a++;
         * full++;
         * }
         * if (value + a >= size) {
         * a = 0;
         * while (hashtable[a] >= 0) {
         * a++;
         * }
         * hashtable[a] = key;
         * } else
         * hashtable[(value + a) % size] = key;
         * }
         * }
         */

        // QUADRATİC PROBİNG



        //linear probing 2

        /*

        for(int i=0; i<size;i++)
        {
            key=1000+random.nextInt(90000);
            value=key%size;
            if(hashtable[value]<0)
            {
                hashtable[value]=key;
            }
            else{
                int a=1;
                while(hashtable[(value+a)%size]>=0)
                {
                    a++;
                }
                hashtable[(value+a)%size]=key;

                
            }
        }
*/
        

        for (int i = 0; i < size; i++) {
            key = 10000 + random.nextInt(90000);
            value = key % size;
            if (hashtable[value] < 0) {
                hashtable[value] = key;
                Empty++;
            } else {
                conflict++;
                int a = 1;
                while (hashtable[(value + a * a) % size] >= 0 && a <= 45000) {
                    a++;
                    full++;

                }
                hashtable[(value + a * a) % size] = key;

            }
        }

        
        for(int k=0; k<size;k++)
        {
            key=1000+random.nextInt(90000);
            value=key%size;
            if(hashtable[value]<0)
            {
                hashtable[value]=key;
            }
            else{
                int b=1;
                while(b< 45000 && hashtable[(value+b)%size]>=0)
                {
                    b++;
                }
                hashtable[(value+b)%size]=key;

                
            }
        }
        

        for (int i = 0; i < size; i++) {

            System.out.println(hashtable[i]);
        }

        System.out.println("Yer dolu sayisi: " + full);
        System.out.println("Tekte yerlesme sayisi: " + Empty);
        System.out.println("conflict sayisi: " + conflict);
    }
}