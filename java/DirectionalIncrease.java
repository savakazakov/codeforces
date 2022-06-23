
/**
 * This problem's task can be found at : https://codeforces.com/problemset/problem/1693/A
 */

import java.util.Scanner;

public class DirectionalIncrease
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n;

            boolean equalsFail, result;

            long[] target, temp;

            for(int i = 0; i < tests; i++)
            {
                // Get the input.
                n = myObj.nextInt();

                equalsFail = false;

                target = new long[n];
                temp = new long[n];

                result = true;

                for(int j = 0; j < n; j++)
                {
                    target[j] = myObj.nextLong();
                }

                for(int j = n - 1; j > 0; j--)
                {
                    // Indicates there are no more trailing zeroes
                    // and equality breaking the process.
                    if(target[j] != 0)
                        equalsFail = true;

                    // If it breaks at any point the result should be "No",
                    // since the pointer is not on the first element.
                    if(target[j] > temp[j] || (equalsFail && target[j] == temp[j]))
                    {
                        result = false;
                        break;
                    }
                    else
                    {
                        temp[j - 1] += temp[j] - target[j];
                        temp[j] -= temp[j] - target[j];
                    }
                }

                if(result && temp[0] == target[0])
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
}