package GFG_POTD;

/*
        # 🐭 Assign Mice to Holes

        ### 📌 Problem

        We’re given:

        * `mices[]`: positions of mice on a line
        * `holes[]`: positions of holes on the same line

        Each hole can hold exactly **one mouse**.
        A mouse moves **1 unit per minute** (left or right).

        We must assign each mouse to a distinct hole such that the **time taken by the last mouse (the slowest one)** is **minimized**.

        ➡️ Output: Minimum possible maximum time.

        ---

        ### 🧠 Approach (Greedy + Sorting)

        1. Sort both arrays (`mices[]` and `holes[]`).
        2. Match `mices[i]` with `holes[i]` for all `i`.

        * This avoids unnecessary large gaps.
        * Proof idea: If two mice cross over to swap holes, the total max distance never decreases (classic exchange argument).
        3. For each pair, calculate `|mices[i] - holes[i]|`.
        4. Answer = maximum among these distances.

        ---

        ### ⚡ Complexity

        * Sorting → `O(n log n)`
        * Single pass distance check → `O(n)`
        * Space → `O(1)`

        ---

        ### ✅ Example

        Input:

        ```
        mices = [4, -4, 2]
        holes = [4, 0, 5]
        ```

        Sorted:

        ```
        mices = [-4, 2, 4]
        holes = [0, 4, 5]
        ```

        Pairs & distances:

        * \|-4 - 0| = 4
        * |2 - 4| = 2
        * |4 - 5| = 1

        Max = **4** → Output ✅

*/
import java.util.*;

class Problem_Four {
    public int assignHole(int[] mices, int[] holes) {
        Arrays.sort(mices);
        Arrays.sort(holes);

        int maxTime = 0;
        for (int i = 0; i < mices.length; i++) {
            maxTime = Math.max(maxTime, Math.abs(mices[i] - holes[i]));
        }
        return maxTime;
    }

    public static void main(String[] args) {
        Problem_Four sol = new Problem_Four();

        int[] mices1 = {4, -4, 2};
        int[] holes1 = {4, 0, 5};
        System.out.println(sol.assignHole(mices1, holes1)); // Output: 4

        int[] mices2 = {1, 2};
        int[] holes2 = {20, 10};
        System.out.println(sol.assignHole(mices2, holes2)); // Output: 18
    }
}
