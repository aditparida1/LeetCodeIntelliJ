package org.leetcode;
import java.util.*;

public class PrevPermOneSwap1053
{
    public int[] prevPermOpt1(int[] arr)
    {
        int found = -1;
        for (int i = arr.length - 2; i >= 0; --i)
        {
            if(arr[i] > arr[i + 1])
            {
                found = i;
                break;
            }
        }
        if(found == -1)
            return arr;

        int smaller = found + 1;

        for(int i  = found + 1; i < arr.length; ++i)
        {
            if(arr[i] < arr[found] && arr[i] > arr[smaller])
            {
                smaller = i;
            }
        }
        int temp = arr[found];
        arr[found] = arr[smaller];
        arr[smaller] = temp;
        return arr;
    }
}
