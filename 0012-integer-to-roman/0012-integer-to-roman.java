class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        int[] arr = new int[]{1,5,10,50,100,500,1000};
        int n = arr.length - 1;
        String s = "";
        while(num != 0 && n != -1){
            int d = num / arr[n];
            int r = num % arr[n];

            if(map.containsKey(arr[n]*d)) s = s + map.get(arr[n]*d);
            else s = s + map.get(arr[n]).repeat(d);
            if(map.containsKey(r)) {
                s = s + map.get(r);
                break;
            }
            num = r;
            n--;
        }
        s = s.replace("DCD", "CM");
        s = s.replace("LXL", "XC");

        

        return s;
    }
}