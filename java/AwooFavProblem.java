
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1697/C
 */

import java.io.IOException;
import java.util.Scanner;

public class AwooFavProblem
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
        int n = Integer.parseInt(input.nextLine());

        char[] s = input.nextLine().toCharArray(), t = input.nextLine().toCharArray();

        for(int i = 0; i < s.length; i++)
        {
            // If there is a difference.
            if(s[i] != t[i])
            {
                if(s[i] == 'a' && t[i] == 'b' && checkAhead(s, i + 1, 'b', 'a'))
                {
                    continue;
                }
                else if(s[i] == 'b' && t[i] == 'c' && checkAhead(s, i + 1, 'c', 'b'))
                {
                    continue;
                }
                else
                {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }

    public static boolean checkAhead(char[] s, int fromIndex, char target, char through)
    {
        for(int i = fromIndex; i < s.length; i++)
        {
            if(s[i] == target)
            {
                // Swap the character that is yet to be scanned.
                s[i] = through;
                return true;
            }
            else if(s[i] != through)
                return false;
        }

        // In case all subsequent characters are equal to through.
        return false;
    }
}