import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedTrees
{
    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n;
            List<Integer> tree = new ArrayList<>();
            String colours;

            System.out.println(",,,,,,,,,,,,");

            for(int i = 0; i < tests; i++)
            {
                // Number of vertices including the root.
                n = myObj.nextInt();

                tree.add(0);

                for(int j = 1; j < n; j++)
                {
                    tree.add(myObj.nextInt());
                }

                
                colours = myObj.next();
                
                System.out.println(tree);
                System.out.println(colours);

                
                tree.clear();
            }
        }
    }
}
