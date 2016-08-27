#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        result_list = []
        self.permute(nums, [], result_list)
        print(result_list)

    def permute(self, remains, boxes, result_list):
        """TODO: Docstring for permute.
        :returns: TODO
        """
        if len(remains) == 0:
            result_list.append(boxes[::])
            return
        for i, item in enumerate(remains):
            # if i < len(remains) - 1 and item == remains[i + 1]:
            if i > 0 and item == remains[i - 1]:
                continue
            remains.remove(item)
            boxes.append(item)
            self.permute(remains, boxes, result_list)
            remains.insert(i, item)
            boxes.pop()


if __name__ == '__main__':
    s = Solution()
    s.permuteUnique([0, 0, 2])
    s.permuteUnique([])
    s.permuteUnique([0,1,2])
    s.permuteUnique([1, 2])
    s.permuteUnique([1,1,1,1,1,1,1,1,1])
    s.permuteUnique([3,3,0,3])
    s.permuteUnique([1,1,5,5])

#    s.permuteUnique([1,2,3,4,5,6,7,8,9,0])
