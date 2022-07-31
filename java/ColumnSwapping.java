
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1684/C
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

public class ColumnSwapping
{
    public static void main(String[] args) throws IOException
    {
        Reader input = new Reader();

        int tests = input.nextInt();

        while(tests > 0)
        {
            tests--;
            solve(input);
        }
    }

    public static void solve(Reader input) throws IOException
    {
        int n = input.nextInt(), m = input.nextInt(), fstIdx = -1, scdIdx = -1, fstBadRow = -1;
        int[][] matrix = new int[n][m];

        // List<Integer> badIdx = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                matrix[i][j] = input.nextInt();
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(checkRow(matrix[i]))
            {
                fstBadRow = i;
            }
        }

        for(int j = 1; j < m; j++)
        {
            // If not strictly increasing.
            if(matrix[fstBadRow][j] < matrix[fstBadRow][j - 1])
            {
                if(fstIdx == -1)
                    fstIdx = j;
                else if(scdIdx == -1)
                    scdIdx = j;
                else
                {
                    // If there are more than 2 bad indecies.
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));        
    }

    public static boolean checkRow(int[] row)
    {
        for(int i = 1; i < row.length; i++)
        {
            if(row[i] < row[i - 1])
            {
                return true;
            }
        }

        return false;
    }
    /*
     * 5
     * 2 3
     * 1 2 3
     * 1 1 1
     * 2 2
     * 4 1
     * 2 3
     * 2 2
     * 2 1
     * 1 1
     * 2 3
     * 6 2 1
     * 5 4 3
     * 2 1
     * 1
     * 2
     * 
     */

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while((c = read()) != -1)
            {
                if(c == '\n')
                {
                    if(cnt != 0)
                    {
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while(c <= ' ')
            {
                c = read();
            }
            boolean neg = (c == '-');
            if(neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }
            while((c = read()) >= '0' && c <= '9');

            if(neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while(c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if(neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }
            while((c = read()) >= '0' && c <= '9');
            if(neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while(c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if(neg)
                c = read();

            do
            {
                ret = ret * 10 + c - '0';
            }
            while((c = read()) >= '0' && c <= '9');

            if(c == '.')
            {
                while((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if(neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if(bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if(bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if(din == null)
                return;
            din.close();
        }
    }
}