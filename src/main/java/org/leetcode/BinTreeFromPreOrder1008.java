package org.leetcode;

import java.util.Stack;

public class BinTreeFromPreOrder1008
{
    public TreeNode bstFromPreorder(int[] preorder)
    {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = null;
        for(int i = 0; i < preorder.length; i++)
        {
            if(st.isEmpty())
            {
                st.push(new TreeNode(preorder[i]));
                if(i == 0)
                {
                    root = st.peek();
                }
            }
            else
            {
                if(st.peek().val > preorder[i])
                {
                    st.peek().left = new TreeNode(preorder[i]);
                    st.push(st.peek().left);
                }
                else
                {
                    TreeNode curr = null;
                    while(!st.isEmpty() && st.peek().val < preorder[i])
                    {
                        curr = st.pop();
                    }
                    curr.right = new TreeNode(preorder[i]);
                    st.push(curr.right);
                }
            }
        }
        return root;
    }
}
