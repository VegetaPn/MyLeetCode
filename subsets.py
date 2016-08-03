#!/usr/bin/env python
# encoding: utf-8
import copy


class Solution(object):

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.locked_arr = []
        self.res = []
        self.upload_set(nums)
        self.res.append([])
        return self.res

    def upload_set(self, nums):
        if self.locked_arr == nums:
            return
        for i, item in enumerate(nums):
            if self.locked_arr and i < nums.index(self.locked_arr[len(self.locked_arr) - 1]):
                continue
            if item not in self.locked_arr:
                self.locked_arr.append(item)
                # self.res.append(copy.deepcopy(self.locked_arr))
                self.res += [self.locked_arr]
                self.upload_set(nums)
                self.locked_arr.remove(item)


if __name__ == '__main__':
    s = Solution()
    r = s.subsets([1,2,3])
    print(r)
