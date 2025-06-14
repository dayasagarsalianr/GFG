'''
class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None
'''
class Solution:
    def isSym(self,a,b):
        if not a or not b: return a is b
        if a.data!=b.data: return False
        return self.isSym(a.left,b.right) and self.isSym(a.right,b.left)
    def isSymmetric(self, root):
        return root is None or self.isSym(root.left,root.right)