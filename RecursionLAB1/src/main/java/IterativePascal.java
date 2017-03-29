/**
 * Created by alexander on 2016-11-04.
 */
public class IterativePascal extends ErrorPascal implements Pascal {

    public boolean triangleUp = false;
    public int n;
    public int arrayN[][];

    public void printPascal(int n) {

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i + 1; k++) {
                arrayN[i][k] = binom(i, k);
            }
        }

        if (triangleUp) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arrayN[i][j] == 0) {
                        if (j == n - 1) {
                            System.out.println();
                        } else {
                            continue;
                        }
                    } else {
                        System.out.print(arrayN[i][j] + " ");
                    }
                }
            }
        }
        if (!triangleUp) {

            for (int i = n-1; i >= 0; i--) {
                for (int j = n -1; j >= 0; j--) {
                    if (arrayN[i][j] == 0) {
                        if (j == n - 1) {
                            System.out.println();
                        } else {
                            continue;
                        }
                    } else {
                        System.out.print(arrayN[i][j] + " ");
                    }
                }
            }

        }

    }

    public int binom(int n, int k) {
        if (k == n || k == 0) {
            return 1;
        } else {
            return arrayN[n - 1][k - 1] + arrayN[n - 1][k];
        }
    }

}
