package org.leetcode;
import java.util.*;
public class AllAPthfromSourcetoDest1059
{
    Map<Integer, Integer> nodeVisitMap = new HashMap<>();
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination)
    {
        Map<Integer, Set<Integer>> map = getGraph(edges);

        nodeVisitMap.put(source, 1);

        Set<Integer> neighs = map.get(source);
        if(neighs == null || neighs.size() == 0)
        {
            if(source == destination)
                return true;
            else
                return false;
        }

        for (int neigh: neighs)
        {
            if(!dfsCheck(map, source, destination))
                return false;
        }
        return true;
    }
    private boolean dfsCheck(Map<Integer, Set<Integer>> graph, int curr, int dest)
    {
        if(nodeVisitMap.containsKey(curr))
        {
            if(nodeVisitMap.get(curr) == 1 || nodeVisitMap.get(curr) == 0)
                return false;
            if(nodeVisitMap.get(curr) == 2)
                return true;
        }
        nodeVisitMap.put(curr, 1);

        Set<Integer> neighs = graph.get(curr);
        if(neighs == null || neighs.size() == 0)
        {
            if(curr == dest)
            {
                nodeVisitMap.put(curr, 2);
                return true;
            }
            else
            {
                nodeVisitMap.put(curr, 0);
                return false;
            }
        }
        for(int neigh: neighs)
        {
            if(!dfsCheck(graph, neigh, dest))
            {
                nodeVisitMap.put(curr, 0);
                return false;
            }
        }
        nodeVisitMap.put(curr, 2);
        return true;
    }


    private Map<Integer, Set<Integer>> getGraph(int[][] edges)
    {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges)
        {
            if(!map.containsKey(edge[0]))
            {
                map.put(edge[0], new HashSet<>());
            }
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1], new HashSet<>());
            }
            map.get(edge[0]).add(edge[1]);
        }
        return map;
    }
}
