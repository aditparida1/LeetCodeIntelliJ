package org.leetcode;
import java.util.*;

public class DeleteNodesinBinTreeAndRetForest1110
{
    List<TreeNode> ls;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete)
    {
        ls = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int i : to_delete)
        {
            toDelete.add(i);
        }
        TreeNode ret = markForDelete(root, toDelete);
        if(ret!=null)
            ls.add(ret);
        return  ls;
    }

    private TreeNode markForDelete(TreeNode root, Set<Integer> toDelete)
    {
        if(root == null)
            return null;
        root.left = markForDelete(root.left, toDelete);
        root.right = markForDelete(root.right, toDelete);

        if(toDelete.contains(root.val))
        {
            if(root.left != null)
            ls.add(root.left);
            if(root.right != null)
            ls.add(root.right);
            return null;
        }
        else
        {
            return root;
        }

    }

}
