package org.leetcode;
import java.util.*;
public class MinDifficultyJobSchedule1335
{
    Map<String, Integer> dp;
    public int minDifficulty(int[] jobDifficulty, int d)
    {
        dp = new HashMap<>();

        return getRemaining(0, 1, d, jobDifficulty);
    }
    private int getRemaining(int currJobIndex, int currDay, int maxDay, int[] jobDifficulty)
    {
        if(currDay > maxDay && currJobIndex >= jobDifficulty.length)
            return 0;
        if(currDay < maxDay && currJobIndex >= jobDifficulty.length)
            return -1;
        if(currDay > maxDay && currJobIndex < jobDifficulty.length)
            return -1;
        String state = Integer.toString(currDay) + "#" + Integer.toString(currJobIndex);
        if(dp.containsKey(state))
            return dp.get(state);
        int minForDay = jobDifficulty[currJobIndex];
        int minSolution = -1;
        for(int i = currJobIndex; i < jobDifficulty.length; ++i)
        {
            minForDay = Math.min(minForDay, jobDifficulty[i]);
            int remaining = getRemaining(i + 1, currDay + 1, maxDay, jobDifficulty);
            if(remaining != -1)
            {
                if(minSolution == -1)
                {
                    minSolution = minForDay + remaining;
                }
                else
                {
                    minSolution = Math.min(minSolution, minForDay + remaining);
                }
            }
        }
        dp.put(state, minSolution);
        return minSolution;
    }
}
