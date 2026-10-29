class Solution {
    public int singleNumber(int[] nums) {
        // here we are use the Xor method,
        int result = 0;
        for(int i =0;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;

        
    }
}