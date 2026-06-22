  import java.util.*;

class Solution {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int num = nums[i % n];

            while (!stack.isEmpty() &&
                    nums[stack.peek()] < num) {

                ans[stack.pop()] = num;
            }

            if (i < n)
                stack.push(i);
        }

        return ans;
    }
}