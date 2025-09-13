class Solution {
  public:
    int minCost(int n, int m, vector<int>& x, vector<int>& y) {
        //  code here
        sort(x.rbegin(),x.rend());
        sort(y.rbegin(),y.rend());
        
        int i=0;
        int j=0;
        
      
        
        int h =1;
        int v =1;
        int ans =0;
        
        while(i<m-1 && j<n-1){
            if(x[i]>y[j]){
                //Cut vertically
                //Vertical pices increases by 1
                
                ans+=(x[i]*h);
                v++;
                i++;
            }else{
                
                //Cut horizontally
                //Horizontally pices increases by 1
                
                ans+=(y[j]*v);
                h++;
                j++;
            }
        }
        
        while(i<m-1){
             ans+=(x[i]*h);
                v++;
                i++;
        }
        
        while(j<n-1){
             ans+=(y[j]*v);
                h++;
                j++;
        }
        
        return ans;
    }
};