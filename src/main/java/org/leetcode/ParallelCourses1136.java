package org.leetcode;
import java.util.*;

public class ParallelCourses1136
{
    public int minimumSemesters(int n, int[][] relations)
    {
        int visited[] = new int[n + 1];
        Map<Integer, Set<Integer>> graph = getGraph(relations);
        int max = -1;
        for (int i = 1; i < visited.length; ++i)
        {
            if(visited[i] == 0)
            {
                int level = getLevel(i, graph, visited);
                if(level == -1)
                    return -1;
                max = Math.max(max, level);
            }
        }
        return max;
    }
    private int getLevel(int i, Map<Integer, Set<Integer>> graph, int[] visited)
    {
        int max = -1;
        if(visited[i] == -1)
            return -1;
        if(visited[i] != 0)
        {
            return visited[i];
        }

        visited[i] = -1;
        Set<Integer> neighs = graph.get(i);
        if(neighs == null)
        {
            visited[i] = 1;
            return visited[i];
        }
        for(int neigh: neighs)
        {

            int level = getLevel(neigh, graph, visited);
            if(level == -1)
            {
                visited[i] = -1;
                return -1;
            }
            max = Math.max(max, level);

        }
        visited[i] = max + 1;
        return visited[i];
    }
    private Map<Integer, Set<Integer>> getGraph(int[][] edges)
    {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for(int[] edge: edges)
        {
            if(!graph.containsKey(edge[0]))
            {
                graph.put(edge[0], new HashSet<>());
            }
            if(!graph.containsKey(edge[1]))
            {
                graph.put(edge[1], new HashSet<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }
        return  graph;
    }

}
