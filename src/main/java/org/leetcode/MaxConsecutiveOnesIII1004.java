package org.leetcode;

public class MaxConsecutiveOnesIII1004
{
    public int longestOnes(int[] ip, int k)
    {
        int result = 0;
        int left = 0; int right = 0;

        while(right < ip.length)
        {
            if(ip[right] == 1 || (ip[right] == 0 && k > 0))
            {
                if(ip[right] == 0)
                {
                    ip[right] = 2;
                    k--;
                }
                result = Math.max(result, right - left + 1);
                right++;
            }
            else
            {
                while(k <= 0 && left <= right)
                {
                    if(ip[left] == 2)
                    {
                        ip[left] = 0;
                        k++;
                    }
                    left++;
                }
                if(left > right)
                    right = left;
            }

        }
        result = Math.max(result, right - left);
        return result;
    }
}
