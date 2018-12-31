public class Main {
    public static void main (String[] args) {
        for (int i=0; i<10; i++) {
            Triple triple = Triple.getInstance(i%3);
            System.out.println(i + " : " + triple);
            System.out.println(i + " %3  = " + i%3);
        }
    }
}