class Solution {
    // public int solve(int[] nums, int idx, boolean canBuy, int total){
    //     if(idx == nums.length) return total;
    //     if(canBuy){ 
    //         solve(nums, idx+1, !canBuy, total);
    //         solve(nums, idx+1, !canBuy, total);
    //     }
    // }
    public int maxProfit(int[] prices) {
      int n = prices.length;
      int profit = 0;
      for(int i=1; i<n; i++){
        if(prices[i-1] < prices[i]) profit += prices[i] - prices[i-1];
      }
      return profit;
    }
}