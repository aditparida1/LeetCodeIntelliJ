package org.leetcode;

import java.util.*;

public class ShortestPathAlternatingColor1129
{
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges)
    {
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Map<Integer, Set<Integer>[]> graph;
        graph = getGraph(red_edges, blue_edges);
        Set<Integer> redSeen = new HashSet<>();
        Set<Integer> blueSeen =  new HashSet<>();
        Queue<HolderWithColor> q = new LinkedList<>();
        HolderWithColor start = new HolderWithColor(0, -1);
        q.add(start);
        redSeen.add(0);
        blueSeen.add(0);
        int level = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size >0)
            {
                HolderWithColor curr = q.poll();
                result[curr.node] = result[curr.node] == -1? level: result[curr.node];
                Set<Integer>[] neighbors = graph.get(curr.node);
                if(neighbors == null)
                {
                    size--;
                    continue;
                }
                if(curr.color != 0)
                {
                    for(int neigh: neighbors[0])
                    {
                        if(!redSeen.contains(neigh))
                        {
                            redSeen.add(neigh);
                            q.add(new HolderWithColor(neigh, 0));
                        }
                    }
                }
                if(curr.color != 1)
                {
                    for(int neigh: neighbors[1])
                    {
                        if(!blueSeen.contains(neigh))
                        {
                            blueSeen.add(neigh);
                            q.add(new HolderWithColor(neigh, 1));
                        }
                    }
                }

                size--;
            }
            level++;
        }


        return result;
    }

    private Map<Integer, Set<Integer>[]> getGraph(int[][] red, int[][] blue)
    {
        Map<Integer, Set<Integer>[]> map = new HashMap<>();

        for (int[] edge: red)
        {
            if(!map.containsKey(edge[0]))
            {
                map.put(edge[0], new Set[2]);
                map.get(edge[0])[0] = new HashSet<>();
                map.get(edge[0])[1] = new HashSet<>();
            }
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1], new Set[2]);
                map.get(edge[1])[0] = new HashSet<>();
                map.get(edge[1])[1] = new HashSet<>();
            }

            map.get(edge[0])[0].add(edge[1]);
        }

        for(int[] edge: blue)
        {
            if(!map.containsKey(edge[0]))
            {
                map.put(edge[0], new Set[2]);
                map.get(edge[0])[0] = new HashSet<>();
                map.get(edge[0])[1] = new HashSet<>();
            }
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1], new Set[2]);
                map.get(edge[1])[0] = new HashSet<>();
                map.get(edge[1])[1] = new HashSet<>();
            }
            map.get(edge[0])[0].add(edge[1]);
        }

        return map;
    }
}
class HolderWithColor
{
    int node;
    int color;
    public HolderWithColor(int node, int color)
    {
        this.node = node;
        this.color = color;
    }
}
