import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BalancedTrees
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n, count = 0;
            List<Integer> tree = new ArrayList<>(), subTree = new ArrayList<>();
            String colours;

            // System.out.println(",,,,,,,,,,,,");

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
                for(int j = 1; j < tree.size(); j++)
                {
                    fillTree(tree, subTree, j);
                    if(checkBalanced(subTree, colours))
                        count++;
                    subTree.clear();
                }

                // Reset the ADT.
                tree.clear();

                System.out.println(count);
            }
        }
    }

    public static void fillTree(List<Integer> tree, List<Integer> subTree, int root)
    {
        subTree.add(root);

        int index = tree.indexOf(root);

        while(index > -1 && index < tree.size())
        {
            if(tree.get(index) == root)
                fillTree(tree, subTree, index + 1);
            index++;
        }
    }

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
12
1 2 2 2 5 6 7 8 5 4 9
WBBWBWWBBBBW
 */