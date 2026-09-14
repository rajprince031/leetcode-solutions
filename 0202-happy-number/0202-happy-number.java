class Solution {
    public int getNext(int n){
        int sum = 0;
        while(n > 0){
            int r = n % 10;
            n = n / 10;
            r = r*r;
            sum = sum + r;
        }
        return sum;
    }
    public boolean isHappy(int n) {
       HashSet<Integer> set = new HashSet<>();
       while(n != 1){
            if(set.contains(n)) return false;
            set.add(n);
            n = getNext(n);
       }

       return true;
    }
}