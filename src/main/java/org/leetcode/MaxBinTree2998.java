package org.leetcode;
import com.sun.source.tree.Tree;

import java.util.*;
public class MaxBinTree2998
{
    public TreeNode insertIntoMaxTree(TreeNode root, int val)
    {
        List<TreeNode> ls = new ArrayList<>();
        inOrder(root, ls);
        ls.add(new TreeNode(val));
        return constructMaxTree(0, ls.size() - 1, ls);
    }
    private void inOrder(TreeNode node, List<TreeNode> ls)
    {
        if(node != null)
        {
            inOrder(node.left, ls);
            ls.add(node);
            inOrder(node.right, ls);
        }
    }
    private TreeNode constructMaxTree(int start, int end, List<TreeNode> ls)
    {
        if(start > end)
            return null;
        int idx = findMax(ls, start, end);
        TreeNode curr = ls.get(idx);
        curr.left = constructMaxTree(start, idx - 1, ls);
        curr.right = constructMaxTree(idx + 1, end, ls);
        return curr;
    }
    private int findMax(List<TreeNode> ls, int start, int end)
    {
        int tn = -1;
        for (int i = start; i <= end; ++i)
        {
            if(tn == -1)
            {
                tn = i;
            }
            else if(ls.get(tn).val < ls.get(i).val)
            {
                tn = i;
            }
        }
        return tn;
    }
}
