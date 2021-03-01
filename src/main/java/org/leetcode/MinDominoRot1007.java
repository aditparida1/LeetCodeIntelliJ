package org.leetcode;
import java.util.*;

public class MinDominoRot1007
{
    public int minDominoRotations(int[] arr1, int[] arr2)
    {
        int result = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> comm = new HashMap<>();
        for (int i = 0; i < arr1.length; ++i)
        {
            if(!map1.containsKey(arr1[i]))
            {
                map1.put(arr1[i], 0);
            }
            map1.put(arr1[i], map1.get(arr1[i]) + 1);

            if(!map2.containsKey(arr2[i]))
            {
                map2.put(arr2[i], 0);
            }

            map2.put(arr2[i], map2.get(arr2[i]) + 1);
            if(arr1[i] == arr2[i])
            {
                if(!comm.containsKey(arr1[i]))
                {
                    comm.put(arr1[i], 0);
                }
                comm.put(arr1[i], comm.get(arr1[i]) + 1);
            }
        }
        Set<Integer> cand = new HashSet<>();

        for (int key: map1.keySet())
        {
            int total = 0;
            total += map1.get(key);
            if(map2.containsKey(key))
            {
                total += map2.get(key);
            }
            if(comm.containsKey(key))
            {
                total -= comm.get(key);
            }
            if(total == arr1.length)
            {
                cand.add(key);
            }
        }
        for(int key: map2.keySet())
        {
            int total = 0;
            total += map2.get(key);
            if(map1.containsKey(key))
            {
                total += map1.get(key);
            }
            if(comm.containsKey(key))
            {
                total -= comm.get(key);
            }
            if(total == arr2.length)
            {
                cand.add(key);
            }
        }
        int globalMin = Integer.MAX_VALUE;
        for(int key: cand)
        {
            int first = 0;
            if(map1.containsKey(key))
            {
                first = map1.get(key);
            }
            int sec = 0;
            if(map2.containsKey(key))
            {
                sec = map2.get(key);
            }
            int max = Math.max(first, sec);
            int rem = arr1.length - max;
            globalMin = Math.min(globalMin, rem);
        }
        return globalMin < Integer.MAX_VALUE ? globalMin : -1;
    }
}
