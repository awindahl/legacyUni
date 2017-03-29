/**
 * Created by alexander on 2016-11-21.
 */
public class myLinkedList {
    public Noderino top;

    public void add(int data) {

        if (top == null) {
            top = new Noderino();
        }

        Noderino temp = new Noderino();
        temp.data = data;

        if (top == null) {
            top = temp;
        } else {
            temp.next = top;
            top = temp;
        }
    }

    Noderino index(int index) {
        Noderino n = top;
        for (int i = 0; i < index-1; i++) {
            n = n.next;
        }
        return n;
    }
}
