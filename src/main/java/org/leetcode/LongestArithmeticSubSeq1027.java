package org.leetcode;
import java.util.*;
public class LongestArithmeticSubSeq1027
{
    public int longestArithSeqLength(int[] ip)
    {
        int max = 0;
        Map<Integer, Integer>[] map = new HashMap[ip.length];
        for (int i = 0; i < map.length; ++i)
        {
            map[i] = new HashMap<>();
        }

        for (int i = 0 ; i < ip.length; ++i)
        {
            for (int j = 0; j < i; ++j)
            {
                int diff = ip[i] - ip[j];
                int len = 1;
                if(map[j].containsKey(diff))
                {
                    len += map[j].get(diff);
                }
                if(!map[i].containsKey(diff))
                {
                    map[i].put(diff, 0);
                }
                map[i].put(diff, Math.max(len, map[i].get(diff)));
                max = Math.max(max, map[i].get(diff));
            }
        }

        return max;
    }
}
