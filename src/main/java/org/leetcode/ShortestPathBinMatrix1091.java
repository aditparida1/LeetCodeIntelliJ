package org.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinMatrix1091
{
    public int shortestPathBinaryMatrix(int[][] grid)
    {
        if(grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        int len = 1;
        q.add(new int[]{0, 0});
        grid[0][0] = 2;
        int[][] directions = new int[][]
                {
                        {1, 0}, {-1, 0},
                        {0, 1}, {0, -1},
                        {1, 1}, {-1, -1},
                        {1, -1}, {-1, 1}
                };
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size > 0)
            {
                int[] curr = q.poll();
                if(curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1)
                    return len;
                for(int[] dir: directions)
                {
                    int newi = curr[0] + dir[0];
                    int newj = curr[1] + dir[1];
                    if(isValid(newi, newj, grid) && grid[newi][newj] == 0)
                    {
                        grid[newi][newj] = 2;
                        q.add(new int[]{newi, newj});
                    }
                }
                size--;
            }
            len++;
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] mat)
    {
        if(i <0 || j < 0 || i >= mat.length || j >= mat[0].length)
            return false;
        return true;
    }
}
