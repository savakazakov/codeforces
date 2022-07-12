
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

    public static void solve(Reader input) throws IOException
    {
        int n = input.nextInt();
        int[] incs = new int[n];
        int prev = 0, counter = 0, moves, numOfMoves = Integer.MAX_VALUE, bestNumOfMoves = Integer.MAX_VALUE;

        // Get the input.
        for(int i = 0; i < n; i++)
        {
            incs[i] = input.nextInt();
        }

        while(counter < n)
        {
            numOfMoves = counter;

            prev = counter * -1;

            // Get the number of moves required to make it
            // increasing for the specified first entry.
            for(int i = 1; i < n; i++)
            {
                moves = prev > 0 ? prev * incs[i - 1] / incs[i] + 1
                        : prev * incs[i - 1] / incs[i];

                if(prev * incs[i - 1] == moves * incs[i])
                {
                    moves++;
                }

                prev = moves;

                // Could be optimised - if it becomes higher than bestNumOfMoves.
                numOfMoves += Math.abs(moves);
            }

            if(numOfMoves <= bestNumOfMoves)
            {
                bestNumOfMoves = numOfMoves;
            }

            counter++;
        }

        System.out.println(bestNumOfMoves);

        System.out.println(-75/75);
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