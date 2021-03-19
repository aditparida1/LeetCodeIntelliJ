package org.leetcode;

public class DepthSum
{
    public int overallSum;
    public int getSum(TreeNode root)
    {
        overallSum = 0;
        traverse(root, 0);
        return overallSum;
    }
    private int[] traverse(TreeNode node, int level)
    {
        if(node == null)
            return new int[]{0,0};
        int[] left = traverse(node.left, level + 1);
        int[] right = traverse(node.right, level + 1);
        int[] re = new int[]{0,0};
        re[0] += left[0] + right[0] + 1;
        re[1] = left[1] + right[1]  + level;
        overallSum =overallSum + left[1] + right[1] - (level * (left[0] + right[0]));
        return re;
    }
}
