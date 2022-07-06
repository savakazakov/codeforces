
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
            int tests = myObj.nextInt(), n, node, temp;

            List<Integer> tree;
            List<Integer> leaves;
            List<Integer> path;

            for(int i = 0; i < tests; i++)
            {
                n = myObj.nextInt();
                tree = new ArrayList<>();
                leaves = new ArrayList<>();

                // Get the input.
                for(int j = 0; j < n; j++)
                {
                    tree.add(myObj.nextInt());
                }

                for(int j = n; j > 0; j--)
                {
                    // Ensure it is a leaf node.
                    if(!tree.contains(j) || tree.size() == 1)
                    {
                        leaves.add(j);
                    }
                }

                System.out.println(leaves.size()/*  + "num of branches" */);

                for(int j = 0; j < leaves.size(); j++)
                {
                    path = new ArrayList<>();
                    node = leaves.get(j);

                    while(tree.get(node - 1) > 0)
                    {
                        path.add(node);

                        // Follow the branch.
                        temp = tree.get(node - 1);

                        // Mark the visited node.
                        tree.set(node - 1, 0);

                        node = temp;
                    }

                    // Print the path size.
                    System.out.println(path.size());

                    // Print the path.
                    for(int k = path.size() - 1; k >= 0; k--)
                    {
                        System.out.println(path.get(k));
                    }
                }
            }
        }
    }
}

/*
 
1
5
3 1 3 3 1

1
4
1 1 4 1

1
7
1 1 2 3 4 5 6

1
1
1

1
6
4 4 4 4 1 2

1
4
2 2 2 2

 */