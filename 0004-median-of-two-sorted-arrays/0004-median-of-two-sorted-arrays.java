class Solution {
    public static int[] conquer(int[]arr1,int[] arr2)
    {
        int[] merged = new int[arr1.length+arr2.length];
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while(idx1<arr1.length && idx2<arr2.length)
        {
            if(arr1[idx1] < arr2[idx2]) merged[idx++] = arr1[idx1++];
            else merged[idx++] = arr2[idx2++];
        }
        while(idx1<arr1.length) merged[idx++] = arr1[idx1++];
        while(idx2<arr2.length) merged[idx++] = arr2[idx2++];

        return merged;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = conquer(nums1,nums2);
        int n = merged.length;
        if(n%2==0) return (((float)merged[n/2]+(float)merged[n/2 -1])/2);
        return ((float)merged[n/2]);
        //return ans;
    }
}