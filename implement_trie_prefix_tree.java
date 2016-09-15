class TrieNode {
    // Initialize your data structure here.
    char val;
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
                    break;
                }
            }
            if (!isFound) {
                TrieNode newTN = new TrieNode(word.charAt(i));
                tn.next.add(newTN);
                i++;
                while (i < word.length()) {
                    TrieNode tmpNode = new TrieNode(word.charAt(i));
                    newTN.next.add(tmpNode);
                    i++;
                    newTN = tmpNode;
                }
                return;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return false;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
