package org.leetcode;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int[] res = new FreqofSmallestCharacter1170().numSmallerByFrequency(new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"});
        for(int i = 0; i < res.length; ++i)
        System.out.println(res[i]);
    }
}
