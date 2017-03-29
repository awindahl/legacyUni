import java.util.List;

/**
 * Created by alexander on 2016-12-05.
 */
public class bSearch {

    // return the index of the key in the sorted array a[]; -1 if not found
    public static int search(String key, List<Node> a) {
        return search(key, a, 0, a.size());
    }

    public static int search(String key,List<Node> a, int lo, int hi) {
        // possible key indices in (lo, hi)
        int mid = lo + (hi - lo) / 2;
        if (hi <= lo) return -mid-1;
        int cmp = a.get(mid).compareTo(key);
        if      (cmp > 0) return search(key, a, lo, mid);
        else if (cmp < 0) return search(key, a, mid+1, hi);
        else              return mid;
    }

}
