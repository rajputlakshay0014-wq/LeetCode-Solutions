class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums,0,n-1);
        // yeah full complete array ko rotate krega 
        reverse(nums,0,k-1);
        // yeah last k position elements ko rotate krega 
        reverse(nums,k,n-1);
        // here we are rotate remaining elements 




        
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}