package org.leetcode;
import java.util.*;

public class VideoStitching1024
{
    public int videoStitching(int[][] clips, int t)
    {
        int count = 0;
        if(t == 0)
            return 0;
        Arrays.sort(clips, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[0] < o2[0])
                    return -1;
                else if(o1[0] == o2[0])
                {
                    return Integer.compare(o1[1], o2[1]);
                }
                else
                    return 1;
            }
        });

        HashMap<Integer, int[]> map = new HashMap<>();

        for(int i = 0 ; i < clips.length; ++i)
        {
            map.put(clips[i][0], clips[i]);
        }
        if(!map.containsKey(0))
        {
            return -1;
        }
        int[] curr = map.get(0);
        count = 1;
        int currLast = curr[1];
        while(currLast < t)
        {
            int[] temp = getNext(curr[0] + 1, curr[1] + 1, map);
            if(temp == null || temp[1] <= curr[1])
                return -1;

            curr = temp;
            count++;
            currLast = curr[1];
        }
        return count;
    }
    private int[] getNext(int start, int end, Map<Integer, int[]> map)
    {
        int[] temp = null;
        for (int i = start; i <= end; ++i)
        {
            if(map.containsKey(i))
            {
                if(temp == null)
                {
                    temp = map.get(i);
                }
                else
                {
                    if(temp[1] < map.get(i)[1])
                    {
                        temp = map.get(i);
                    }
                }
            }
        }
        return temp;
    }
}
