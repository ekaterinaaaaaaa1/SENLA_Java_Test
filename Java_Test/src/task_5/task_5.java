package task_5;

import java.util.Arrays;
import java.util.stream.Stream;

public class task_5 {
    public static void main(String[] args)
    {
        Object[] objects = {new Object("пицца", 3, 500),
                            new Object("бутерброд", 1, 250),
                            new Object("круассан", 1, 200),
                            new Object("салат", 2, 350),
                            new Object("ролл", 2, 700),};
        
        int count = objects.length;
        int safe = 5;
        Backpack[][] backpack = new Backpack[count + 1][safe + 1];
        
        for(int i = 0; i < count + 1; i++)
        {
            for(int j = 0; j < safe + 1; j++)
            {
                if(i == 0 || j == 0)
                {
                    backpack[i][j] = new Backpack(new Object[]{}, 0);
                }
                else if(i == 1)
                {
                    if (objects[0].volume <= j)
                    {
                        backpack[i][j] = new Backpack(new Object[]{objects[0]}, objects[0].value);
                    }
                    else
                    {
                        backpack[i][j] = new Backpack(new Object[]{}, 0);
                    }
                }
                else
                {
                    if (objects[i - 1].volume > j)
                    {
                        backpack[i][j] = backpack[i - 1][j];
                    }
                    else
                    {
                        int optValue = objects[i - 1].value + backpack[i - 1][j - objects[i - 1].volume].value;
                        if(backpack[i - 1][j].value > optValue)
                        {
                            backpack[i][j] = backpack[i - 1][j];
                        }
                        else
                        {
                            backpack[i][j] = new Backpack(Stream.concat(Arrays.stream(new Object[]{objects[i - 1]}), Arrays.stream(backpack[i - 1][j - objects[i - 1].volume].objects)).toArray(Object[]::new), optValue);
                        }
                    }
                }
            }
        }
        
        System.out.println("Максимальная ценность набора: " + Integer.toString(backpack[count][safe].value));
        System.out.println("Набор:");
        for(Object obj : backpack[count][safe].objects)
        {
            System.out.println(obj.name + ": объём - " + Integer.toString(obj.volume) + ", ценность - " + Integer.toString(obj.value) + ";");
        }
    }
}
