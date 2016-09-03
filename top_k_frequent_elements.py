#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        res = []
        freq_dict = dict()
        for i in nums:
            freq_dict[i] = freq_dict.get(i, 0) + 1

        bucket_freq = [[] for x in range(len(nums) + 1)]
        for key in freq_dict.keys():
            bucket_freq[freq_dict.get(key)].append(key)

        i = 1
        while len(res) < k:
            if bucket_freq[-i]:
                for val in bucket_freq[-i]:
                    if len(res) < k:
                        res.append(val)
            i += 1

        print(bucket_freq)
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.topKFrequent([1,1,2,2,3,3,3,4,4,4,5,5,5,5,6,6,6,6], 4))
