
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1692/G
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Sort
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
        int n = input.nextInt(), k = input.nextInt(), streak = 1, result = 0;
        int[] nums = new int[n];

        // Get the input.
        for(int i = 0; i < n; i++)
            nums[i] = input.nextInt();

        for(int i = 1; i < n; i++)
        {
            if(nums[i - 1] < 2 * nums[i])
                streak++;
            else
            {
                // Calculate the streak once it is terminated.
                result += streak - k > 0 ? streak - k : 0;
                streak = 1;
            }
        }

        // Because the loop exits without calculating the last streak;
        result += streak - k > 0 ? streak - k : 0;

        System.out.println(result);
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