package org.leetcode;
import java.util.*;

public class ShortestDistTargetCol1182
{
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries)
    {
        HolderCol[] dists = new HolderCol[colors.length];
        for(int i = 0; i < dists.length; ++i)
        {
            dists[i] = new HolderCol();
        }
        HolderCol curr = new HolderCol();
        for(int i = 0; i < colors.length; ++i)
        {
            if(colors[i] == 1)
            {
                curr.dist[0] = 0;
                if(curr.dist[1] != -1)
                {
                    curr.dist[1] ++;
                }
                if(curr.dist[2] != -1)
                {
                    curr.dist[2] ++;
                }
            }
            else if(colors[i] == 2)
            {
                curr.dist[1] = 0;
                if(curr.dist[0] != -1)
                {
                    curr.dist[0] ++;
                }
                if(curr.dist[2] != -1)
                {
                    curr.dist[2] ++;
                }
            }
            else if(colors[i] == 3)
            {
                curr.dist[2] = 0;
                if(curr.dist[1] != -1)
                {
                    curr.dist[1] ++;
                }
                if(curr.dist[0] != -1)
                {
                    curr.dist[0] ++;
                }
            }
            dists[i].dist[0] = curr.dist[0];
            dists[i].dist[1] = curr.dist[1];
            dists[i].dist[2] = curr.dist[2];
        }
        curr = new HolderCol();
        for (int i = colors.length - 1; i >= 0; i--)
        {
            if(colors[i] == 1)
            {
                curr.dist[0] = 0;
                if(curr.dist[1] != -1)
                {
                    curr.dist[1] ++;
                }
                if(curr.dist[2] != -1)
                {
                    curr.dist[2] ++;
                }
            }
            else if(colors[i] == 2)
            {
                curr.dist[1] = 0;
                if(curr.dist[0] != -1)
                {
                    curr.dist[0] ++;
                }
                if(curr.dist[2] != -1)
                {
                    curr.dist[2] ++;
                }
            }
            else if(colors[i] == 3)
            {
                curr.dist[2] = 0;
                if(curr.dist[1] != -1)
                {
                    curr.dist[1] ++;
                }
                if(curr.dist[0] != -1)
                {
                    curr.dist[0] ++;
                }
            }
            if(dists[i].dist[0] == -1 || dists[i].dist[0] > curr.dist[0])
            {
                if(curr.dist[0] != -1)
                {
                    dists[i].dist[0] = curr.dist[0];
                }
            }
            if(dists[i].dist[1] == -1 || dists[i].dist[1] > curr.dist[1])
            {
                if(curr.dist[1] != -1)
                {
                    dists[i].dist[1] = curr.dist[1];
                }
            }
            if(dists[i].dist[2] == -1 || dists[i].dist[2] > curr.dist[2])
            {
                if(curr.dist[2] != -1)
                {
                    dists[i].dist[2] = curr.dist[2];
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int[] query: queries)
        {
            int idx = query[0];
            int col = query[1] - 1;
            result.add(dists[idx].dist[col]);
        }
        return result;
    }
}
class HolderCol
{
    int[] dist = new int[]{-1, -1, -1};
}
