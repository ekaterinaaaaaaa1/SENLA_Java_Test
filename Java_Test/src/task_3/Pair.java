package task_3;

public class Pair {
    String word;
    int vowels;
    
    public Pair(String word, int vowels)
    {
        this.word = word;
        this.vowels = vowels;
    }
    
    public static int compare(Pair first, Pair second) {
        int result = Integer.compare(first.vowels, second.vowels);
        return -result;
    }
}
