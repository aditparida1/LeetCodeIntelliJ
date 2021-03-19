package org.leetcode;
import java.util.*;

public class MinValtogetPosStepSum1413
{
    public int minStartValue(int[] nums)
    {
        int initial = 1;
        int sumSofar = 1;
        for (int i = 0; i < nums.length; ++i)
        {
            sumSofar += nums[i];
            if(sumSofar < 1)
            {
                initial += (1 - sumSofar);
                sumSofar = 1;
            }
        }

        return initial;
    }
}
