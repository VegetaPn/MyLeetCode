#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num < 10:
            return num
        return (num - 1) % 9 + 1
