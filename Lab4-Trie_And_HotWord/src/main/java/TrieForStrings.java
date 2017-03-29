import edu.princeton.cs.algs4.Queue;

/**
 * Created by alexander on 2016-11-24.
 */

public class TrieForStrings {

    private static int R = 256;
    public Node root;

    private static class Node {

        private int dat;
        private Node[] next = new Node[R];
    }

    public int get(String k) {

        Node x = get(root, k, 0);
        if (x == null) return 0;
        return x.dat;
    }

    private Node get(Node x, String k, int d) {

        if (x == null) return null;
        if (d == k.length()) return x;
        char c = k.charAt(d);
        return get(x.next[c], k, d + 1);
    }

    public void put(String k) {
        root = put(root, k, 0);
    }

    private Node put(Node x, String k, int d) {

        if (x == null) x = new Node();
        if (d == k.length()) {
            if (x.dat == 0) {
                x.dat = 1;
            } else { x.dat += 1; }
            return x;
        }
        char c = k.charAt(d);
        x.next[c] = put(x.next[c], k, d + 1);
        return x;
    }

    private int count = 0;

    public int count(String k) {

        count = 0;
        Node x = get(root, k, 0);
        Queue q = new Queue();
        if (x == null) {
            return 0;
        }
        for (char c = 0; c < R; c++) {
            collect(x.next[c], k + c, q);
        }
        return count;

    }

    private int dist = 0;

    public int distinct(String k) {

        dist = 0;
        count (k);
        return dist;
    }


    public Iterable iterate(String k) {

        Queue q = new Queue();
        collect(get(root, k, 0), k, q);
        return q;
    }

    private void collect(Node x, String k, Queue q) {

        if (x == null) {
            return;
        }
        if (x.dat != 0) {
            q.enqueue(k);
            count = count + x.dat;
            dist++;
        }
        for (char c = 0; c < R; c++) {
            collect(x.next[c], k + c, q);
        }
    }
}
