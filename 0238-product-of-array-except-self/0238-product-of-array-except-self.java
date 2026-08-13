class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        int neg = 0;
        int product = 1;
        for(int i=0; i<n; i++){
            if(nums[i] == 0) zeroCount++;
            else product *= nums[i];
            if(nums[i] < 0) neg++;
        }
        int[] answer = new int[n];
        if(zeroCount > 1) return answer;
        boolean isNegative = neg > 0 ? true : false;
        for(int i=0; i<n; i++){
            if(nums[i] == 0) {
                Arrays.fill(answer, 0);
                answer[i] = product;
                return answer;
            }
            answer[i] = product / nums[i];
            
        }
        return answer;
    }
}