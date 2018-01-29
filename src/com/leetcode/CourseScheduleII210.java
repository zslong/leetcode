package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shilong.zhang on 2018/1/29.
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */


public class CourseScheduleII210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer> result = new ArrayList<>();
            ArrayList<Integer>[] graph = new ArrayList[numCourses];

            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] pre : prerequisites) {
                graph[pre[1]].add(pre[0]);
            }

            boolean[] visited = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (!dfs(i, graph, visited, result)) {
                    result = new ArrayList<>();
                    break;
                }

                if (result.size() == numCourses) {
                    break;
                }

                result = new ArrayList<>();
            }

            int[] arr = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                arr[i] = result.get(i);
            }

            return arr;
        }

        private boolean dfs(int start, ArrayList<Integer>[] graph, boolean[] visited, List<Integer> result) {
            if (visited[start]) {
                return false;
            } else {
                visited[start] = true;
                result.add(start);
            }

            for (Integer neighbor : graph[start]) {
                if (!dfs(neighbor, graph, visited, result)) {
                    return false;
                }
            }

            visited[start] = false;

            return true;
        }
    }
}
