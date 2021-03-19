package org.leetcode;
import java.util.*;

public class PartitionArrayMaxSum1043
{
    //this is wrong.. I understood it wrong

    public int maxSumAfterPartitioning(int[] arr, int k)
    {
        int sum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>((o1, o2) -> o2 - o1);
        for (int i =0; i < k; ++i)
        {
            //1,15,7,9,2,5,10
            if(!map.containsKey(arr[i]))
            {
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        sum += map.firstKey();

        for (int i = 1; i < arr.length; ++i)
        {
            int toRemove = i - k;

            if(toRemove > 0)
            {
                map.put(arr[toRemove], map.get(arr[toRemove]) - 1);
                if(map.get(arr[toRemove]) == 0)
                {
                    map.remove(arr[toRemove]);
                }
            }
            int toAdd = i + k - 1;
            if(toAdd < arr.length)
            {
                if(!map.containsKey(toAdd))
                {
                    map.put(arr[toAdd], 0);
                }
                map.put(arr[toAdd], map.get(arr[toAdd]) + 1);
            }
            sum += map.firstKey();
        }

        return sum;

    }
}
