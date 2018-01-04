package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shilong.zhang on 2018/1/2.
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class SurroundedRegions {
    class Solution {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up

        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return;
            }

            int r = board.length;
            int c = board[0].length;
            int[][] visited = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    visited[i][j] = board[i][j] == 'X' ? 1 : 0;
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (visited[i][j] != 0) {
                        continue;
                    }
                    List<List<Integer>> path = new ArrayList<>();
                    if(!findWayOut(visited, r, c, i, j, path)) {
                       markPath(board, visited, path);
                    }
                }
            }

        }

        private boolean findWayOut(int[][] visited, int totalR, int totalC, int r, int c, List<List<Integer>> path) {
            if (visited[r][c] != 0) {
                return false;
            }

            visited[r][c] = 1;
            List<Integer> point = new ArrayList<>();
            point.add(r);
            point.add(c);
            path.add(point);

            if (r == 0 || r == totalR-1 || c == 0 || c == totalC-1) {
                return true;
            }

            boolean findWayOut = false;

            for (int[] dir : dirs) {
                if (findWayOut(visited, totalR, totalC, r+dir[0], c+dir[1], path)) {
                    findWayOut = true;
                }
            }

            return findWayOut;
        }

        private void markPath(char[][] board, int[][] visited, List<List<Integer>> path) {
            for (List<Integer> point : path) {
                int r = point.get(0);
                int c = point.get(1);
                board[r][c] = 'X';
                visited[r][c] = 1;
            }
        }
    }
}
