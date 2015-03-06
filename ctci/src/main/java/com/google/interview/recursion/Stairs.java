package com.google.interview.recursion;

public class Stairs {

    public static void countTotalNumberOfWaysToClimbStairs(int numStairs, int[] numWays) {
        if (numStairs < 0) {
            return;
        } else if (numStairs == 0) {
            numWays[0]++;
        } else {
            countTotalNumberOfWaysToClimbStairs(numStairs - 1, numWays);
            countTotalNumberOfWaysToClimbStairs(numStairs - 2, numWays);
            countTotalNumberOfWaysToClimbStairs(numStairs - 3, numWays);
        }
    }

    public static void main(String args[]) {
        int[] numWays = new int[1];
        numWays[0] = 0;

        countTotalNumberOfWaysToClimbStairs(5, numWays);
        System.out.println(numWays[0]);
    }

    // 118

}
