package org.leetcode;
import java.util.*;
public class FlipBinaryTreetoMatchPreOrder971
{
    int idx = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage)
    {
        //if current is not the first one in voyage then something is wrong
        //it either needs flip or it is impossible
        List<Integer> res = new ArrayList<>();
        idx = 0;
        if(traverse(root, voyage, res))
        {
            return res;
        }
        res.clear();
        res.add(-1);
        return res;
    }
    private boolean traverse(TreeNode root, int[] voyage, List<Integer> ls)
    {
        if(root == null)
            return true;

        if(root.val != voyage[idx++])
            return false;
        if(idx + 1 < voyage.length && root.left != null &&
                root.left.val != voyage[idx + 1])
        {
            ls.add(root.val);
            if(!traverse(root.right, voyage, ls))
                return false;
            if(!traverse(root.left, voyage, ls))
                return false;
        }
        else
        {
            if(!traverse(root.left, voyage, ls))
                return false;
            if(!traverse(root.right, voyage, ls))
                return false;
        }
        return true;
    }
}
