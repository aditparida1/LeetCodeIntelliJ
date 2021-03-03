package org.leetcode;

public class NextGreaterNodeLinkedList1019
{
    public int[] nextLargerNodes(ListNode head)
    {
        int[] res = new int[getLen(head)];
        int[] list = new int[res.length];
        int[] nextIndex = new int[res.length];
        res[res.length - 1] = nextIndex[nextIndex.length - 1] = -1;
        putRes(list, head);
        for (int i = list.length - 2; i >= 0; --i)
        {
            res[i] = find(list[i], list, nextIndex, i + 1);
            nextIndex[i] = res[i];

        }
        for(int i = 0; i < res.length; ++i)
        {
            if(res[i] == -1)
                res[i] = 0;
            else
            {
                res[i] = list[res[i]];
            }
        }
        return res;
    }
    int find(int key, int[] list, int[] nextIdx, int curr)
    {
        if(curr == -1)
            return -1;
        if(key < list[curr])
            return curr;
        if(key >= list[curr])
            return find(key, list, nextIdx, nextIdx[curr]);
        return nextIdx[curr];
    }
    void putRes(int[] list, ListNode head)
    {
        for (int i = 0; i < list.length; ++i)
        {
            list[i] = head.val;
            head = head.next;
        }
    }
    int getLen(ListNode head)
    {
        int len = 0;
        while(head != null)
        {
            head = head.next;
            len++;
        }
        return len;
    }
}


class ListNode
{
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

