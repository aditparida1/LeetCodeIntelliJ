package org.leetcode;
import java.util.*;

public class RobotBoundedbyCircle1041
{
    public boolean isRobotBounded(String instructions)
    {
        //starting position
        int x = 0; int y = 0;
        //all directions allowed
        int [][] dirs = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        //initial direction is north
        int currDir = 0;
        //iterate through all the instructions and see if it ends at north
        for(int i = 0; i < instructions.length(); ++i)
        {
            if(instructions.charAt(i) == 'L')
            {
                currDir = (currDir + 3) % 4;
            }
            else if(instructions.charAt(i) == 'R')
            {
                currDir = (currDir + 1) % 4;
            }
            else
            {
                x += dirs[currDir][0];
                y += dirs[currDir][1];
            }
        }
        return ((x == 0 && y ==0) || currDir != 0);
    }
}
