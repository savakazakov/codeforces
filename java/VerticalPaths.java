import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * This problem's task can be found at : https://codeforces.com/problemset/problem/1675/D
 */

public class VerticalPaths
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n;

            List<List<Integer>> tree = /* Collections.synchronizedList( */new ArrayList<>()/* ) */;

            // AbstractMap.SimpleEntry<Integer, Integer> pair = new AbstractMap.SimpleEntry<>(pair);
            // Map<Long, Long> numbers = new TreeMap<>();

            for(int i = 0; i < tests; i++)
            {
                n = myObj.nextInt();

                // Get the input.
                for(int j = 0; j < n; j++)
                {
                    tree.add(/* Collections.synchronizedList( */new ArrayList<>(Arrays.asList(j + 1, myObj.nextInt())))/* ) */;
                }

                findVerticalPaths(tree);
                System.out.println(tree);
                System.out.println("check");
                tree.clear();
            }
        }
    }

    public static /* synchronized */ void findVerticalPaths(List<List<Integer>> tree)
    {
        int parent = -1;

        Iterator<List<Integer>> itr = tree.iterator();
        
        for(List<Integer> l : tree)
        {
            // Get the end of the path.
            parent = l.get(l.size() - 1);

            // Scan the remaining paths for that parent node.
            for(List<Integer> k : tree)
            {
                // Merge the paths.
                if(k.get(0) == parent && !k.equals(l))
                {
                    k.remove(0);
                    l.addAll(k);
                    tree.remove(k);

                    // Clear all the nodes which have the same parent.
                    for(List<Integer> t : tree)
                    {
                        if(t.get(t.size() - 1) == parent)
                        {
                            t.remove((Object) parent);
                        }
                    }

                    break;
                }
            }            
        }
    }
}

/* 
1
5
3 1 3 3 1
 */