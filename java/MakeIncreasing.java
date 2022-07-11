
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1667/A
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MakeIncreasing
{
    public static void main(String[] args) throws IOException
    {
        Reader input = new Reader();

        int tests = 1;

        while(tests > 0)
        {
            tests--;
            solve(input);
        }
    }

    // public static int incCeil(double d)
    // {
    // if(d % 1 == 0f)
    // return (int) ++d;
    // else
    // return (int) Math.ceil(d);
    // }

    // public static int incFloor(double d)
    // {
    // if(d % 1 == 0f)
    // return (int) --d;
    // else
    // return (int) Math.floor(d);
    // }

    public static void solve(Reader input) throws IOException
    {
        int n = input.nextInt();
        int[] increments = new int[n];
        int first;
        int prev = 0;
        int numOfMoves = Integer.MAX_VALUE;
        int bestNumOfMoves = Integer.MAX_VALUE;
        int counter = 0;

        // Get the input.
        for(int i = 0; i < n; i++)
        {
            increments[i] = input.nextInt();
        }

        // FIXME
        /* This is not strictly increasing
         * have to add an extra condition to check for equal increase.
         */

        while(counter < n)
        {
            numOfMoves = counter;
            first = -1 * counter * increments[0];
            counter++;
            System.out.println(first + " increment of first");
            prev = first;
            
            // Get the number of moves required to make it
            // increasing for the specified first entry.
            for(int i = 1; i < n; i++)
            {
                if(prev < 0)
                {
                    System.out.println(Math.abs(prev / increments[i]) + " (in prev<0) this is for i = " + i);
                    numOfMoves += Math.abs(prev / increments[i]);
                    prev = (prev / increments[i] + 1) * increments[i];
                }
                else
                {
                    // Try without math.abs.
                    System.out.println(Math.abs(prev / increments[i] + 1) + " this is for i = " + i);
                    numOfMoves += Math.abs(prev / increments[i] + 1);
                    prev = (prev / increments[i] + 1) * increments[i];
                }
            }

            if(numOfMoves < bestNumOfMoves)
                bestNumOfMoves = numOfMoves;

            // System.out.println(bestNumOfMoves + " BestNumOfMoves");
            System.out.println(numOfMoves + " numOfMoves");
            System.out.println();
        }

        System.out.println(bestNumOfMoves + " bestNumOfMoves");
    }

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