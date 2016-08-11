#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        total_product = 1
        zero_counter = 0
        for n in nums:
            if n != 0:
                total_product *= n
            else:
                zero_counter += 1
        if zero_counter == 0:
            return [total_product / x for x in nums]
        elif zero_counter == 1:
            return [0 if x != 0 else total_product for x in nums]
        else:
            return [0 for x in nums]
