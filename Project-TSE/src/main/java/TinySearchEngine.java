import se.kth.id1020.*;
import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 2016-11-30.
 */

public class TinySearchEngine implements TinySearchEngineBase {

    private List<Node> list = new ArrayList<Node>();

    public void insert(Word word, Attributes attr) {

        int i = bSearch.search(word.word, list);                  // get the index position of an already existing element
        int index = (-(i) - 1);                                   // get the index position of a new element

        if (i < 0) {
            list.add(index, new Node(word.word, attr));           // new node at index
        } else {
            Node p = list.get(i);
            p.addAttributes(attr);                                // add attributes to old node
            list.set(i, p);
        }

    }

    public List<Document> search(String query) {

        String temp;
        List<Document> result = new ArrayList<Document>();
        String delims = "[.,?! ]+";                               // splits the query into multiple words
        String[] tokens = query.split(delims);                    // adds the word to an array of Strings
        ArrayList<Attributes> attr = new ArrayList<Attributes>(); // array of Attributes to store attributes

        for (String token : tokens) {                             // go through all the words
            temp = token;
            int j = bSearch.search(temp, list);                   // binary search the list for relevant words
            if (j > 0) {
                //noinspection SuspiciousMethodCalls
                if (!attr.contains(list.get(j).getAttr())) {      // if we don't find the attributes, add them
                    attr.addAll(list.get(j).getAttr());
                }
            }
        }

        for (Attributes anAttr : attr) {                          // write the relevant attributes to a new list
            if (!result.contains(anAttr.document))                // such that it satisfies the union
                result.add(anAttr.document);                      // and no duplicates are included.
        }

        return result;

        /**
         * Old Search for only one term:
         *
         *int i = (bSearch.search(query, list));
         *if ( i < 0) {
         *return null;
         *}
         *Node n = list.get(i);
         *return n.getDoc();
         *
         */

    }
}


