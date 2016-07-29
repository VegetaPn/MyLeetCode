#!/usr/bin/env python
# encoding: utf-8

# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        ""
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """


class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.item_arr = []
        self.counter = 0

        self.load_arr(nestedList)
        self.list_len = len(self.item_arr)

    def load_arr(self, item):
        for ite in item:
            if ite.isInteger():
                self.item_arr.append(ite.getInteger())
            else:
                self.load_arr(ite.getList())

    def next(self):
        """
        :rtype: int
        """
        res = self.item_arr[self.counter]
        self.counter += 1
        return res

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.counter < self.list_len

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())
