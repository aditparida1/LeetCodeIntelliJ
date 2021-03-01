package org.leetcode;
import java.util.*;
public class SmallestStringfromLeaf988
{
    String smallestSoFar = null;
    Map<Integer, Character> map;
    public String smallestFromLeaf(TreeNode root)
    {
        map = new HashMap<>();
        for (int i = 0; i < 26; ++i)
        {
            map.put(i, (char)('a' + i));
        }
        this.smallestSoFar = null;
        traverse(root, new StringBuilder());
        return smallestSoFar;
    }
    private void traverse(TreeNode node, StringBuilder sb)
    {
        sb.append(map.get(node.val));
        if(node.left == null && node.right == null)
        {
            String temp = sb.reverse().toString();
            if(smallestSoFar == null)
            {
                smallestSoFar = temp;
            }
            else
            {
                if(temp.compareTo(smallestSoFar) < 0)
                {
                    smallestSoFar = temp;
                }
            }
            sb.reverse();

        }
        else
        {
            if(node.left != null)
            traverse(node.left, sb);
            if(node.right != null)
            traverse(node.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
