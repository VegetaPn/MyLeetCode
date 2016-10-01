package xyz.yhngo.main;


/**
 * Created by Vegeta on 9/17/16.
 */
class TNode {
    char val = ' ';
    TNode[] next = new TNode[26];
    boolean isEnd = false;
}

public class WordDictionary {
    private final int seg = 97;
    private TNode[] dict = new TNode[26];

    WordDictionary() {
        initDict(dict);
    }

    private void initDict(TNode[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TNode();
        }
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TNode[] newDict = dict;
        int i, pos;
        for (i = 0; i < word.length()-1; i++) {
            pos = (int)word.charAt(i) - seg;
            if (newDict[pos] == null) {
                newDict[pos] = new TNode();
            }
            newDict[pos].val = word.charAt(i);
            newDict = newDict[pos].next;
        }
        pos = (int)word.charAt(i) - seg;
        if (newDict[pos] == null) {
            newDict[pos] = new TNode();
        }
        newDict[pos].val = word.charAt(i);
        newDict[pos].isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, dict, 0);
    }

    public boolean search(String word, TNode[] nodes, int pos) {
        if (nodes == null || pos >= word.length()) {
            return false;
        }

        if (word.charAt(pos) == '.') {
            if (pos == word.length()-1) {
                for (TNode node : nodes) {
                    if (node != null && node.isEnd) return true;
                }
                return false;
            }

            for (TNode node : nodes) {
                if (node != null && search(word, node.next, pos+1)) {
                    return true;
                }
            }
        } else {
            TNode node = nodes[(int)word.charAt(pos) - seg];
            if (node != null && node.val == word.charAt(pos)) {
                if (pos == word.length()-1) {
                    return node.isEnd;
                }
                return search(word, node.next, pos+1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
        System.out.println(wd.search("an."));
        System.out.println(wd.search("a.d."));
        System.out.println(wd.search("b."));
        System.out.println(wd.search("a.d"));
        System.out.println(wd.search("."));
    }
}
