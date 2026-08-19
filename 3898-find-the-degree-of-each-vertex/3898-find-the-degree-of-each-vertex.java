class Solution {
    public int[] findDegrees(int[][] matrix) {
        //List<List<Integer>> list = new ArrayList<>();
        int n = matrix.length;
        // for(int i=0; i<n; i++){
        //     list.add(new ArrayList<Integer>());
        // }
        int[] in = new int[n];
        int[] out = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1){
                    in[j]++;
                    out[i]++;
                }
            }
        }
        return in;
    } 
}