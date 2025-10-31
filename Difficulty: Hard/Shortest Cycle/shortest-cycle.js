class Solution {
  shortCycle(V, edges) {
    const graph = Array.from({ length: V }, () => []);
    for (const [u, v] of edges) {
      graph[u].push(v);
      graph[v].push(u);
    }

    let res = Infinity;

    for (let start = 0; start < V; start++) {
      const dist = Array(V).fill(-1);
      const parent = Array(V).fill(-1);
      dist[start] = 0;
      const queue = [];
      queue.push(start);

      while (queue.length) {
        const u = queue.shift();
        for (const v of graph[u]) {
          if (dist[v] === -1) {
            dist[v] = dist[u] + 1;
            parent[v] = u;
            queue.push(v);
          } else if (parent[u] !== v && parent[v] !== u) {
            // Cycle detected, update shortest cycle length
            const cycle_len = dist[u] + dist[v] + 1;
            if (cycle_len < res) {
              res = cycle_len;
            }
          }
        }
      }
    }

    return res === Infinity ? -1 : res;
  }
}