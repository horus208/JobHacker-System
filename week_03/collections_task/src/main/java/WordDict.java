import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class WordDict {

    Map<Character, TreeSet<String>> dict = new HashMap<>();


    public void addWord(String word)
    {
        if(!dict.containsKey(word.charAt(0)))
            dict.put(word.charAt(0),new TreeSet<>());

        dict.get(word.charAt(0)).add(word);


    }

    public void printAll()
    {
        dict.forEach((k,v)-> System.out.println(k+"  --->  "+ v));
    }
    public void printByLetter(Character letter)
    {
        System.out.println(letter + "  --->  " + dict.get(letter));

    }
}
