
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1660/C
 */

import java.io.IOException;
import java.util.Scanner;

public class EvenString
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);

        int tests = Integer.parseInt(input.nextLine());

        while(tests > 0)
        {
            tests--;
            solve(input);
        }
    }

    public static void solve(Scanner input) throws IOException
    {
        char[] str = input.nextLine().toCharArray();

        int oddIdx = 0, evenIdx = 1, dels = 0, idx = 0;

        while(evenIdx < str.length)
        {
            // There is a faulting pair.
            if(str[oddIdx] != str[evenIdx])
            {
                // A character must be removed.
                dels++;
                idx = evenIdx + 1;

                while(true)
                {
                    if(idx == str.length)
                    {
                        dels++;
                        evenIdx += 2;
                        oddIdx = evenIdx - 1;
                        break;
                    }

                    if(str[idx] == str[oddIdx])
                    {
                        evenIdx++;
                        break;
                    }
                    else if(str[idx] == str[evenIdx])
                    {
                        oddIdx = evenIdx;
                        evenIdx++;
                        break;
                    }

                    idx++;
                }

            }
            else
            {
                evenIdx += 2;
                oddIdx = evenIdx - 1;
            }
        }

        // If there is a single character at the end.
        if(evenIdx == str.length)
        {
            dels++;
        }

        System.out.println(dels);
    }
}