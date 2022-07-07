
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1675/D
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerticalPaths
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt();

            while(tests > 0)
            {
                tests--;
                solve(myObj);
            }
        }
    }

    public static void solve(Scanner myObj)
    {
        int n = myObj.nextInt();

        int[] tree = new int[n + 1];
        boolean[] inner = new boolean[n + 1];
        
        // Get the input.
        for(int i = 1; i < n + 1; i++)
        {
            tree[i] = myObj.nextInt();
            inner[tree[i]] = true;
        }
        
        if(n == 1)
        {
            System.out.println("1\n1\n1");
            return;
        }
        
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> lastPath;

        for(int i = 1; i <= n; i++)
        {
            if(inner[i])
                continue;
            visited[i] = true;
            lastPath = new ArrayList<>();
            lastPath.add(i);
            
            int v = i;
            while(!visited[tree[v]] && tree[v] != v)
            {
                v = tree[v];
                visited[v] = true;
                lastPath.add(v);
            }

            paths.add(lastPath);
        }
        
        System.out.println(paths.size());
        for(List<Integer> path : paths)
        {
            System.out.println(path.size());
            for(int i = path.size() - 1; i >= 0; i--)
                System.out.println(path.get(i));
        }
    }
}