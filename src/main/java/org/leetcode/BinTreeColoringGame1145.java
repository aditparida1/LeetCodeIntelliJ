package org.leetcode;
import java.util.*;
public class BinTreeColoringGame1145
{
    public boolean btreeGameWinningMove(TreeNode root, int n, int x)
    {
        Map<Integer, List<Integer>> graph = getGraph(root);
        Map<Integer, Integer> sol = new HashMap<>();

        for(int neigh: graph.get(x))
        {
            int solNeigh = getCount(graph, x, neigh);
            sol.put(neigh, solNeigh);
        }
        for (int key: sol.keySet())
        {
            int solNode = sol.get(key);
            if(n - solNode < solNode)
                return true;
        }
        return false;
    }
    private int getCount(Map<Integer, List<Integer>> graph, int noPass, int start)
    {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(noPass);
        visited.add(start);

        while(!q.isEmpty())
        {
            int curr = q.poll();
            count++;
            List<Integer> neighs = graph.get(curr);
            for(int neigh: neighs)
            {
                if(!visited.contains(neigh))
                {
                    visited.add(neigh);
                    q.offer(neigh);
                }
            }

        }

        return count;
    }
    private Map<Integer, List<Integer>> getGraph(TreeNode root)
    {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(!graph.containsKey(curr.val))
            {
                graph.put(curr.val, new ArrayList<>());

            }
            if(curr.left != null)
            {
                if(!graph.containsKey(curr.left.val))
                {
                    graph.put(curr.left.val, new ArrayList<>());
                }
                graph.get(curr.val).add(curr.left.val);
                graph.get(curr.left.val).add(curr.val);
                q.add(curr.left);
            }
            if(curr.right != null)
            {
                if(!graph.containsKey(curr.right.val))
                {
                    graph.put(curr.right.val, new ArrayList<>());
                }
                graph.get(curr.val).add(curr.right.val);
                graph.get(curr.right.val).add(curr.val);
                q.add(curr.right);
            }
        }
        return graph;
    }
}
