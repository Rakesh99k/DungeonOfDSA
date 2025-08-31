package GFG_POTD;
/*
 * 🔹 The Question
 *
 * We are asked:
 *     “Is string s1 a subsequence of string s2?”
 *
 * 👉 A subsequence means:
 *     - You can pick some characters from s2 (not necessarily consecutive),
 *     - But the order must remain the same as in s1.
 *     - If you can do that, then s1 is a subsequence of s2.
 *
 * 📝 Examples
 *
 *     s1 = "AXY", s2 = "YADXCP"
 *     - Try to match A → comes after Y (good)
 *     - Try to match X → not found after A in proper order ❌
 *     - So, not a subsequence.
 *
 *     s1 = "gksrek", s2 = "geeksforgeeks"
 *     - Pick g (from index 0)
 *     - Pick k (from index 3)
 *     - Pick s (from index 4)
 *     - Pick r (from index 5)
 *     - Pick e (from index 8)
 *     - Pick k (from index 12)
 *     - All appear in order ✅ → it is a subsequence.
 *
 * 🔹 The Approach
 *
 * The core concept used here is the Two Pointer Technique.
 * - One pointer i runs on s1 (the subsequence we want to check).
 * - Another pointer j runs on s2 (the big string we’re checking inside).
 * - As we move through s2, we check if the current character matches the one in s1.
 *     - If yes → move both pointers forward.
 *     - If no → move only j.
 * - At the end:
 *     - If i has reached the end of s1, it means we found all characters in order → true.
 *     - Otherwise, false.
 *
 * 🔹 Concept Behind It
 *
 * - Greedy Matching → Always match the next required character in order.
 * - Two Pointers → Efficiently scan both strings without backtracking.
 * - This is why it works in O(n) time instead of trying all subsequence combinations (which would be exponential).
 *
 * 🔹 Time Complexity
 *
 * - O(n) where n = length of s2. (In worst case, we scan the entire s2.)
 * - O(1) extra space.
 */

class Solution_One {
    public boolean isSubSeq(String s1, String s2) {
        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++; // found matching char, move s1 pointer
            }
            j++; // always move through s2
        }

        return i == s1.length(); // true if s1 fully matched
    }
}

public class Problem_One {
    public static void main(String[] args) {
        Solution_One solution = new Solution_One();

        String s1 = "gksrek";
        String s2 = "geeksforgeeks";
        boolean result1 = solution.isSubSeq(s1, s2);
        System.out.println("Is \"" + s1 + "\" a subsequence of \"" + s2 + "\"? " + result1);

        s1 = "AXY";
        s2 = "YADXCP";
        boolean result2 = solution.isSubSeq(s1, s2);
        System.out.println("Is \"" + s1 + "\" a subsequence of \"" + s2 + "\"? " + result2);
    }
}