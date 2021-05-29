package org.leetcode;
import java.util.*;

public class QueenAttackKing1222
{
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king)
    {
        List<List<Integer>> result = new ArrayList<>();
        int[][] grid = new int[8][8];

        for(int[] queen: queens)
        {
            grid[queen[0]][queen[1]] = 1;
        }
        int[][] dirs = new int[][]{
                {1,1}, {1, -1},
                {-1, 1}, {-1, -1},
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1}
        };
        for(int[] dir: dirs)
        {
            int[] curr = new int[]{king[0], king[1]};
            while(isValid(curr[0], curr[1]))
            {
                if(grid[curr[0]][curr[1]] == 1)
                {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(curr[0]);
                    ls.add(curr[1]);
                    result.add(ls);
                    break;
                }
                curr[0] += dir[0];
                curr[1] += dir[1];
            }
        }
        return result;
    }
    private boolean isValid(int i, int j)
    {
        if(i < 0 || j < 0 || i > 7 || j > 7)
        {
            return false;
        }
        return true;
    }
}
