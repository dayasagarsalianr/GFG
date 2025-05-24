class Solution:
    def sumSubstrings(self,s):
        output=f=0
        for i,ch in enumerate(s):
            f=f*10+int(ch)*(i+1)
            output+=f
        return output