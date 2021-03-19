package org.leetcode;

public class BSTtoGreaterSumTree1038
{
    public TreeNode bstToGst(TreeNode root)
    {
        getSum(root, 0);
//        traverse(root);
        return root;
    }
    private int getSum(TreeNode node, int greater)
    {
        if(node == null)
            return 0;
        int right = getSum(node.right, greater);
        int temp = node.val;
        node.val += right + greater;
        int left = getSum(node.left, node.val);
        return temp + left + right;
    }
}
