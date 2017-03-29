import java.util.Arrays;

/**
 * Created by alexander on 2016-11-03.
 */
public class RecursivePascalImproved extends ErrorPascal implements Pascal {


    public boolean triangleUp; /* true ▲, false ▼ */

    public void printPascal(int n) {
        int k;
        int c = n / 2;

        int arrayN[] = new int[n + 1];

        if (n >= 0 && !triangleUp) {                              /*Upside down triangle */
            for (k = 0; k <= n / 2; k++) {
                arrayN[k] = (binom(n, k));
            }

            for (int j = n / 2; j <= n; j++) {
                if (n % 2 == 0) {
                    if (c <= n && c >= 0) {
                        arrayN[j] = arrayN[c];
                    }
                    c--;
                } else {
                    j++;
                    if (c <= n && c >= 0 && j <= n) {
                        arrayN[j] = arrayN[c];
                    }
                    c--;
                    j--;
                }
            }

            if (arrayN[n] >= 0) {
                System.out.print(Arrays.toString(arrayN));
                System.out.println();
            }
            printPascal(n - 1);
        }

        if (n >= 0 && triangleUp) {                               /*Normal triangle */
            printPascal(n - 1);

            for (k = 0; k <= n / 2; k++) {
                arrayN[k] = (binom(n, k));
            }

            for (int j = n / 2; j <= n; j++) {
                if (n % 2 == 0) {
                    if (c <= n && c >= 0) {
                        arrayN[j] = arrayN[c];
                    }
                    c--;
                } else {
                    j++;
                    if (c <= n && c >= 0 && j <= n) {
                        arrayN[j] = arrayN[c];
                    }
                    c--;
                    j--;
                }
            }

            if (arrayN[n] >= 0) {
                System.out.print(Arrays.toString(arrayN));
                System.out.println();
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
