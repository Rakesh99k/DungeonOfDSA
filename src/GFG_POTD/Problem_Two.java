package GFG_POTD;

/*

   Count the Number of Possible Triangles
        🔹 Question

        Given an array arr[], count how many triplets (i, j, k) can form sides of a valid triangle.
        A triangle is valid if for every triplet:

        a + b > c
        b + c > a
        c + a > b

        🔹 Approach

        Sort the array.

        Fix the largest side c.

        Use two pointers i (start) and j (end).

        If arr[i] + arr[j] > arr[k], then all elements between i and j can form a triangle → count them.

        Otherwise, move i++.

        ⏱ Time: O(n^2) | 💾 Space: O(1)

        🔹 Solution (Java)

*/

import java.util.Arrays;

class Solution_Two {
    public int countTriangles(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length, count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}

    public class Problem_Two {
        public static void main(String[] args) {
            Solution_Two sol = new Solution_Two();
            int[] arr = {4, 6, 3, 7};
            System.out.println(sol.countTriangles(arr)); // Output: 3

        }
    }

