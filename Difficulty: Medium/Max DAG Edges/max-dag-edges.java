class Solution {
    public int maxEdgesToAdd(int n, int[][] edges) {
       // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean isEdgeExsist[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) 
        adj.add(new ArrayList<>());
        
          for (int[] pre : edges) {
            int u = pre[0];
            int v = pre[1];
            adj.get(u).add(v); // u -> v
            isEdgeExsist[u][v] = true;
            
        }
        
        // Step 2: Calculate indegree of each node
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int nei : adj.get(i)) indegree[nei]++;
        }


        // Step 3: Add nodes with indegree 0 to queue 
        Queue<Integer> q = new LinkedList<>();
           for (int i = 0; i < n; i++){
               if(indegree[i]==0) q.add(i);
           }
        
         // Step 4: BFS / Topological Sort
         ArrayList<Integer> order = new ArrayList<>();
         while(!q.isEmpty()){
             int node = q.poll();
             order.add(node);
             for(int nei: adj.get(node)){
                 indegree[nei]--;
                   if(indegree[nei]==0) q.add(nei);
             }
         }
         //check 
         int ans=0;
         for(int i=0; i<n; i++){
             for(int j=i+1; j<n; j++){
                 int u = order.get(i), v = order.get(j);
                 if(!isEdgeExsist[u][v])
                 ans++;
             }
         }
         return ans;
    }
}