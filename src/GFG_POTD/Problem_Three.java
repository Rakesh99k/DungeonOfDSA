package GFG_POTD;

/*

Maximize Number of 1’s
🔹 Question

Given a binary array arr[] and an integer k, you can flip at most k zeros to ones. Find the maximum number of consecutive 1’s possible.

        🔹 Approach

Use sliding window technique.

Keep expanding the window.

Count zeros inside window.

If zeros > k, shrink window from left until valid again.

Track max window size.

        ⏱ Time: O(n) | 💾 Space: O(1)

🔹 Solution (Java)

 */
class Solution_Three {
    public int maxOnes(int arr[], int k) {
        int left = 0, zeroCount = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) zeroCount++;

            while (zeroCount > k) {
                if (arr[left] == 0) zeroCount--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

    public class Problem_Three {
        public static void main(String[] args) {
            Solution_Three sol = new Solution_Three();
            int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
            int k = 2;
            System.out.println(sol.maxOnes(arr, k)); // Output: 7
        }
    }
