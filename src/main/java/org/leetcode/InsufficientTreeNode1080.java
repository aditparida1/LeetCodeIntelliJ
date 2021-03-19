package org.leetcode;

public class InsufficientTreeNode1080
{
    public TreeNode sufficientSubset(TreeNode root, int limit)
    {
        return traverse(root, 0, limit);
    }
    private TreeNode traverse(TreeNode root, int currSum, int limit)
    {
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
        {
            if(currSum + root.val < limit)
            {
                return null;
            }
            else
            {
                return root;
            }
        }
        TreeNode left = traverse(root.left, currSum+root.val, limit);
        TreeNode right = traverse(root.right, currSum+root.val, limit);
        root.left = left;
        root.right = right;
        if(left == null && right == null)
            return null;
        else
            return root;

    }
}
