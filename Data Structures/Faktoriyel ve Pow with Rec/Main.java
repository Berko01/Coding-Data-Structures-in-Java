public class Main {

    static int counter1;
    static int counter2;

    static int counter3;
    static int counter4;

    public static int PowAlbert(int a, int n) {
        if (n == 0) {
            counter3++;
            return 1;
        } else if (n == 1) {
            counter3++;
            return a;
        } else {
            counter3++;
            return a * PowAlbert(a, n - 1);
        }
    }

    public static int multiplicationByAddition(int a, int n) {

        if (n == 0) {
            return 0;
        }
        ;
        if (n == 1) {
            return a;
        } else {
            return a + multiplicationByAddition(a, n - 1);
        }

    }

    public static int PowPinto(int a, int n) {
        
        if(n==0){
            return 1;
        }
        else if(n%2==0){
            int y;
            y=PowPinto(a, n/2);
            return y*y;
        }
        else{
            return a*PowPinto(a, n-1);
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            counter1++;
            return 1;
        } else {
            counter1++;
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int FibIterative(int n) {

        int previous = 1, next = 1, sum = 1;
        for (int i = 1; i < n; i++) {
            previous = next;
            next = sum;
            sum = next + previous;
            counter2++;
        }
        return sum;

    }

    /*
     * public static int fakctorial(int n){
     * if(n==1)
     * {
     * 
     * }
     * else{
     * return factorial(n)*factorial(n-1);
     * }
     * 
     * }
     */

    public static void main(String[] args) {

        System.out.println(PowAlbert(2, 5));
        System.out.println(PowPinto(2, 5));
        System.out.println(fibonacci(6));
        System.out.println(FibIterative(6));

        System.out.println("Rec islem sayisi:" + counter1 + " ve normal islem sayisi " + counter2);

        System.out.println(multiplicationByAddition(4, 5));

    }
}