public class MoscowPavingProblem
{
    private static final int n = 3;
    private static boolean[][] solution = new boolean[n][n];
    // private static int[][] trackSquaresMatrix = new int[n][n];

    public static void main(String[] args)
    {
        // Testing chkCand.
        solution = new boolean[][]{ {true, true, true},
                                    {true, false, true},
                                    {true, true, false} };

        // printSolution(solution);

        boolean[][][] cands = genCands(2);
        printCands(cands, 2);
    }

    public static boolean checkPossible(int x, int y)
    {
        // Down and to the right.
        for(int i = 1; i < n; i++)
        {
            if(x + i >= n || y + i >= n)
                break;

            if(solution[x + i][y] && solution[x][y + i] && solution[x + i][y + i])
            {
                return false;
            }
        }

        // Down and to the left.
        for(int i = 1; i < n; i++)
        {
            if(x - i < 0 || y + i >= n)
                break;

            if(solution[x - i][y] && solution[x][y + i] && solution[x - i][y + i])
            {
                return false;
            }
        }

        // Up and to the left.
        for(int i = 1; i < n; i++)
        {
            if(x - i < 0 || y - i < 0)
                break;

            if(solution[x - i][y] && solution[x][y - i] && solution[x - i][y - i])
            {
                return false;
            }
        }

        // Up and to the right.
        for(int i = 1; i < n; i++)
        {
            if(x + i >= n || y - i < 0)
                break;

            if(solution[x + i][y] && solution[x][y - i] && solution[x + i][y - i])
            {
                return false;
            }
        }

        // // This should never be reached.
        // System.out.println("This should never be reached.");
        return true;
    }

    /**
     * Checks a candidate solution.
     * TODO - finish this comment.
     * @param cand
     * @param size
     * @param x
     * @param y
     * @return
     */
    public static boolean chkCand(boolean[][] cand, int size, int x, int y)
    {
        if (size == 1)
            return true;
        
        for (int i = 1; i < size; i++)
        {
            if (cand[x][y] && cand[x + i][y] && cand[x][y + i] && cand[x + i][y + i])
                return false;
            if (!(chkCand(cand, size - i, x + i, y) && chkCand(cand, size - i, x, y + i) && chkCand(cand, size - i, x + i, y + i)))
                return false;
        }

        return true;
    }

    public static boolean[][][] genCands(int size)
    {
        boolean[][][] cands = new boolean[(int) Math.pow(2, size * size)][size][size];
        int position = 0;

        for (int i = 0; i < Math.pow(2, size * size); i++)
        {
            cands[i] = new boolean[size][size];
            position = 0;

            for (int j = 0; j < size; j++)
            {
                for (int k = 0; k < size; k++)
                {
                    cands[i][j][k] = (i >> position & 1) == 1 ? true : false;
                    position++;
                }
            }
        }

        return cands;
    }

    public static void printSolution(boolean[][] solution, int size)
    {
        String line = "+" + "-+".repeat(size);
        String middleLine = "";

        for(int i = 0; i < size; i++)
        {
            System.out.println(line);
            
            for(int j = 0; j < size; j++)
            {
                middleLine += "|" + (solution[i][j] ? "O" : "X"); 
            }

            System.out.println(middleLine + "|");
            middleLine = "";
        }

        System.out.println(line);
    }

    public static void printCands(boolean[][][] cands, int size)
    {
        System.out.println("Length of Candidates: " + cands.length);
        for(int i = 0; i < cands.length; i++)
        {
            printSolution(cands[i], size);
            System.out.println("\n");
        }
    }

    // public static void printSolution(boolean[][] solution)
    // {
    //     String line = "+" + "---+".repeat(n);
    //     String intermediateLine = "|   ".repeat(n) + "|";
    //     String middleLine = "";

    //     for(int i = 0; i < n; i++)
    //     {
    //         System.out.println(line + "\n" + intermediateLine);
            
    //         for(int j = 0; j < n; j++)
    //         {
    //             middleLine += "| " + (solution[i][j] ? "O " : "X "); 
    //         }

    //         System.out.println(middleLine + "|\n" + intermediateLine);
    //         middleLine = "";
    //     }

    //     System.out.println(line);
    // }
}