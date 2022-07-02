
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1676/G
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalancedTrees
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n, count = 0;

            int[] tree;
            Map<Integer, Integer> subTrees = new HashMap<>();

            String colours;
            int[] col;

            for(int i = 0; i < tests; i++)
            {
                // Get the input.
                // Number of vertices including the root.
                n = myObj.nextInt();

                tree = new int[n];
                count = 0;

                // Set to 1 so that line 62 doesn't go out of bounds.
                tree[0] = 1;

                for(int j = 1; j < n; j++)
                {
                    tree[j] = myObj.nextInt();
                }

                colours = myObj.next();
                col = transformColours(colours);

                // Main algorithm.
                for(int j = tree.length; j > 0; j--)
                {
                    // First count the complete sub trees.
                    if(subTrees.containsKey(j) && subTrees.get(j) == 0)
                        count++;

                    if(subTrees.containsKey(tree[j - 1]))
                    {
                        // If there is a branch to be merged.
                        if(subTrees.containsKey(j))
                            subTrees.replace(tree[j - 1], subTrees.get(tree[j - 1]) + subTrees.get(j));
                        else
                            subTrees.replace(tree[j - 1], subTrees.get(tree[j - 1]) + col[j - 1]);
                    }
                    else
                    {
                        // If there is a branch to be continued.
                        if(subTrees.containsKey(j))
                        {
                            subTrees.put(tree[j - 1], subTrees.get(j) + col[tree[j - 1] - 1]);
                            subTrees.remove(j);
                        }
                        else
                            subTrees.put(tree[j - 1], col[j - 1] + col[tree[j - 1] - 1]);
                    }
                }

                System.out.println(count);

                // Clear the ADT.
                subTrees.clear();
            }
        }
    }

    public static int[] transformColours(String colours)
    {
        int[] result = new int[colours.length()];
        for(int i = 0; i < colours.length(); i++)
        {
            if(colours.charAt(i) == 'W')
                result[i] = 1;
            else
                result[i] = -1;
        }

        return result;
    }
}