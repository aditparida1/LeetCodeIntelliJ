package org.leetcode;
import java.util.*;

public class ZigZagLevel1104
{
    public List<Integer> pathInZigZagTree(int target)
    {
        List<Integer> ls = new ArrayList<>();

        int level = (int)(Math.log(target) / Math.log(2));
        level++;
        boolean isRev = level % 2 ==0;
        ls.add(target);
        while(level > 1)
        {
            int idxFromBeg = 0;
            int count = (int)Math.pow(2, level - 1);
            int end = (int)Math.pow(2, level) - 1;
            int start = end - count + 1;
            if(isRev)
            {
                int actualId = end - target + start;
                int prev = actualId / 2;
                ls.add(prev);
                target = prev;
            }
            else
            {
                int prevIdx = target/2;
                count = (int)Math.pow(2, level - 2);
                end = (int)Math.pow(2, level - 1) - 1;
                start = end - count + 1;
                int actualId = end - prevIdx + start;
                ls.add(actualId);
                target = actualId;
            }
            isRev = !isRev;
            level--;
        }
        Collections.reverse(ls);
        return ls;
    }
}
