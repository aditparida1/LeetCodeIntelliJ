package org.leetcode;
import java.util.*;
public class IntervalListIntersec986
{
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList)
    {
        List<int[]> result = new ArrayList<>();
        List<int[]> intervals = new ArrayList<>();
        for(int[] intv: firstList)
        {
            intervals.add(intv);
        }
        for(int[] intv: secondList)
        {
            intervals.add(intv);
        }
        Collections.sort(intervals, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[0] < o2[0])
                {
                    return -1;
                }
                else if(o1[0] == o2[0])
                {
                    return Integer.compare(o1[1], o2[1]);
                }
                else
                    return 1;
            }
        });
        Stack<int[]> st = new Stack<>();
        for(int[] intv: intervals)
        {
            st.push(intv);
        }

        int[] prev = null;
        if(!st.isEmpty())
        {
            prev = st.pop();
        }

        while(!st.isEmpty())
        {
            int[] curr = st.pop();
            if(areOverlapping(curr, prev))
            {
                int[] inter = {curr[0], Math.min(curr[1], prev[1])};
                result.add(inter);
                int[] intermed = {prev[0], prev[1], curr[0], curr[1]};
                Arrays.sort(intermed);
                prev = new int[]{intermed[2], intermed[3]};
            }
            else
            {
                prev = curr;
            }
        }
        int[][] res= new int[result.size()][];
        int i = 0;
        for(int[] inter: result)
        {
            res[i] = inter;
            i++;
        }
        return res;
    }
    // a b c d
    private boolean areOverlapping(int[] a, int[] b)
    {
        if(a[0] >= b[0] && a[0] <= b[1])
            return true;
        if(b[0] >= a[0] && b[0] <= a[1])
            return true;
        if(a[1] >= b[0] && a[1] <= b[1])
            return true;
        if(b[1] >= a[0] && b[1] <= a[1])
            return true;
        return false;
    }

}
