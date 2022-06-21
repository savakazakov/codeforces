import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class DirectionalIncrease
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n;
            long diff;

            boolean flag;

            long[] target, temp;

            for(int i = 0; i < tests; i++)
            {
                // Get the input.
                n = myObj.nextInt();

                flag = false;

                target = new long[n];
                temp = new long[n];

                for(int j = 0; j < n; j++)
                {
                    target[j] = myObj.nextLong();
                }

                for(int j = n - 1; j > 0; j--)
                {
                    if(target[j] != 0)
                        flag = true;

                    if(target[j] > temp[j] || (flag && target[j] == temp[j]))
                        break;
                    else
                    {
                        temp[j - 1] += temp[j] - target[j];
                        temp[j] -= temp[j] - target[j];
                    }
                }

                if(Arrays.equals(temp, target))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
}
/*
1
4
1 -1 1 -1
*/