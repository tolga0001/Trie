public class Main {
    public static void main(String[] args) {
        TrieNode vocabulary = new TrieNode();
        vocabulary.insert("book");
        vocabulary.insert("bake");
        vocabulary.insert("bakery");
        vocabulary.insert("ceil");
        vocabulary.insert("aim");
        vocabulary.insert("aid");
        vocabulary.insert("ceremony");
        vocabulary.printTrie();

        System.out.println(vocabulary.isExist("book"));
        System.out.println(vocabulary.isExist("aim"));
        System.out.println(vocabulary.isExist("air"));

    }
}