package leetcode.src.com.medium;

public class Trie {
    
    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
      children = new Trie[26];
      isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
      Trie node = this;
      for(int i = 0;i<word.length();i++) {
        char ch = word.charAt(i);
        int index = ch - 'a';
        if(node.children[index] == null) {
          node.children[index] = new Trie();
          node.children[index].isEnd = false;
        }
        node = node.children[index];
      }
      node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    //   Trie node = this;
    //   for(int i = 0; i < word.length(); i++) {
    //     char ch = word.charAt(i);
    //     int index = ch - 'a';
    //     if(node.children[index] == null) {
    //       return false;
    //     }
    //     node = node.children[index];
    //   }
    //   return node.isEnd == true;
        Trie node = searchPrefix(word);
        return node != null && node.isEnd == true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
    //   Trie node = this;
    //   for(int i = 0; i < prefix.length(); i++) {
    //     char ch = prefix.charAt(i);
    //     int index = ch - 'a';
    //     if(node.children[index] == null) {
    //       return false;
    //     }
    //     node = node.children[index];
    //   }
    //   return true;
        return node != null;
    }

    public Trie searchPrefix(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
