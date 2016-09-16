package xyz.yhngo.main;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Vegeta on 9/15/16.
 */
class TrieNode {
    // Initialize your data structure here.
    char val;
    boolean isEnd = false;
    ArrayList<TrieNode> next = new ArrayList<>();

    public TrieNode() {

    }

    public TrieNode(char val) {
        this.val = val;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode tn = root;
        int i = 0;
        boolean isFound = false;
        while (i < word.length()) {
            isFound = false;
            for (Iterator<TrieNode> iter = tn.next.iterator(); iter.hasNext();) {
                TrieNode curNode = iter.next();
                if (word.charAt(i) == curNode.val) {
                    isFound = true;
                    i++;
                    tn = curNode;
                    if (i == word.length()) {
                        curNode.isEnd = true;
                    }
                    break;
                }
            }
            if (!isFound) {
                while (i < word.length()) {
                    TrieNode tmpNode = new TrieNode(word.charAt(i));
                    tn.next.add(tmpNode);
                    tn = tmpNode;
                    i++;
                    if (i == word.length()) {
                        tmpNode.isEnd = true;
                    }
                }
                return;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        boolean isFound = false;
        int i = 0;
        TrieNode tn = root;
        while (i < word.length()) {
            isFound = false;
            for (Iterator<TrieNode> iter = tn.next.iterator(); iter.hasNext();) {
                TrieNode curNode = iter.next();
                if (word.charAt(i) == curNode.val) {
                    isFound = true;
                    i++;
                    tn = curNode;
                    if (i == word.length()) {
                        return curNode.isEnd;
                    }
                    break;
                }
            }
            if (!isFound) {
                return false;
            }
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        boolean isFound = false;
        int i = 0;
        TrieNode tn = root;
        while (i < prefix.length()) {
            isFound = false;
            for (Iterator<TrieNode> iter = tn.next.iterator(); iter.hasNext();) {
                TrieNode curNode = iter.next();
                if (prefix.charAt(i) == curNode.val) {
                    isFound = true;
                    i++;
                    tn = curNode;
                    break;
                }
            }
            if (!isFound) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hope");
        trie.insert("hi");
        trie.insert("thankyou");
        trie.insert("bye");
        trie.insert("a");
        System.out.println(trie.search("he"));
        System.out.println(trie.startsWith("he"));
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
        System.out.println("end");
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
