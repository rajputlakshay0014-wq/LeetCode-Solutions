class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) {
            return nums[0];
        }

        return Math.max(
            robHouse(nums, 0, n - 2),
            robHouse(nums, 1, n - 1)
        );
    }

    private int robHouse(int[] nums,
                         int start,
                         int end) {

        int prev1 = 0;
        int prev2 = 0;

        for(int i = start; i <= end; i++) {

            int curr =
                Math.max(prev1, prev2 + nums[i]);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}