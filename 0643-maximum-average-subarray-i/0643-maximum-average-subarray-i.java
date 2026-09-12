class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        int sum = 0;
        double max = 0;
        while(high != n){
            if(high < k){
                sum += nums[high++];
                max = sum;
            }else{
                sum = sum + nums[high++] - nums[low++];
                max = Math.max(sum, max);
            }
        }
        return (double) max/k;
    }
}