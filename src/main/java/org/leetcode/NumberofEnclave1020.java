package org.leetcode;
import java.util.*;


public class NumberofEnclave1020
{
    public int numEnclaves(int[][] grid)
    {
        int res = 0;

        for (int i = 0; i < grid.length; ++i)
        {
            for(int j = 0; j < grid[0].length; ++j)
            {
                if(grid[i][j] == 1)
                {
                    res += bfs(grid, i, j);
                }
            }
        }


        return res;
    }
    private int bfs(int[][] grid, int i, int j)
    {
        int total = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int[][] dirs = new int[][]{
                {1,0}, {-1, 0}, {0, 1}, {0, -1}
        };
        grid[i][j] = 2;
        boolean outOfGrid = false;
        total++;
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir: dirs)
            {
                int newi = i + dir[0];
                int newj = j + dir[1];
                if(isValid(newi, newj, grid))
                {
                    if(grid[newi][newj] == 1)
                    {
                        grid[newi][newj] = 2;
                        q.add(new int[]{newi, newj});
                        total++;
                    }
                }
                else
                {
                    outOfGrid = true;
                }
            }
        }
        if(outOfGrid)
            return 0;
        return total;
    }
    private boolean isValid(int i, int j, int[][] grid)
    {
        if(i < 0 || j<0 || i >= grid.length || j >= grid[0].length)
            return false;
        return true;
    }
}
