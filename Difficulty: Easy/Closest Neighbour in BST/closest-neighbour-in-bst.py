'''
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
    def findMaxFork(self, root, k):
        res = -1
        while root:
            if root.data == k:
                return k
            if root.data < k:
                res = root.data
                root = root.right
            else:
                root = root.left
        return res