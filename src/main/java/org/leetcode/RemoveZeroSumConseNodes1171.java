package org.leetcode;
import java.util.*;

public class RemoveZeroSumConseNodes1171
{
    public ListNode removeZeroSumSublists(ListNode head)
    {
        int size = size(head);
        int[] nums = new int[size];
        for(int i = 0; i < size; ++i)
        {
            nums[i] = head.val;
            head = head.next;
        }
        List<int[]> intervals = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        for(int i = 0; i < nums.length; ++i)
        {
            currSum += nums[i];
            if(map.containsKey(currSum))
            {
                int lastIdx = map.get(currSum);
                int[] interval = {lastIdx + 1, i};
                for(int start = interval[0]; start <= interval[1]; start++)
                {
                    set.add(start);
                }
            }
            else
            {
                map.put(currSum, i);
            }
        }
        ListNode newList = null;
        ListNode temp = null;
        for(int i = 0; i < nums.length; ++i)
        {
            if(!set.contains(i))
            {
                if(newList == null)
                {
                    newList = new ListNode(nums[i]);
                    temp = newList;
                }
                else
                {
                    temp.next = new ListNode(nums[i]);
                    temp = temp.next;
                }
            }
        }
        return newList;
    }
    public int size(ListNode head)
    {
        int count = 0;
        while(head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
}
