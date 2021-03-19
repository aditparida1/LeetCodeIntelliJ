package org.leetcode;
import java.util.*;
public class FlowerPLantingNoAdj1042
{
    public int[] gardenNoAdj(int n, int[][] paths)
    {
        var map = getMap(paths);
        int[] result = new int[n];

        var assignedColor = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        assignedColor.put(1, 1);
        visited.add(1);

        for (int i = 1; i < n + 1; ++i)
        {
            if(!visited.contains(i))
            {
                q.add(i);
                assignedColor.put(i, 1);
                visited.add(i);
                while(!q.isEmpty())
                {
                    int curr = q.poll();
                    Set<Integer> colors = new HashSet<>();
                    colors.add(1);
                    colors.add(2);
                    colors.add(3);
                    colors.add(4);
                    for(int neigh: map.get(curr))
                    {
                        if(assignedColor.containsKey(neigh))
                        {
                            colors.remove(assignedColor.get(neigh));
                        }
                        if(!visited.contains(neigh))
                        {
                            q.add(neigh);
                            visited.add(neigh);
                        }
                    }
                    for(int col: colors)
                    {
                        assignedColor.put(curr, col);
                        break;
                    }
                }
            }
        }



        for (int key: assignedColor.keySet())
        {
            result[key - 1] = assignedColor.get(key);
        }
        return result;
    }
    public Map<Integer, Set<Integer>> getMap(int[][] paths)
    {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] path: paths)
        {
            if(!map.containsKey(path[0]))
            {
                map.put(path[0], new HashSet<>());
            }
            if(!map.containsKey(path[1]))
            {
                map.put(path[1], new HashSet<>());
            }
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }
        return map;
    }
}
