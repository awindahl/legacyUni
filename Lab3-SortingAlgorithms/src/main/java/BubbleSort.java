import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by alexander on 2016-11-20.
 */
public class BubbleSort {

    public void myBubSorting() {

        int cnt = 0;
        int invCnt = 0;

        int u = (int) Math.ceil(Math.random() * 1000);  // random array size
        int[] a;
        a = new int[u];

        for (int j = 0; j < u - 1; j++) {
            a[j] = (int) Math.ceil(Math.random() * 1000); // random array contents
        }

        int n = a.length;

        myLinkedList c = new myLinkedList();

        for (int num : a) {
            c.add(num);
        }

        int R = n - 1;

        System.out.print("Before Sorting: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(c.index(i).data + " ");
        }
        System.out.println();

        for (int p = 0; p <= R; p++) {
            for (int j = p; j <= R; j++) {
                if (a[p] < a[j]) {
                    invCnt++;
                }
            }
        }



        while (R >= 0) {

            for (int i = 0; i <= R; i++) {
                if (c.index(i).compareTo(c.index(i + 1)) > 0) {
                    int temp = c.index(i).data;
                    c.index(i).data = c.index(i + 1).data;
                    c.index(i + 1).data = temp;
                    cnt++;
                }
            }
            R--;
        }

        System.out.print("After Sorting: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(c.index(i).data + " ");
        }

        System.out.println();
        System.out.println("Inversions: " + invCnt);
        System.out.print("Swaps: " + cnt);

    }


    public void BubSorting() {

        int cnt = 0;
        int invCnt = 0;

        int u = (int) Math.ceil(Math.random() * 10);  // random array size
        int[] a;
        a = new int[u];

        for (int j = 0; j < u - 1; j++) {
            a[j] = (int) Math.ceil(Math.random() * 10); // random array contents
        }

        int n = a.length;

        LinkedList<Integer> c = new LinkedList<Integer>();

        for (int num : a) {
            c.add(num);
        }

        System.out.println(c);


        int R = n - 1;
        boolean swapped = true;

        for (int p = 0; p <= R; p++) {
            for (int j = p; j <= R; j++) {
                if (a[p] > a[j]) {
                    invCnt++;
                }
            }
        }


        while (swapped && R >= 0) {
            swapped = false;
            for (int i = 0; i < R; i++) {
                if (c.get(i) > c.get(i + 1)) {
                    swapped = true;
                    Collections.swap(c, i, i + 1);
                    cnt++;
                }
            }
            R--;
        }

        System.out.print(c);
        System.out.println();
        System.out.println("Calls to Swap: " + cnt);
        System.out.print("Inversions: " + invCnt);
    }
}


