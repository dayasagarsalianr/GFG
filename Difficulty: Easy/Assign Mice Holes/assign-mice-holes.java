class Solution {
    public int assignHole(int[] mices, int[] holes) {
        // code here
        Arrays.sort(mices);
        Arrays.sort(holes);
        
        int res = 0;
        for (int i = 0; i < mices.length; i++) {
            res = Math.max(res, Math.abs(mices[i] - holes[i]));
        }
        
        return res;
    }
};