package xyz.yhngo.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Vegeta on 8/25/16.
 */
public class SurroundedRegions {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        if (m < 3) {
            return;
        }

        int n = board[0].length;
        if (board[0].length < 3) {
            return;
        }

        List[][] adj = new ArrayList[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = new ArrayList();
                if (i != 0)
                    adj[i][j].add(new Point(i-1, j));
                if (j != 0)
                    adj[i][j].add(new Point(i, j-1));
                if (i != m-1)
                    adj[i][j].add(new Point(i+1, j));
                if (j != n-1)
                    adj[i][j].add(new Point(i, j+1));
            }
        }

        int[][] marked = new int[m][n];
        Queue queue = new LinkedList();
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (marked[i][j] == 0 && board[i][j] == 'O') {
                    queue.add(new Point(i, j));
//                    for (int k = 0; k < adj[i][j].size(); k++) {
//                        Point p = (Point) adj[i][j].get(k);
//                        if (!marked[p.x][p.y] && board[p.x][p.y] == 'O') {
//                            queue.add(p);
//                        }
//                    }
                    bfs(queue, board, adj, marked);
                }
            }
        }
    }

    private void bfs(Queue q, char[][] board, List[][] adj, int[][] marked) {
        List<Point> points = new ArrayList<>();
        while (!q.isEmpty()) {
            boolean flag = true;
            Point p = (Point) q.poll();
            int x = p.x;
            int y = p.y;
            marked[x][y] = 1;

            for (int i = 0; i < adj[x][y].size(); i++) {
                Point adjPoint = (Point) adj[x][y].get(i);
                if (marked[adjPoint.x][adjPoint.y] == 2) {
                    flag = false;
                    marked[x][y] = 2;
                    break;
                }
                if (marked[adjPoint.x][adjPoint.y] == 0 && board[adjPoint.x][adjPoint.y] == 'O') {
                    if (adjPoint.x == 0 || adjPoint.x == board.length-1 || adjPoint.y == 0 || adjPoint.y == board[0].length-1) {
                        flag = false;
                        marked[x][y] = 2;
                        break;
                    }
                    q.add(adjPoint);
                }
            }

            if (flag) {
                points.add(p);
            } else {
                for (int i = 0; i < points.size(); i++) {
                    marked[points.get(i).x][points.get(i).y] = 2;
                }
                points.clear();
            }
        }

        for (int i = 0; i < points.size(); i++) {
            board[points.get(i).x][points.get(i).y] = 'X';
        }
    }

    public static void main(String args[]) {
//        char[][] arr = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
//        char[][] arr = {{'X','X','X'}, {'X','O','X'}, {'X','X','X'}};
//        char[][] arr = {{}};
        char[][] arr = {{'O','O','O','O','X','X'}, {'O','O','O','O','O','O'}, {'O','X','O','X','O','O'}, {'O','X','O','O','X','O'}, {'O','X','O','X','O','O'}, {'O','X','O','O','O','O'}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
