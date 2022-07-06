
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1675/D
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class VerticalPaths
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n, node;

            List<Integer> tree;
            Set<Integer> leaves;
            Set<Integer> visited;
            List<Integer> path;

            for(int i = 0; i < tests; i++)
            {
                n = myObj.nextInt();
                tree = new ArrayList<>();
                leaves = new HashSet<>();
                visited = new HashSet<>();

                // Get the input.
                for(int j = 0; j < n; j++)
                {
                    tree.add(myObj.nextInt());
                }

                // Create the leaves set.
                for(int j = 1; j <= n; j++)
                {
                    leaves.add(j);
                }

                if(n != 1)
                    leaves.removeAll(tree);

                System.out.println(leaves.size()/*  + "num of branches" */);

                Iterator<Integer> itr = leaves.iterator();

                while(itr.hasNext())
                {
                    path = new ArrayList<>();
                    node = itr.next();

                    while(!visited.contains(node))
                    {
                        path.add(node);
                        visited.add(node);

                        // Follow the branch.
                        node = tree.get(node - 1);
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