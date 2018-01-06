package com.leetcode;

/**
 * Created by shilong.zhang on 2018/1/5.
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */
public class GasStation134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            if (gas == null || cost == null || gas.length < 1 || cost.length < 1 || gas.length != cost.length) {
                return 0;
            }

            int len = gas.length;
            int i = 0;
            int sum = 0;
            int start = i;
            int prevSum = 0;
            while (i < len) {
                int remain = gas[i] - cost[i];
                sum += remain;
                if (sum < 0) {
                    start = i+1;
                    prevSum += sum;
                    sum = 0;
                }
                i++;
            }

            if (sum + prevSum >= 0) {
                return start;
            } else {
                return -1;
            }

        }
    }

    public static void main(String[] args) {
        GasStation134 gasStation134 = new GasStation134();
        Solution solution = gasStation134.new Solution();

        int[] gas = new int[]{99, 98, 97, 100};
        int[] cost = new int[]{100, 100, 100 ,97};

        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
