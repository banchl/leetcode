package com.fibonacci.easy;

/**
 * {@code 746. Min Cost Climbing Stairs}
 * <p>
 * 题解:
 * <p>
 *      70题的衍生题，类似于53题求最大字串
 *      到达台阶N的步数有两种方法，一种为从N-1级台阶跨一步，一种为从N-2级台阶跨两步<p>
 *      minCostClimbingStairs(A, i) = minCostClimbingStairs(A, i - 1) < minCostClimbingStairs(A, i - 2) ? maxSubArray(A, i - 1) : minCostClimbingStairs(A, i - 2) + A[i];
 *      即到A[i]位置最小的cost等于A[i]位置的cost加上A[i-1]<A[i-2]?A[i-1]:A[i-2]的cost
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs1(int[] cost) {
        for(int i= 2; i<cost.length;i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length -1], cost[cost.length -2]);
    }


    public int minCostClimbingStairs2(int[] cost) {
        int [] mc = new int[cost.length + 1];
        mc[0] = cost[0];
        mc[1] = cost[1];
        
        for(int i = 2; i <= cost.length; i++){
            int costV = (i==cost.length)?0:cost[i];
            mc[i] = Math.min(mc[i-1] + costV, mc[i-2] + costV);
        }
        return mc[cost.length];
    }

}
