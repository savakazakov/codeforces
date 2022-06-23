import java.util.Scanner;
import java.util.Arrays;

public class ThreeSum
{
    public static final int[] complete = { -1, -1, -1 };

    public static void main(String[] args)
    {
        try(Scanner myObj = new Scanner(System.in))
        {
            int tests = myObj.nextInt(), n;
            int[][] combo;

            long[] arr;

            String ans;

            for(int i = 0; i < tests; i++)
            {
                combo = new int[][] { 
                                        {0, 0 ,3}, {0, 1, 2}, {0, 4, 9}, {0, 5, 8}, {0, 6, 7},
                                        {1, 1, 1}, {1, 3, 9}, {1, 4, 8}, {1, 5, 7}, {1, 6, 6},
                                        {2, 2, 9}, {2, 3, 8}, {2, 4, 7}, {2, 5, 6},
                                        {3, 3, 7}, {3, 4, 6}, {3, 5, 5},
                                        {4, 4, 5},
                                        {5, 9, 9},
                                        {6, 8, 9},
                                        {7, 7, 9}, {7, 8, 8}
                                    };

                // Get the input.
                n = myObj.nextInt();

                arr = new long[n];

                for(int j = 0; j < n; j++)
                {
                    arr[j] = myObj.nextLong();
                }

                // Reset the answer.
                ans = "No";

                for(int j = 0; j < n; j++)
                {
                    record((int) (arr[j] % 10), combo);
                    if(checkComplete(combo))
                    {
                        ans = "Yes";
                        break;
                    }
                }

                System.out.println(ans);
            }
        }
    }

    public static void record(int num, int[][] combo)
    {
        for(int i = 0; i < combo.length; i++)
        {
            for(int j = 0; j < combo[i].length; j++)
            {
                if(combo[i][j] == num)
                {
                    combo[i][j] = -1;
                    break;
                }
            }
        }
    }

    public static boolean checkComplete(int[][] combo)
    {
        for(int i = 0; i < combo.length; i++)
        {
            if(Arrays.equals(combo[i], complete))
                return true;
        }

        return false;
    }
}