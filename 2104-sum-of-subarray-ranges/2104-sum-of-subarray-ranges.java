class Solution {

    public long subArrayRanges(int[] nums) {

        int n = nums.length;

        long ans = 0;

        Stack<Integer> stack = new Stack<>();

        // Maximum Contribution
        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                    (i == n || nums[stack.peek()] < (i == n ? Integer.MAX_VALUE : nums[i]))) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();

                ans += (long) nums[mid] * (mid - left) * (i - mid);
            }

            stack.push(i);
        }

        stack.clear();

        // Minimum Contribution
        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                    (i == n || nums[stack.peek()] > (i == n ? Integer.MIN_VALUE : nums[i]))) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();

                ans -= (long) nums[mid] * (mid - left) * (i - mid);
            }

            stack.push(i);
        }

        return ans;
    }
}