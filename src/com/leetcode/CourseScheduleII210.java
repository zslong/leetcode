package com.leetcode;

import java.util.*;

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

/**
 * Solution is copied from <a href='https://leetcode.com/problems/course-schedule-ii/discuss/59317'>here</a>
 * Basic idea is using directed graph topological sort
 */
public class CourseScheduleII210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // record each node's income edge counts
            int[] incLinkCounts = new int[numCourses];
            List<List<Integer>> adjs = new ArrayList<>();

            initGraph(incLinkCounts, adjs, prerequisites);
            return solveByBFS(incLinkCounts, adjs);
        }

        private void initGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
            int n = incLinkCounts.length;
            while (n-- > 0) {
                adjs.add(new ArrayList<>());
            }

            for (int[] edge : prerequisites) {
                incLinkCounts[edge[0]]++;
                adjs.get(edge[1]).add(edge[0]);
            }
        }

        private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs) {
            int[] order = new int[incLinkCounts.length];
            Queue<Integer> toVisit = new LinkedList<>();

            for (int i = 0; i < incLinkCounts.length; i++) {
                if (incLinkCounts[i] == 0) toVisit.add(i);
            }

            int visited = 0;

            while (!toVisit.isEmpty()) {
                int from = toVisit.poll();
                order[visited++] = from;
                for (int to : adjs.get(from)) {
                    incLinkCounts[to]--;
                    if (incLinkCounts[to] == 0) {
                        toVisit.add(to);
                    }
                }
            }

            return visited == incLinkCounts.length ? order : new int[0];
        }
    }
}
