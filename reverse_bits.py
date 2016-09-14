#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def reverseBits(self, n):
        """
        :type n: int
        :rtype: int
        """
        bits_arr = []
        cnt = 0
        res = 0
        self.generate_bits(n, bits_arr)
        for item in bits_arr[::-1]:
            res += (item * pow(2, cnt))
            cnt += 1
        return res

    def generate_bits(self, n, bit_arr):
        if n < 2:
            bit_arr.append(n)
            while len(bit_arr) < 32:
                bit_arr.append(0)
            return
        bit_arr.append(n % 2)
        self.generate_bits(n / 2, bit_arr)


if __name__ == '__main__':
    s = Solution()
    n = 43261596
    res = s.reverseBits(n)
    print(res)
