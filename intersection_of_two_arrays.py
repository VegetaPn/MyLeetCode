#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        res_nums = []
        [res_nums.append(x) for x in nums1 if x in nums2 and x not in res_nums]
        return res_nums


if __name__ == '__main__':
    s = Solution()
    print(s.intersection([1, 2, 2, 1], [2,2]))
