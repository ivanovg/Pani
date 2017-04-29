package exersize2;

/**
 * Created by Georgi on 3/21/2017.
 */
public class Magic {

    public static void main(String[] args) {
        int result;
        System.out.println("  a    b    t  ");
        result = magic(12, 16);
        System.out.println("Ergebnis: " + result + "\n\n");
        System.out.println("  a    b    t  ");
        result = magic(180, 120);
        System.out.println("Ergebnis: " + result + "\n\n");
        System.out.println("  a    b    t  ");
        result = magic(0, 177);
        System.out.println("Ergebnis: " + result + "\n\n");
        System.out.println("  a    b    t  ");
        result = magic(5, 14);
        System.out.println("Ergebnis: " + result + "\n\n");
    }

    public static int magic(int a, int b) {
        int k = 0;
        if (b == 0)
            return a;
        while (a > 0) {
            System.out.printf("%3d%5d%5d\n", a, b, k);
            while (a % 2 == 0 && b % 2 == 0) {
                a = a / 2;
                b = b / 2;
                k++;
                System.out.printf("%3d%5d%5d\n", a, b, k);
            }
            if (a % 2 == 1) {
                int temp = a;
                a = b;
                b = temp;
                System.out.printf("%3d%5d%5d\n", a, b, k);
            }
            while (a % 2 == 0) {
                a = a / 2;
                System.out.printf("%3d%5d%5d\n", a, b, k);
            }
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
                System.out.printf("%3d%5d%5d\n", a, b, k);
            }
            a = a - b;

        }
        System.out.printf("%3d%5d%5d\n", a, b, k);
        return b * (int)Math.pow(2.0, k);
    }

}
