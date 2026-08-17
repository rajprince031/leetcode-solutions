class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0,1);
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            int check = ((sum % k) + k) % k;
            if(map.containsKey(check)) count += map.get(check);
            map.put(check , map.getOrDefault(check,0)+1);
        }
        return count;
    }
}