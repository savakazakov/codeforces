import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BalancedTrees
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n, count = 0;

            List<Integer> tree = new ArrayList<>();
            Map<Integer, List<Integer>> subTrees = new HashMap<>();

            String colours;

            for(int i = 0; i < tests; i++)
            {
                // Get the input.
                // Number of vertices including the root.
                n = myObj.nextInt();
                count = 0;

                tree.add(0);

                for(int j = 1; j < n; j++)
                {
                    tree.add(myObj.nextInt());
                }

                colours = myObj.next();

                // Main algorithm.
                for(int j = tree.size(); j > 0; j--)
                {
                    // If the value at index (j - 1) is a root of a sub tree.
                    if(subTrees.containsKey(tree.get(j - 1)))
                    {
                        // Now if there is already a tree with root j.
                        if(subTrees.containsKey(j))
                        {
                            if(checkBalanced(subTrees.get(j), colours))
                            {
                                // System.out.println(subTrees.get(j));
                                count++;
                            }
                            // Merge the trees.
                            subTrees.get(tree.get(j - 1)).addAll(subTrees.get(j));
                            subTrees.remove(j);
                        }
                        else
                        {
                            // Add j to the sub tree.
                            subTrees.get(tree.get(j - 1)).add(j);
                        }
                    }
                    // If there is a sub tree with root j.
                    else if(subTrees.containsKey(j))
                    {
                        if(checkBalanced(subTrees.get(j), colours))
                        {
                            // System.out.println(subTrees.get(j));
                            count++;
                        }

                        subTrees.get(j).add(0, tree.get(j - 1));
                        subTrees.put(tree.get(j - 1), subTrees.get(j));
                        subTrees.remove(j);
                    }
                    else
                    {
                        // Create a new entry.
                        subTrees.put(tree.get(j - 1), new ArrayList<>(Arrays.asList(tree.get(j - 1), j)));
                    }
                }

                // Reset the ADTs.
                tree.clear();
                subTrees.clear();

                System.out.println(count);
            }
        }
    }

    /**
     * Checks if the specified tree is balanced,
     * i.e. number of black and white nodes are equal
     * 
     * @param subTree
     *            is the specified tree.
     * @param colours
     *            is a String which specifies the colours
     *            of the whole test case.
     * @return true is balance and false otherwise.
     */
    public static boolean checkBalanced(List<Integer> subTree, String colours)
    {
        int bal = 0;

        for(int n : subTree)
        {
            if(colours.charAt(n - 1) == 'B')
            {
                bal--;
            }
            else
                bal++;
        }

        return bal == 0;
    }
}
/* 
1
16
1 1 3 4 3 5 7 5 7 10 10 12 6 4 14
BBWBWBWBWWBWWWWB

1
7
1 1 2 3 3 5
WBBWWBW
*/