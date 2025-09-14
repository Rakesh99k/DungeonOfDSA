package GFG_POTD;
/*This is the famous Gas Station (Leetcode 134) problem 🚗⛽. Let’s break it down.

        🔹 Problem Restatement

We have:

gas[i]: amount of fuel available at station i.

        cost[i]: fuel needed to travel from station i → i+1.

We want to find an index start where if we begin with 0 fuel, we can complete one full circle.

        👉 If no such index exists, return -1.

        🔹 Key Observations

Feasibility check:

If the total gas available < total cost needed, it's impossible → return -1.

        if (sum(gas) < sum(cost)) return -1;


Greedy logic:

Traverse stations one by one, maintaining tank = fuel balance.

If tank becomes negative at station i:

It means we cannot start from any station between last start and i.

So reset start = i+1, and reset tank = 0.

Continue till the end.

Since total gas ≥ total cost (checked earlier), the final start will always work.

        🔹 Approach

Compute total gas vs total cost → if impossible, return -1.

Traverse all stations:

Keep track of tank += gas[i] - cost[i].

If tank < 0, reset tank = 0 and set start = i+1.

Return start.

        🔹 Example

Input:
gas = [4, 5, 7, 4]
cost = [6, 6, 3, 5]

Step by step:

totalGas = 20, totalCost = 20 → feasible ✅

Traverse:

i=0 → tank = -2 → reset start=1

i=1 → tank = -1 → reset start=2

i=2 → tank = 4

i=3 → tank = 3
        ✅ return 2.
*/

class Solution {
    public int startStation(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int tank = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If tank goes negative, reset start
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }

        return (totalGas < totalCost) ? -1 : start;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.startStation(new int[]{4, 5, 7, 4}, new int[]{6, 6, 3, 5})); // 2
        System.out.println(sol.startStation(new int[]{3, 9}, new int[]{7, 6})); // -1
    }
}

/*🔹 Complexity

Time: O(n) (one pass).

Space: O(1).

 */

/*
class Solution {
    public int startStation(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // Step 1: Quick rejection
        if (totalGas < totalCost) {
            return -1;
        }

        // Step 2: Greedy scan
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                // can't reach station i+1 from current start
                start = i + 1;
                tank = 0;
            }
        }

        return start; // guaranteed to be valid
    }

    // Simple driver code
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] gas1 = {4, 5, 7, 4};
        int[] cost1 = {6, 6, 3, 5};
        System.out.println(sol.startStation(gas1, cost1)); // 2

        int[] gas2 = {3, 9};
        int[] cost2 = {7, 6};
        System.out.println(sol.startStation(gas2, cost2)); // -1

        int[] gas3 = {1, 2, 3, 4, 5};
        int[] cost3 = {3, 4, 5, 1, 2};
        System.out.println(sol.startStation(gas3, cost3)); // 3
    }
}
*/