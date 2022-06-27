
/**
 * This problem's task can be found at : https://codeforces.com/problemset/problem/1676/F
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class LongestStrike
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n, k, len, curLen;
            long end, temp;

            // boolean equalsFail, result;

            Map<Long, Long> numbers = new TreeMap<>();
            Set<Long> keySet;

            for(int i = 0; i < tests; i++)
            {
                n = myObj.nextInt();
                k = myObj.nextInt();

                // Get the input.
                for(int j = 0; j < n; j++)
                {
                    temp = myObj.nextInt();

                    numbers.put(temp, numbers.getOrDefault(temp, (long) 0) + 1);
                }

                end = 0;
                len = 0;
                curLen = 0;
                // keySet = numbers.keySet();

                // System.out.println(numbers);

                for(long j : numbers.keySet())
                {
                    if(numbers.get(j) < k)
                    {
                        curLen = 0;
                    }
                    
                    else
                    {
                        if(numbers.getOrDefault(j - 1, (long) -1) < k)
                            curLen = 0;
                        
                        curLen++;

                        if(curLen > len)
                        {
                            end = j;
                            len = curLen;
                        }
                    }
                }

                if(len == 0)
                    System.out.println(-1);
                else
                {
                    System.out.println(end - len + 1/*  + " - This is the start" */);
                    System.out.println(end/*  + " - This is the end" */);
                }

                numbers.clear();
            }
        }
    }
}

/* 
1
7 2
11 11 12 13 13 14 14

1
6 4
4 3 4 3 3 4

1
2 1
6 7
 */
