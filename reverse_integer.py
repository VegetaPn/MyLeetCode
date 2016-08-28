#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        res = 0
        is_positive = cmp(x, 0)
        x = is_positive * x
        while x != 0:
            res = (x % 10 + res * 10)
            x = x / 10
        return 0 if 2 ** 31 < res else is_positive * res


if __name__ == '__main__':
    s = Solution()
    print(s.reverse(123))
    print(s.reverse(-123))
    print(s.reverse(1234))
    print(s.reverse(-1234))
    print(s.reverse(0))
    print(s.reverse(1000000003))
