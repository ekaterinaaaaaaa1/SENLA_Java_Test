package task_4;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Scanner;

public class task_4 {
    public static void main(String[] args)
    {
        String[] figure0 = new String[]{"  ***  ", " *   * ", "*     *", "*     *", "*     *", " *   * ", "  ***  "};
        String[] figure1 = new String[]{"   *   ", "  **   ", " * *   ", "*  *   ", "   *   ", "   *   ", "   *   "};
        String[] figure2 = new String[]{" ***   ", "*   *  ", "   *   ", "  *    ", " *     ", "*      ", "*****  "};
        String[] figure3 = new String[]{" ***   ", "*   *  ", "   *   ", "  *    ", "   *   ", "*   *  ", " ***   "};
        String[] figure4 = new String[]{"    *  ", "   **  ", "  * *  ", " *  *  ", "****** ", "    *  ", "    *  "};
        String[] figure5 = new String[]{"****   ", "*      ", "***    ", "   *   ", "   *   ", "   *   ", "***    "};
        String[] figure6 = new String[]{"    *  ", "   *   ", "  *    ", " *     ", "* * *  ", "*    * ", " ****  "};
        String[] figure7 = new String[]{"****** ", "     * ", "    *  ", "   *   ", "  *    ", " *     ", "*      "};
        String[] figure8 = new String[]{" ***   ", "*   *  ", "*   *  ", " ***   ", "*   *  ", "*   *  ", " ***   "};
        String[] figure9 = new String[]{" ****  ", "*    * ", " *  *  ", "   *   ", "  *    ", " *     ", "*      "};    
        String[][] figures = {figure0, figure1, figure2, figure3, figure4, figure5, figure6, figure7, figure8, figure9};
        
        System.out.print("¬ведите число: ");
        Scanner console = new Scanner(System.in, "Utf8");
        String text = console.nextLine();
        ArrayList<Integer> picture = new ArrayList();
        
        Pattern pattern = Pattern.compile("[0123456789]");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
        {
            picture.add(Integer.parseInt(matcher.group()));
        }
        
        int max = picture.get(0);
        for(int i = 1; i < picture.size(); i++)
        {
            if(picture.get(i) > max)
            {
                max = picture.get(i);
            }
        }
        System.out.println(max);
        
        for(int j = 0; j < figures[max].length; j++)
        {
            figures[max][j] = figures[max][j].replace("*", Integer.toString(max));
        }
        
        for(int j = 0; j < figures[0].length; j++)
        {
            for(int i = 0; i < picture.size(); i++)
            {
                System.out.print(figures[picture.get(i)][j].toString() + " ");
            }
            System.out.println();
        }
    }
}
