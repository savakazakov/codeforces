
/**
 * This problem's task can be found at: https://codeforces.com/problemset/problem/1810/C
 */

#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int main()
{
    // t - number of test cases.
    // n - size of the array.
    // c - removing cost.
    // d - adding cost.
    int t = 0, n = 0, c = 0, d = 0;
    int temp = 0;
    int cost = 0, size = 0;

    cin >> t;

    for (int i = 0; i < t; i++)
    {
        cin >> n >> c >> d;
        cost = 0;

        std::vector<int> vec;

        for (int j = 0; j < n; j++)
        {
            cin >> temp;
            vec.push_back(temp);
        }

        // First remove duplicates, because they have to be removed anyway.
        sort(vec.begin(), vec.end());

        size = vec.size();
        // cout << size << " = size\n";

        vec.erase(unique(vec.begin(), vec.end()), vec.end());

        // cout << vec.size() << " = vec.size()\n";

        // Add the cost associated with removing duplicates.
        cost += (size - vec.size()) * c;

        // cout << "CoST begining: " << cost << "\n";

        // Check if it is a permutation already.
        if (vec.size() == vec.back())
        {
            cout << /* "\033[1;31m" << */ cost << /* "\033[0m\n"<<  */"\n";
            continue;
        }

        for (int j = vec.size() - 1; j >= 0; j--)
        {
            // cout << "d * (vec[j] - j) = " << d * (vec[j] - j) << "\n";
            if (vec[j] == j + 1)
            {
                // cout << "\033[1;31m" << cost << "\033[0m\n";
                // cout << "ONE\n";
                break;
            }
            else if (d * (vec[j] - j - 1) <= c)
            {
                // cout << "TWO\n";
                cost += d * (vec[j] - j - 1);
                break;
            }
            else
            {
                // cout << "THREE\n";
                cost += c;
            }
        }

        // cout << "CoST here: " << cost << "\n";

        // If all elements have been removed.
        if (cost == size * c)
        {
            if (c + d <= (vec[0] - 1) * d)
            {
                cost += d;
            }
            else
            {
                cost -= c;
                cost += (vec[0] - 1) * d;
            }

            // cout << "In all elemts have been removed.\n";
        }

        cout << /* "\033[1;31m" <<*/ cost /* << "\033[0m\n" */<< "\n";
    }

    return 0;
}

/* 
8
3 3 3
1 2 3
5 1 5
1 2 3 5 6
5 2 3
1 1 1 3 3
5 1 10
2 4 6 8 10
6 2 8
7 3 5 4 4 8
4 10 1
1 2 6 7
4 3 3
2 5 8 7
2 1000000000 1
1000000000 1
 */