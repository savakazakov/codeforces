
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1705/C
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnfinishedEssay
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int tests = input.nextInt();

        while(tests > 0)
        {
            tests--;
            solve(input);
        }
    }

    public static void solve(Scanner input)
    {
        int n = input.nextInt(), c = input.nextInt(), q = input.nextInt();
        long copyStart = 0, copyEnd = 0, curEnd = n + 1, query = 0;
        List<Section> sections = new ArrayList<>();
        input.nextLine();

        String s = input.nextLine();

        for(int i = 0; i < c; i++)
        {
            copyStart = input.nextLong();
            copyEnd = input.nextLong();
            sections.add(new Section(curEnd, copyStart));
            curEnd += copyEnd - copyStart + 1;
        }

        for(int i = 0; i < q; i++)
        {
            query = input.nextLong();

            for(int j = c - 1; j >= 0; j--)
            {
                if(query < sections.get(j).start)
                    continue;
                else
                    query -= sections.get(j).offset;
            }

            System.out.println(s.charAt((int) query - 1));
        }
    }

    static class Section
    {
        private long start, offset;

        public Section(long start, long copyStart)
        {
            this.start = start;
            this.offset = start - copyStart;
        }
    }
}