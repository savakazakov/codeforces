
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1706/C
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class QpwoeirutCity
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
        int n = input.nextInt(), curFlrs = 0;
        int[] buildings = new int[n];

        // Has to be long since the numbers of floors accumulate from n integers.
        long flrsToAdd = 0;

        // Get the input.
        for(int i = 0; i < n; i++)
        {
            buildings[i] = input.nextInt();
        }

        // If the number of buildings is odd then there is only
        // one way to get the max number of cool buildings.
        // Which is to make all odd buildings cool.
        if(n % 2 == 1)
        {
            for(int i = 1; i < n - 1; i += 2)
            {
                curFlrs = Integer.max(buildings[i - 1], buildings[i + 1]) - buildings[i] + 1;
                flrsToAdd += curFlrs > 0 ? curFlrs : 0;
            }

            System.out.println(flrsToAdd);
        }
        else
        {
            // Have to be long since the numbers of floors accumulate from n integers.
            // odd/even represent the sum of floors needed
            // for the odd/even buildings to become cool.
            // odd is the current sum as the buildings are being traversed.
            // While even is the total sum and it is being subtracted from.
            long odd = 0, even = 0, minFlrs;

            for(int i = 2; i < n - 1; i += 2)
            {
                curFlrs = Integer.max(buildings[i - 1], buildings[i + 1]) - buildings[i] + 1;
                even += curFlrs > 0 ? curFlrs : 0;
            }

            minFlrs = even;

            for(int i = 1; i < n - 1; i += 2)
            {
                curFlrs = Integer.max(buildings[i - 1], buildings[i + 1]) - buildings[i] + 1;
                odd += curFlrs > 0 ? curFlrs : 0;

                curFlrs = Integer.max(buildings[i], buildings[i + 2]) - buildings[i + 1] + 1;
                even -= curFlrs > 0 ? curFlrs : 0;

                if(minFlrs > odd + even)
                    minFlrs = odd + even;
            }

            System.out.println(minFlrs);
        }
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