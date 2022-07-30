
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1691/C
 */

import java.io.IOException;
import java.util.Scanner;

public class SubstringSum
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);

        int tests = input.nextInt();

        while(tests > 0)
        {
            tests--;
            solve(input);
        }
    }

    public static void solve(Scanner input) throws IOException
    {
        int n = input.nextInt(), k = input.nextInt(), p1_first = 0, p1_last = 0, add = 0, numOfOnes = 0;
        input.nextLine();

        String s = input.nextLine();

        // Calculate the 1s in the String.
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '1')
                numOfOnes++;
        }

        // Get the positions of the first and last 1s.
        p1_last = s.lastIndexOf('1');
        p1_first = s.indexOf('1');

        // The trick is to count the regular ones as 11s and the first and last
        // positions independently. And these if statements are triggered if 1s are
        // already in the last/first place.
        if(numOfOnes > 0 && (n - 1 - p1_last) <= k)
        {
            k -= (n - 1 - p1_last);
            add += 1;
            numOfOnes -= 1;
        }

        if(numOfOnes > 0 && p1_first <= k)
        {
            k -= (p1_first);
            add += 10;
            numOfOnes -= 1;
        }

        System.out.println(numOfOnes * 11 + add);
    }
}