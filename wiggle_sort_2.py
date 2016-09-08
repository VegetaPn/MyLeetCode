#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        nums.sort()
        if len(nums) <= 2:
            return
        half = len(nums[::2])
        nums[::2], nums[1::2] = nums[:half][::-1], nums[half:][::-1]


if __name__ == '__main__':
    s = Solution()
    n = [1,5,1,1,6,4]
    s.wiggleSort(n)
    print(n)
