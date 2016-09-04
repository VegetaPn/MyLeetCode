#!/usr/bin/env python
# encoding: utf-8


class Apples:
    def getInitial(self, n):
        # write code here
        c = 1
        while True:
            if self.is_finished(c, n):
                return c
            c += n

    def is_finished(self, c, n):
        while True:
            for i in range(n):
                if c % n == 1:
                    c = c - c / n - 1
                else:
                    return False
            return True

if __name__ == '__main__':
    n = 8
    a = Apples()
    i = a.getInitial(n)
    print(i)
