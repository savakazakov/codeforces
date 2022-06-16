import java.util.Scanner;

public class BlackAndWhiteStripes
{

    public static void main(String[] args)
    {
        try (Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n, k, min, count;

            String str;

            for (int i = 0; i < tests; i++)
            {
                n = myObj.nextInt();
                k = myObj.nextInt();

                str = myObj.next();

                char[] charStr = str.toCharArray();

                count = 0;

                for (int j = 0; j < k; j++)
                {
                    if (charStr[j] == 'W')
                        count++;
                }

                min = count;

                for (int j = k; j < n; j++)
                {
                    if(charStr[j-k] == 'W' && charStr[j] == 'B')
                    {
                        count--;
                        
                        if(count < min)
                        {
                            min = count;
                        }

                        if(min == 0)
                            break;
                    }
                    else if(charStr[j-k] == 'B' && charStr[j] == 'W')
                        count++;
                }

                System.out.println(min);
            }
        }
    }
}