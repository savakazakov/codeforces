// import java.util.ArrayList;
import java.time.temporal.Temporal;
import java.util.Arrays;
// import java.util.Collections;
// import java.util.Iterator;
// import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This problem's task can be found at : https://codeforces.com/problemset/problem/1675/D
 */

public class VerticalPaths
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n, temp;

            CopyOnWriteArrayList<CopyOnWriteArrayList<Integer>> tree = new CopyOnWriteArrayList<>();

            for(int i = 0; i < tests; i++)
            {
                n = myObj.nextInt();

                // Get the input.
                for(int j = 0; j < n; j++)
                {
                    temp = myObj.nextInt();

                    /* if(temp != j + 1) */
                        tree.add(new CopyOnWriteArrayList<>(Arrays.asList(j + 1, temp)));
                }

                findVerticalPaths(tree);

                // Output the result.
                System.out.println(tree.size());

                for(CopyOnWriteArrayList<Integer> l : tree)
                {
                    System.out.println(l.size() + " size of branch");
                    
                    for(int j = l.size() - 1; j >= 0; j--)
                    {
                        System.out.println(l.get(j));
                    }
                }

                tree.clear();
            }
        }
    }

    public static /* synchronized */ void findVerticalPaths(CopyOnWriteArrayList<CopyOnWriteArrayList<Integer>> tree)
    {
        int parent = -1;
        // ArrayList<Integer> l;

        // Iterator<List<Integer>> treeItr = tree.iterator();
        
        // while(treeItr.hasNext())
        // {
        //     l = (ArrayList<Integer>) treeItr.next();
        //     parent = l.get(l.size() -1);

        //     treeItr

        //     // treeItr.forEachRemaining(action);
        // }

        for(CopyOnWriteArrayList<Integer> l : tree)
        {
            if(l.size() == 0)
                break;

            // Get the end of the path.
            parent = l.get(l.size() - 1);

            // Scan the remaining paths for that parent node.
            for(CopyOnWriteArrayList<Integer> k : tree)
            {
                // Merge the paths.
                if(k.get(0) == parent && !k.equals(l))
                {
                    k.remove(0);
                    // l.addAll(k);
                    tree.remove(k);
                    if(l.addAll(k))
                    {
                        // Clear all the nodes which have the same parent.
                        for(CopyOnWriteArrayList<Integer> t : tree)
                        {
                            if(t.get(t.size() - 1) == parent/*  && !t.equals(l) */)
                            {
                                t.remove((Object) parent);
                            }
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