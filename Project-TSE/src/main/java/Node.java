import se.kth.id1020.util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 2016-11-21.
 */
public class Node implements Comparable<String> {

    String word;
    ArrayList<Attributes> attributeList = new ArrayList<Attributes>();
    ArrayList<Document> documentsList = new ArrayList<Document>();

    public Node(String addWord, Attributes addAttr) {
        this.word = addWord;
        this.attributeList.add(addAttr);
        this.documentsList.add(addAttr.document);
    }

    public void addAttributes(Attributes attr) {
        if (this.attributeList.contains(attr)) {
            return;
        } else {
            this.attributeList.add(attr);
            if (documentsList.contains(attr.document)) {
                return;
            } else {
                this.documentsList.add(attr.document);
            }
        }
    }

    public List<Document> getDoc() {
        return this.documentsList;
    }

    public List<Attributes> getAttr() {
        return this.attributeList;
    }

    public int compareTo(String o) {
        return word.compareTo(o);
    }
}
