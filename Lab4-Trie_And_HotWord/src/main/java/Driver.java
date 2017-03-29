import com.sun.deploy.util.ArrayUtil;
import edu.princeton.cs.introcs.In;

import java.lang.*;
import java.net.URL;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class Driver {

    public static void main(String[] args) {

        String[] trieWords = new String[1007];
        int i = 0;
        TrieForStrings trie = new TrieForStrings();
        URL url = ClassLoader.getSystemResource("kap1.txt");

        if (url != null) {
            System.out.println("Reading from: " + url);
        } else {
            System.out.println("Couldn't find file: kap1.txt");
        }

        In input = new In(url);

        while (!input.isEmpty()) {
            String line = input.readLine().trim();
            String[] words = line.split("(\\. )|:|,|;|!|\\?|( - )|--|(\' )| ");
            String lastOfLine = words[words.length - 1];

            if (lastOfLine.endsWith(".")) {
                words[words.length - 1] = lastOfLine.substring(0, lastOfLine.length() - 1);
            }

            for (String word : words) {
                String word2 = word.replaceAll("\uFEFF|\"|\\(|.\\)|", "");

                if (word2.isEmpty()) {
                    continue;
                }
                word2 = word2.toLowerCase();
                System.out.println(word2);
                // Add the word to the trie
                trie.put(word2);
                trieWords[i] = word2;
                i++;
            }
        }

        //Perform analysis
        /* Question 4 */
        System.out.println("Total number of words: " + trie.count(""));
        for (char c = 'a'; c <= 'z'; c++) {
            int j = trie.distinct(Character.toString(c));
            System.out.println(c + " " + "is the start of a word: " + j + " times.");
        }

        /* Question 3 */
        String prefix2, total1 = "";
        int total = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            for (char h = 'a'; h <= 'z'; h++) {
                prefix2 = "" + c + h;
                if (trie.count(prefix2) != 0 && trie.count(prefix2) > total) {
                    total = trie.count(prefix2);
                    total1 = prefix2;
                }
            }
        }
        System.out.println("Most frequent prefix is: " + total1 + " used " + total + " times.");

        /* Question 2*/
        int prevVal = 1, cnt = 0;
        String finString = "";
        System.out.println("The 10 least frequent words are: ");
        for (int j = 1; j < 1007; j++) {
            if (trie.get(trieWords[j]) != 0 && trie.get(trieWords[j]) <= prevVal && cnt < 10) {
                prevVal = trie.get(trieWords[j]);
                finString = trieWords[j];
                cnt++;
                System.out.println("Number " + cnt + " " + finString + " used " + (double) prevVal / 1007 + "%" + " used " + prevVal + " times.");
            }
        }

        /* Question 1 */
        System.out.println("The 10 most frequent words are: ");


    }
}
