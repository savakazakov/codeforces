
/**
 * This problem's task can be found at : https://codeforces.com/problemset/problem/1821/C
 */

#include <iostream>
using namespace std;

int main()
{
    int testCases;
    string str;

    cin >> testCases;

    for (int i = 0; i < testCases; i++)
    {
        cin >> str;
        int str_len = str.length();
        int ans = str_len;

        for (char c : "abcdefghijklmnopqrstuvwxyz")
        {
            int i = 0;
            int cur = 0;

            while (i < str_len)
            {
                int j = i;

                while (j < str_len and (str[j] == c) == (str[i] == c))
                    j += 1;

                if (str[i] != c)
                    cur = max(cur, j - i);

                i = j;
            }

            if (cur == 0)
            {
                ans = 0;
                break;
            }

            int pw = 0;

            while ((1 << pw) <= cur)
                pw += 1;

            ans = min(ans, pw);
        }

        cout << ans << "\n";
    }
}
