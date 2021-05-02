package org.leetcode;
import java.util.*;

public class Largest1BoardedSq1139
{
    public int largest1BorderedSquare(int[][] grid)
    {
        HolderOnes1139[][] matrix = new HolderOnes1139[grid.length][grid[0].length];
        preprocess(grid, matrix);
        int max = 0;
        int maxSize = Math.max(grid.length, grid[0].length);
        for (int size = 2; size <= maxSize; ++ size)
        {
            for(int i = 0; i <= grid.length - size; ++i)
            {
                for(int j = 0; j <= grid[0].length - size; ++j)
                {
                    if(grid[i][j] != 0)
                    {
                        if(matrix[i][j].right >= size && matrix[i][j].down >= size)
                        {
                            int newi = i + size - 1;
                            int newj = j + size - 1;
                            if(matrix[newi][j].right >= size && matrix[i][newj].down >= size)
                            {
                                max = Math.max(max, size);
                            }
                        }
                    }
                }
            }
        }
        return max*max;
    }
    private void preprocess(int[][] grid, HolderOnes1139[][] matrix)
    {
        for (int i =0; i < grid.length; ++i)
        {
            for (int j = 0; j < grid[0].length; ++j)
            {
                if(grid[i][j] == 1)
                {
                    matrix[i][j] = new HolderOnes1139(1,1,1,1);
                }
                else
                {
                    matrix[i][j] = new HolderOnes1139(0,0,0,0);
                }
            }
        }
        for(int i = grid.length - 1; i >= 0; i--)
        {
            for(int j = grid[0].length - 2; j >= 0; j--)
            {
                if(matrix[i][j].right != 0)
                {
                    matrix[i][j].right += matrix[i][j+1].right;
                }
            }
        }
        for (int j = grid[0].length - 1; j >=0; --j)
        {
            for(int i = grid.length - 2; i >= 0; i--)
            {
                if(matrix[i][j].down != 0)
                {
                    matrix[i][j].down += matrix[i + 1][j].down;
                }
            }
        }
    }

}
class HolderOnes1139
{
    //int left;
    int right;
    int down;
    //int up;
    public HolderOnes1139(int left, int right, int up, int down)
    {
        this.down = down;
        this.right = right;
    }
}
