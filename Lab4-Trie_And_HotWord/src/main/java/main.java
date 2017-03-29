/**
 * Created by alexander on 2016-11-24.
 */
public class main {

    public static void main(String args[]) {
        TrieForStrings t = new TrieForStrings();

        t.put("HelloWorld");
        t.put("Hellbender");
        t.put("Helicopter");
        t.put("Helicopter");

        System.out.println(t.get("Helicopter"));
    }
}
