#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if len(nums) <= 2:
            return nums
        nums.sort()
        i = 1
        l = len(nums)
        while i < l - 1:
            print(i)
            t = nums[i]
            nums[i] = nums[i+1]
            nums[i+1] = t
            i += 2


if __name__ == '__main__':
    s = Solution()
    n = [1,5,1,1,6,4]
    s.wiggleSort(n)
    print(n)
