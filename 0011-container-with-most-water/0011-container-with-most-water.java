class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int max = 0;
        int area = 0;
        int low = 0;
        int high = n-1;
        while(low <= high){
            area = Math.max(Math.min(nums[low], nums[high]) * (high - low), area);
            if(nums[low] > nums[high]) high--;
            else low++;
        }
        return area;
    }
}