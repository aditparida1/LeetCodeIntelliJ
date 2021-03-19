package org.leetcode;
import java.util.*;

public class ColoringBorder1034
{
    public int[][] colorBorder(int[][] grid, int r, int c, int color)
    {
        if(grid == null || grid.length == 0|| grid[0].length == 0)
            return grid;
        if(r < 0 || r >= grid.length || c < 0 || c > grid[0].length)
        {
            return  grid;
        }
        List<int[]> list = new ArrayList<>();
        Boolean[][] seen = new Boolean[grid.length][grid[0].length];
        seen[r][c] = true;
        int[][] dirs = new int[][]{
                {1,0}, {-1, 0}, {0, 1}, {0, -1}
        };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        int currCol = grid[r][c];
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            boolean isBorder = false;
            currCol = grid[curr[0]][curr[1]];
            for(int[] dir: dirs)
            {
                int newi = curr[0] + dir[0];
                int newj = curr[1] + dir[1];
                if(isValid(newi, newj, grid))
                {
                    if(grid[newi][newj] == currCol)
                    {
                        if(!seen[newi][newj] || seen[newi][newj] == null)
                        {
                            q.add(new int[]{newi, newj});
                            seen[newi][newj] = true;
                        }
                    }
                    else
                    {
                        isBorder = true;
                    }
                }
                else
                {
                    isBorder = true;
                }
            }
            if(isBorder)
            {
                list.add(curr);
            }
        }
        for (int[] pos: list)
        {
            grid[pos[0]][pos[1]] = color;
        }
        return grid;
    }
    private boolean isValid(int i, int  j, int[][] grid)
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return false;
        return true;
    }
}
