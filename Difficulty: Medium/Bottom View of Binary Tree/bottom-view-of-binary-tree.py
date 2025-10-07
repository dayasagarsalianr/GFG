class Solution:
    def bottomView(self, root):
        if not root: return []
        d = {}
        q = deque([(root, 0)])
        while q:
            node, hd = q.popleft()
            d[hd] = node.data
            if node.left: q.append((node.left, hd - 1))
            if node.right: q.append((node.right, hd + 1))
        return [d[k] for k in sorted(d)]