class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        // First intiate minPrice big value beacause we decrease the value of minprice
        int maxProfit = 0;
        // Second we are intiate maxprofit is 0 because 
        for(int i =0;i<prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
        
    }
}