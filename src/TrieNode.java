import java.util.Arrays;

public class TrieNode {
    static int totalCharacter = 256; // Total characters to accommodate (ASCII)
    char ch;
    TrieNode[] children;
    boolean isTerminal;

    public TrieNode() {
        children = new TrieNode[totalCharacter];
        Arrays.fill(children, null);  // Initialize all children to null
        this.isTerminal = false;  // By default, it's not a terminal node
    }

    public TrieNode(char ch) {
        this();  // Call the default constructor to initialize the children array
        this.ch = ch;
    }

    // Insert method
    public void insert(String word) {
        TrieNode currentNode = this;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);  // Get the character at the current position

            // Check if the current node has a child for the given character
            if (currentNode.children[ch] == null) {
                currentNode.children[ch] = new TrieNode(ch);  // Create a new node if it doesn't exist
            }

            // Move to the child node corresponding to the character
            currentNode = currentNode.children[ch];
        }

        // Mark the end of the word
        currentNode.isTerminal = true;
    }

    // Deletion method (to be implemented)
    public void delete(TrieNode root, String word) {
        // Logic for deletion can be implemented here
    }

    // Check if a word exists in the Trie
    public boolean isExist( String word) {
        TrieNode currentNode = this;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);

            // If the character is not in the Trie, return false
            if (currentNode.children[ch] == null) {
                return false;
            }

            // Move to the child node
            currentNode = currentNode.children[ch];
        }

        // Return true only if the last node marks the end of the word
        return currentNode.isTerminal;
    }

    // Print Trie (for testing purposes)
    public void printTrie() {
        // We call a helper function with an empty string to accumulate characters
        printTrieHelper(this, "");
    }

    // Helper function to perform DFS and collect words
    private void printTrieHelper(TrieNode currentNode, String prefix) {
        if (currentNode == null) {
            return;
        }

        // If current node is a terminal node, we print the accumulated prefix
        if (currentNode.isTerminal) {
            System.out.println(prefix);
        }

        // Traverse all possible children
        for (int i = 0; i < TrieNode.totalCharacter; i++) {
            // If the child node is not null, continue the traversal
            if (currentNode.children[i] != null) {
                char nextChar = (char) i;  // Convert index to character
                printTrieHelper(currentNode.children[i], prefix + nextChar);  // Recur with updated prefix
            }
        }
    }

}
