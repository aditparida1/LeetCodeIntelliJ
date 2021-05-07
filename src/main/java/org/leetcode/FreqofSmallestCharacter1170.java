package org.leetcode;
import java.util.*;

public class FreqofSmallestCharacter1170
{
    public int[] numSmallerByFrequency(String[] queries, String[] words)
    {
        int[] result = new int[queries.length];
        int[] fWords = new int[words.length];
        int[] fQueries = new int[queries.length];
        for(int i = 0; i < words.length; ++i)
        {
            fWords[i] = calculateFreq(words[i]);
        }
        for(int i = 0; i < queries.length; ++ i)
        {
            fQueries[i] = calculateFreq(queries[i]);
        }
        Arrays.sort(fWords);
        for(int i = 0; i < fQueries.length; ++i)
        {
            int pos = binSearch(fQueries[i], fWords);
            if(pos == -1)
            {
                result[i] = 0;
            }
            else
            {
                result[i] = fWords.length - pos;
            }
        }
        return result;
    }
    private int binSearch(int key, int[] input)
    {
        int left = 0; int right = input.length - 1;

        while(left <= right)
        {
            int mid = left + right;
            mid /= 2;
            if(key >= input[mid])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        if(right == -1)
            return -1;
        return left;
    }
    private int calculateFreq(String word)
    {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        int count = 0;
        char currChar = charArray[0];
        for(int i = 0; i < charArray.length; ++i)
        {
            if(charArray[i] != currChar)
                break;
            else
                count++;
        }
        return count;
    }
}
