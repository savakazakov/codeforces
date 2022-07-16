
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1660/C
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenString
{
    public static void main(String[] args) throws IOException
    {
        // Reader input = new Reader();
        Scanner input = new Scanner(System.in);

        int tests = Integer.parseInt(input/* .readLine() */.nextLine());

        while(tests > 0)
        {
            tests--;
            solve(input);
        }
    }

    public static void solve(/* Reader */Scanner input) throws IOException
    {
        // Could be optimised.
        List<Character> str = new ArrayList<>();
        for(char c : input/* .readLine() */.nextLine().toCharArray())
            str.add(c);

        // System.out.println(str);

        int initialSize = str.size();

        for(int i = 0; i < str.size(); i += 2)
        {
            // Index out of bounds.
            if(i + 1 < str.size() && !str.get(i).equals(str.get(i + 1)))
            {
                // System.out.println(i + " with char " + str.get(i));
                // System.out.println(i + 1 + " with char " + str.get(i + 1));
                // System.out.println(str.remove(idxToRem(str, i)) + " removed");
                str.remove(idxToRem(str, i));
                i -= 2;
            }
        }

        if(str.size() % 2 != 0)
        {
            str.remove(str.size() - 1);
        }

        System.out.println(initialSize - str.size());
    }

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