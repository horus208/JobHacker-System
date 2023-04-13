public class Main {
    public static void main(String[] args)
    {
        WordDict dict = new WordDict();
        dict.addWord("abz");
        dict.addWord("abc");
        dict.addWord("abd");
        dict.addWord("mzw");
        dict.addWord("muf");

        dict.printAll();
        dict.printByLetter('a');




    }
}
