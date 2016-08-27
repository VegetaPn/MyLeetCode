#!/usr/bin/env python
# encoding: utf-8


class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        row_dict = dict()
        col_dict = dict()
        gird_dict = dict()

        for i in range(9):
            row_dict[i] = []
            col_dict[i] = []
            gird_dict[i] = []

        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    if board[i][j] in row_dict[i] or board[i][j] in col_dict[j] or board[i][j] in gird_dict[(j / 3) * 3 + i / 3]:
                        return False
                    row_dict[i].append(board[i][j])
                    col_dict[j].append(board[i][j])
                    gird_dict[(j / 3) * 3 + i / 3].append(board[i][j])

        return True
