
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1660/C
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EvenString
{
    public static void main(String[] args) throws IOException
    {
        // Reader input = new Reader();
        Scanner input = new Scanner(System.in);

        int tests = Integer.parseInt(input.nextLine());

        while(tests > 0)
        {
            tests--;
            solve(input);
        }
    }

    public static void solve(Scanner/* Reader */ input) throws IOException
    {
        char[] str = input/* .readLine() */.nextLine().toCharArray();

        int oddIdx = 0, evenIdx = 1, dels = 0, idx = 0;

        while(evenIdx < str.length)
        {
            // There is a faulting pair.
            if(str[oddIdx] != str[evenIdx])
            {
                // System.out.println("3 tests");

                // A character must be removed.
                dels++;
                idx = evenIdx + 1;
                // System.out.println("idx " + idx);

                while(true)
                {
                    if(idx == str.length)
                    {
                        dels++;
                        evenIdx += 2;
                        oddIdx = evenIdx - 1;
                        break;
                    }

                    if(str[idx] == str[oddIdx])
                    {
                        // System.out.println("oddIdx first " + oddIdx);
                        evenIdx++;
                        break;
                    }
                    else if(str[idx] == str[evenIdx])
                    {
                        // System.out.println("evenIdx first " + evenIdx);
                        oddIdx = evenIdx;
                        evenIdx++;
                        break;
                    }

                    idx++;
                }

            }
            else
            {
                // System.out.println("4 tests");

                evenIdx += 2;
                oddIdx = evenIdx - 1;
            }
        }

        // If there is a single character at the end.
        if(evenIdx == str.length)
        {
            dels++;
        }

        System.out.println(dels /* + " dels" */);
        

        // if(str.size() % 2 != 0)
        // {
        //     str.remove(str.size() - 1);
        // }

        // System.out.println(initialSize - str.size());
    }

/* 
1
bmefbmuyw

 */

    /**
     * Returns the index of the character that needs to be removed.
     * 
     * @param s - the String being processed.
     * @param startIdx - the index of the first character in the faulting pair.
     * @return - the index of the charter.
     */
    public static int idxToRem(List<Character> s, int startIdx)
    {
        int idx = startIdx + 2;

        while(idx < s.size())
        {
            if(s.get(idx).equals(s.get(startIdx)))
                return startIdx + 1;
            else if(s.get(idx).equals(s.get(startIdx + 1)))
                return startIdx;

            idx++;
        }

        return startIdx;
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