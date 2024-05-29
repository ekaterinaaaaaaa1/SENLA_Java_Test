package task_2;
import java.util.Scanner;
import java.util.ArrayList;

public class task_2 {
    public static ArrayList Eratosthenes(int N)
    {
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 0; i < N + 1; i++)
        {
            primes.add(i);
        }
        
        primes.set(1, 0);
        int i = 2;
        while(i <= N)
        {
            if(primes.get(i) != 0)
            {
                int j = i * 2;
                while(j <= N)
                {
                    primes.set(j, 0);
                    j = j + i;
                }
            }
            i += 1;
        }
        
        for(int k = 0; k < primes.size(); k++)
        {
            if(primes.get(k) == 0)
            {
                primes.remove(k);
                k -= 1;
            }
        }
        
        return primes;
    }
    
    public static void main(String[] args) {
        System.out.print("Введите натуральное число: ");
        Scanner console = new Scanner(System.in);
        try
        {
            float number = console.nextFloat();
            
            if (number < 1)
            {
                System.out.println("Ошибка: введённое число не натуральное!");
                System.exit(1);
            }
            if (Math.floor(number) * 10 - number * 10 != 0)
            {
                System.out.println("Ошибка: введённое число не целое!");
                System.exit(1);
            }
            
            int N = (int)number;
            System.out.print("Факторизация числа " + Integer.toString(N) + ": ");
        
            ArrayList<Integer> primes = new ArrayList<>();
            primes = Eratosthenes(N);
            
            ArrayList<Integer> factorisation = new ArrayList<>();
            int i = 0;
            while(N != 1)
            {
                while(N % primes.get(i) == 0)
                {
                    N /= primes.get(i);
                    factorisation.add(primes.get(i));
                }
                i++;
            }
            
            System.out.println(factorisation);
        }
        catch(Exception e)
        {
            System.out.println("Ошибка: неверный тип данных!");
            System.exit(1);
        }
    }
}
