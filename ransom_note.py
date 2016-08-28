#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        mgz_list = [x for x in magazine]
        try:
            for item in ransomNote:
                mgz_list.remove(item)
        except:
            return False
        return True
