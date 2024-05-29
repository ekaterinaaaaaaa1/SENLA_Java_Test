package task_1;
import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        char[] charArray = str.toCharArray();

        int sum = 0;
        for(int i = 0; i < charArray.length; i++)
        {
            int code = (int)charArray[i];
            if (code >= 48 && code <= 57)
            {
                sum += Character.getNumericValue(charArray[i]);
            }
        }
        
        System.out.println("Сумма цифр в строке равна " + sum);
    }
}
