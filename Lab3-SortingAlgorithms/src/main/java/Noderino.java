/**
 * Created by alexander on 2016-11-21.
 */
public class Noderino {
    int data;
    Noderino next;

    public int compareTo(Noderino n) {
        if(n != null) {
            int x = n.data;
            return this.data - x;
        } else {
            return -1;
        }
    }

}
