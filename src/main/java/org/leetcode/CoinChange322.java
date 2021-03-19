package org.leetcode;

import java.util.Arrays;

public class CoinChange322
{
    int[] dp;
    public int coinChange(int[] coins, int amount)
    {
        dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        getCoinChange(coins, amount);
        return dp[amount];
    }
    public int getCoinChange(int[] coins, int currAmt)
    {
        if(currAmt == 0)
            return 0;
        if(currAmt < 0)
            return -1;
        if(dp[currAmt] != -2)
            return dp[currAmt];
        int min = Integer.MAX_VALUE;
        for(int coin: coins)
        {
            int coinNeeded = getCoinChange(coins, currAmt - coin);
            if(coinNeeded != -1)
            {
                min = Math.min(coinNeeded + 1, coin);
            }
        }
        if(min != Integer.MAX_VALUE)
        {
            dp[currAmt] = min;
        }
        else
        {
            dp[currAmt] = -1;
        }
        return dp[currAmt];
    }
}
