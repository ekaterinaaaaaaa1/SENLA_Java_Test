package task_3;
import java.util.Scanner;
import java.util.*;
import java.util.regex.*;

public class task_3 {
    public static void main(String[] args)
    {
        System.out.print("Ââåäèòå òåêñò: ");
        Scanner console = new Scanner(System.in, "Utf8");
        String text = console.nextLine();
        String[] words = text.split(" ");
        
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        
        Pattern vowels = Pattern.compile("[àå¸èîóûışÿÀÅ¨ÈÎÓÛİŞß]");
        for(int i = 0; i < words.length; i++)
        {
            Matcher matcher = vowels.matcher(words[i]);
            int count = 0;
            while(matcher.find())
            {
                count++;
            }
            Pair pair = new Pair(words[i], count);
            pairs.add(pair);
        }
        
        Collections.sort(pairs, Pair::compare);

        for(int i = 0; i < words.length; i++)
        {
            System.out.println(pairs.get(i).word);
        }
    }
}