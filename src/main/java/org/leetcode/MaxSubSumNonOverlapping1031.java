package org.leetcode;

public class MaxSubSumNonOverlapping1031
{
    public int maxSumTwoNoOverlap(int[] ip, int l, int m)
    {
        int res = 0;
        int[] dp = new int[ip.length];
        for (int i = 0 ; i < ip.length; ++i)
        {
            dp[i] += ip[i];
            if(i-1 >=  0)
            {
                dp[i] += dp[i - 1];
            }
        }
        for(int i = 0; i <= ip.length - l; ++i)
        {
            int end = i + l - 1;

            int lSum = dp[end] - dp[i] + ip[i];
            int mSum = getMSum(0, dp, i, m, ip);
            mSum = Math.max(getMSum(end + 1, dp, ip.length, m, ip), mSum);
            if(mSum != -1)
            {
                res = Math.max(res, lSum + mSum);
            }
        }
        return res;
    }
    private int getMSum(int idx, int[] dp, int end, int m, int[] ip)
    {
        int sum = 0;
        boolean found = false;
        for(int i = idx; i <= end - m; ++i)
        {
            found = true;
            sum = Math.max(sum, dp[i + m - 1] - dp[i] + ip[i]);
        }
        if(!found)
            return -1;
        return sum;
    }
}
