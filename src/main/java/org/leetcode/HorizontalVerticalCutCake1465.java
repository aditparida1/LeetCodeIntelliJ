package org.leetcode;
import java.util.*;
public class HorizontalVerticalCutCake1465
{
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts)
    {
        int mod = 1_000_000_007;
        int result = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long horMax = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 0; i < horizontalCuts.length - 1; ++i)
        {
            horMax = Math.max(horizontalCuts[i + 1] - horizontalCuts[i], horMax);
        }

        long verMax = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for(int i = 0; i < verticalCuts.length - 1; ++i)
        {
            verMax = Math.max(verMax, verticalCuts[i + 1] - verticalCuts[i]);
        }
        long maxArea = horMax * verMax;
        result = (int)(maxArea % mod);

        return result;
    }
}
