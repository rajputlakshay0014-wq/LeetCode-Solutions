class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int orginal =  n * (n+1)/2;
        int expected = 0;
        for(int i =0;i<n;i++){
            expected+= nums[i];
        }
        return orginal - expected;
    }
}