package org.leetcode;

import java.util.*;

public class ShortestwayToFormString
{
    Set<String> set;
    Map<Integer, Integer> map;
    String source;
    public int shortestWay(String source, String target)
    {
        set = new HashSet<>();
        map = new HashMap<>();
        this.source = source;
        return getMinWays(target, 0);
    }
    private int getMinWays(String target, int index)
    {
        if(index >= target.length())
            return 0;
        if(map.containsKey(index))
        {
            return map.get(index);
        }
        int min = Integer.MAX_VALUE;

        for (int i = target.length(); i > index; --i)
        {
            String sub = target.substring(index, i);
            int toForm = -1;
            if(set.contains(sub))
            {
                toForm = getMinWays(target, i);
            }
            else
            {
                if(isSubSeq(sub))
                {
                    set.add(sub);
                    toForm = getMinWays(target, i);
                }
            }
            if(toForm != -1)
            {
                min = Math.min(min, toForm + 1);
                break;
            }
        }
        if(min == Integer.MAX_VALUE)
            min = -1;
        map.put(index, min);
        return min;
    }
    private boolean isSubSeq(String ip)
    {
        int idx = 0;
        for (int i = 0; i < source.length(); ++i)
        {
            if(source.charAt(i) == ip.charAt(idx))
                idx++;
            if(idx >= ip.length())
                return true;
        }
        return false;
    }
}
