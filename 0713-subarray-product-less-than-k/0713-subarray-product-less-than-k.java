class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int n = nums.length;
        int low = 0;
        int high = 0;
        int total = 0;
        long product = 1;
        int count = 1;
        while(high < n){
           product = product * nums[high++];
                while(product >= k){
                    product = product / nums[low++];
                    count--;
                }
            total = total + count++;
        }
        return total;
    }
}