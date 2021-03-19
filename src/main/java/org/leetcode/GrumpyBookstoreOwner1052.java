package org.leetcode;
import java.util.*;

public class GrumpyBookstoreOwner1052
{
    public int maxSatisfied(int[] customers, int[] grumpy, int x)
    {
        int totalSum = 0;
        for (int i = 0; i < customers.length; ++i)
        {
            if(grumpy[i] != 1)
            {
                totalSum += customers[i];
            }
        }

        if(x >= customers.length)
        {
            for (int i = 0 ; i < customers.length; ++i)
            {
                if(grumpy[i] == 1)
                {
                    totalSum += customers[i];

                }
            }
            return totalSum;
        }
        int max = 0;

        for (int i = 0; i < x; ++i)
        {
            if(grumpy[i] == 1)
            {
                totalSum += customers[i];
            }
        }
        max = Math.max(totalSum, max);

        for (int i = 1; i <= customers.length - x; ++i)
        {
            int toRem = i - 1;
            int toAdd = i + x - 1;
            if(grumpy[toRem] == 1)
            {
                totalSum -= customers[toRem];

            }
            if(grumpy[toAdd] == 1)
            {
                totalSum += customers[toAdd];
            }
            max = Math.max(max, totalSum);
        }

        return max;
    }
}
