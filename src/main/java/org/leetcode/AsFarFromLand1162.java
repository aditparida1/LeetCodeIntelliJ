package org.leetcode;
import java.util.*;
public class AsFarFromLand1162
{
    public int maxDistance(int[][] grid)
    {
        //start from lands
        for (int i = 0; i < grid.length; ++i)
        {
            for(int j = 0; j < grid[0].length; ++j)
            {
                grid[i][j] *= -1;
            }
        }
        for (int i = 0; i < grid.length; ++i)
        {
            for(int j = 0; j < grid[0].length; ++j)
            {
                if(grid[i][j] == -1)
                {
                    bfs(grid, new int[]{i,j});
                }
            }
        }
        int max = -1;
        for (int i = 0; i < grid.length; ++i)
        {
            for(int j = 0; j < grid[0].length; ++j)
            {
                if(grid[i][j] > 0)
                {
                    max = Math.max(max, grid[i][j]);
                }
            }
        }


        return max;
    }
    //traverse all possible water
    private void bfs(int[][] grid, int[] start)
    {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0},{-1,0}, {0, 1}, {0, -1}};
        int level = 1;
        Boolean[][] visited = new Boolean[grid.length][grid[0].length];
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size > 0)
            {
                int[] curr = q.poll();
                for(int[] dir: dirs)
                {
                    int newi = curr[0] + dir[0];
                    int newj = curr[1] + dir[1];
                    if(isValid(grid, newi, newj) && visited[newi][newj] == null && grid[newi][newj] >= 0)
                    {
                        visited[newi][newj] = true;
                        if(grid[newi][newj] == 0 || grid[newi][newj] > level)
                        {
                            grid[newi][newj] = level;
                        }
                        q.add(new int[]{newi, newj});
                    }
                }
                size--;
            }
            level++;
        }
    }
    private boolean isValid(int[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
        {
            return false;
        }
        return true;
    }
}
