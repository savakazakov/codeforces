
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1675/D
 */

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collections;
// import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
// import java.util.concurrent.CopyOnWriteArrayList;

public class VerticalPaths
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n, temp;

            List<List<Integer>> tree = new ArrayList<>();

            for(int i = 0; i < tests; i++)
            {
                n = myObj.nextInt();

                // Get the input.
                for(int j = 0; j < n; j++)
                {
                    temp = myObj.nextInt();

                    // if(temp == j + 1)
                    // {
                    // tree.add(new CopyOnWriteArrayList<>(Arrays.asList(temp)));
                    // // System.out.println("check");
                    // continue;
                    // }

                    tree.add(new ArrayList<>(Arrays.asList(j + 1, temp)));
                }

                System.out.println(
                    findVerticalPaths(tree)
                );

                // Output the result.
                // System.out.println(tree.size());

                // for(List<Integer> l : tree)
                // {
                //     System.out.println(l.size() + " size of branch");

                //     for(int j = l.size() - 1; j >= 0; j--)
                //     {
                //         System.out.println(l.get(j));
                //     }
                // }

                tree.clear();
            }
        }
    }

    public static List<List<Integer>> findVerticalPaths(List<List<Integer>> tree)
    {
        List<List<Integer>> result = new ArrayList<>();
        boolean added = false, contains = false;

        for(List<Integer> l : tree)
        {
            for(List<Integer> k : result)
            {
                if(k.get(0) == l.get(l.size() - 1))
                {
                    if(l.get(0) != l.get(1))
                        k.add(0, l.get(0));
                    added = true;
                    // break;
                }
                else if(k.get(k.size() - 1) == l.get(0))
                {
                    if(l.get(0) != l.get(1))
                        k.add(l.get(l.size() - 1));
                    added = true;
                    // break;
                }

                if(k.contains(l.get(l.size() - 1)))
                {
                    contains = true;
                    // System.out.println("checl" + contains);
                }
            }

            if(!added)
            {
                if(l.get(0) == l.get(1))
                    result.add(new ArrayList<>(Arrays.asList(l.get(0))));
                else
                {
                    // System.out.println(contains + "this is cont");
                    if(contains)
                    {
                        result.add(new ArrayList<>(Arrays.asList(l.get(0))));
                        // System.out.println("askjdfh");
                    }
                    else
                    {
                        result.add(new ArrayList<>(l));
                        // System.out.println("CHECK");
                    }
                }
            }

            added = false;
            contains = false;
        }

        return result;
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


 * if(l.size() == 0)
 * break;
 * 
 * // Get the end of the path.
 * parent = l.get(l.size() - 1);
 * 
 * // Scan the remaining paths for that parent node.
 * for(List<Integer> k : tree)
 * {
 * // Merge the paths.
 * if(k.get(0) == parent && !k.equals(l))
 * {
 * k.remove(0);
 * l.addAll(k);
 * tree.remove(k);
 * 
 * // Clear all the nodes which have the same parent.
 * for(List<Integer> t : tree)
 * {
 * if(t.get(t.size() - 1) == parent && !t.equals(l))
 * {
 * t.remove((Object) parent);
 * if(t.isEmpty())
 * tree.remove(t);
 * }
 * }
 * 
 * break;
 * }
 * }
 */