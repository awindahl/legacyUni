/**
 * Created by alexander on 2016-11-02.
 **/

public class RecursivePascal extends ErrorPascal implements Pascal {

    public boolean triangleUp; /* true ▲, false ▼ */

    public void printPascal(int n) {
        int k;

        if (n >= 0 && !triangleUp) {                              /*Upside down triangle */

            for (k = 0; k <= n; k++) {
                System.out.print(binom(n, k) + " ");
            }
            System.out.println();
            printPascal(n - 1);
        }

        if (n >= 0 && triangleUp) {                               /*Normal triangle */
            printPascal(n - 1);
            System.out.println();

            for (k = 0; k <= n; k++) {
                System.out.print(" " + binom(n, k));
            }
        }
    }

    public int binom(int n, int k) {
        if (n == 1 || k == 0 || k == n) {
            return 1;
        } else {
            return binom(n - 1, k - 1) + binom(n - 1, k);
        }
    }
}