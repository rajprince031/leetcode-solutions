class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int low = 0;
        int high = 0;
        int bi = 0;
        int move = 0;
        int total = 0;
        while(high < n){
            map.put(nums[high], map.getOrDefault(nums[high], 0)+1);
            while(map.size() > k){
                if(map.containsKey(nums[low])){
                    map.put(nums[low], map.get(nums[low])-1);
                    if(map.get(nums[low]) == 0) map.remove(nums[low]);
                }
                low++;
                bi = low;
            }
            while(map.get(nums[low]) > 1)
                map.put(nums[low], map.get(nums[low++])-1);
            
            if(map.size() == k) total = total + (low - bi + 1);

            high ++;
        }
        return total;
    }
}