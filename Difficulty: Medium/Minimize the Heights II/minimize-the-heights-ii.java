class Solution {
    int getMinDiff(int[] arr, int k) {
        
        int n1 = arr.length;
        if (n1 == 1) {
            return 0; 
        }
        Arrays.sort(arr);
        int differ = arr[n1 - 1] - arr[0];
        int smal = arr[0] + k;
        int lar = arr[n1 - 1] - k;
        for (int i = 0; i < n1 - 1; i++) {
            int curr_Max = Math.max(arr[i] + k, arr[n1 - 1] - k);
            int curr_Min = Math.min(arr[i + 1] - k, arr[0] + k);
            if (curr_Min < 0){
                continue;
            } 
            differ = Math.min(differ, curr_Max - curr_Min);
        }
        return differ;
    }
}