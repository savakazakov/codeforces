
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1696/C
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaysArray
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
        /* 
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums.get(i) > target.get(i))
            {
                if(!divide(nums, m, i))
                {
                    System.out.println("No");
                    return;
                }
                i--;
            }
            else if(target.get(i) > nums.get(i))
            {
                if(!divide(target, m, i))
                {
                    System.out.println("No");
                    return;
                }
                i--;
            }
        }
 
        System.out.println("Yes");
         */

        int n = input.nextInt(), m = input.nextInt(), k, num;
        List<Integer> arr = new ArrayList<>(), target = new ArrayList<>(), toDivide;

        // Get the input.
        for(int i = 0; i < n; i++)
            arr.add(input.nextInt());

        k = input.nextInt();

        for(int i = 0; i < k; i++)
            target.add(input.nextInt());

        for(int i = 0; i < arr.size() && i < target.size(); i++)
        {
            if(arr.get(i) != target.get(i))
            {
                toDivide = arr.get(i) > target.get(i) ? arr : target;

                if(toDivide.get(i) % m == 0)
                {
                    num = toDivide.remove(i) / m;

                    for(int j = 0; j < m; j++)
                        toDivide.add(i, num);
                }
                else
                {
                    System.out.println("No");
                    return;
                }

                i--;
            }
        }

        if(arr.size() == target.size())
            System.out.println("Yes");
        else
            System.out.println("No");
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