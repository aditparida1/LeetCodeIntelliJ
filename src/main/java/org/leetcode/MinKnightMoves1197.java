package org.leetcode;
import java.util.*;
public class MinKnightMoves1197
{
    public int minKnightMoves(int x, int y)
    {
        int level = 0;
        int[][] dirs = {
                {2,1}, {2, -1},
                {-2, 1}, {-2, -1},
                {1, 2}, {-1, 2},
                {1, -2}, {-1, -2}
        };
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(0);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty())
        {
            int size = q.size();

            while(size > 0)
            {
                int[] pos = q.poll();
                if(pos[0] == x && pos[1] == y)
                {
                    return level;
                }
                for(int[] dir : dirs)
                {
                    int newx = pos[0] + dir[0];
                    int newy = pos[1] + dir[1];
                    if(!map.containsKey(newx) || (!map.get(newx).contains(newy)))
                    {
                        if(!map.containsKey(newx))
                        {
                            map.put(newx, new HashSet<>());
                        }
                        map.get(newx).add(newy);
                        q.add(new int[]{newx, newy});
                    }
                }
                size--;
            }
            level++;
        }
        return 0;
    }
}
