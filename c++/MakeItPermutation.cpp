
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

        // std::cout << "vec = { ";
        // for (int n : vec)
        //     std::cout << n << ", ";
        // std::cout << "}; \n";

        // cout << "\n";

        // First remove duplicates, because they have to be removed anyway.
        sort(vec.begin(), vec.end());

        size = vec.size();

        vec.erase(unique(vec.begin(), vec.end()), vec.end());

        // Add the cost associated with removing duplicates.
        cost += (size - vec.size()) * c;
        cout << "Cost after sorting: " << cost;

        for (int j = vec.size() - 1; j >= 0; j--)
        {
            if (d * (vec[j] - j) <= c)
            {
                cout << (cost + d * (vec[j] - j));
                break;
            }
            else
            {
                cost += c;
            }
        }

        // std::cout << "vec = { ";
        // for (int j = vec.size() - 1; j >= 0; j --)
        //     std::cout << vec[j] << ", ";
        // std::cout << "}; \n";

        return 0;
    }
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