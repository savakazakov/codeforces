
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
            int tests = myObj.nextInt(), n;

            List<Integer> tree;
            List<Integer> leaves;
            List<List<Integer>> vertPaths;

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

                vertPaths = findVerticalPaths(tree, leaves);

                System.out.println(vertPaths.size()/*  + "num of branches" */);

                for(List<Integer> l : vertPaths)
                {
                    System.out.println(l.size()/*  + "size of branches" */);

                    for(int j = l.size() - 1; j >= 0; j--)
                    {
                        System.out.println(l.get(j));
                    }
                }
            }
        }
    }

    public static List<List<Integer>> findVerticalPaths(List<Integer> tree, List<Integer> leaves)
    {
        List<List<Integer>> vertPaths = new ArrayList<>();
        List<Integer> path;
        int node, temp;

        for(int i = 0; i < leaves.size(); i++)
        {
            path = new ArrayList<>();
            node = leaves.get(i);

            while(tree.get(node - 1) > 0)
            {
                path.add(node);

                // Follow the branch.
                temp = tree.get(node - 1);

                // Mark the visited node.
                tree.set(node - 1, 0);

                node = temp;
            }

            vertPaths.add(path);
        }

        return vertPaths;
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