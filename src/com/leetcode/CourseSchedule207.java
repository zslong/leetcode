package com.leetcode;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule207 {
    class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses < 2) {
                return true;
            }

            ArrayList<Integer>[] graph = new ArrayList[numCourses];
            boolean[] visited = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : prerequisites) {
                graph[edge[0]].add(edge[1]);
            }

            for (int i = 0; i < numCourses; i++) {
                if (!dfs(i, graph, visited)) {
                    return false;
                }
            }

            return true;
        }

        private boolean dfs(int start, ArrayList<Integer>[] graph, boolean[] visited) {
            if (visited[start]) {
                return false;
            } else {
                visited[start] = true;
            }

            for (Integer neighbor : graph[start]) {
                if (!dfs(neighbor, graph, visited)) {
                    return false;
                }
            }

            visited[start] = false;

            return true;
        }
    }

    public static void main(String[] args) {
        CourseSchedule207 courseSchedule207 = new CourseSchedule207();
        Solution solution = courseSchedule207.new Solution();
        int numCourses = 2;
        int[][] pre = new int[][]{{1, 0}};
        solution.canFinish(numCourses, pre);
    }
}
