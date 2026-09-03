class Solution {
    public boolean uniformArray(int[] nums) {
        int min = nums[0];
        boolean mix = false;
        for(int n : nums){
            min = Math.min(n, min);
            if((n & 1) == 1) mix = true;
        }
        if((min & 1) == 1) return true;
        return !mix;
    }
}