package org.leetcode;


public class Main
{
    public static void main(String[] args)
    {
        int[][] mat = new int[][]{{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};

        System.out.println(new EarliestMomentofFriendship1101().earliestAcq(mat, 6));

    }
}
