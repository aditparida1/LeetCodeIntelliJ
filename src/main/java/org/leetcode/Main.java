package org.leetcode;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {

    }
    public int[] getProductExcetSelf(int[] input)
    {
        int[] result = new int[input.length];
        // initialize the prefix and suffix products
        for(int i = input.length - 1; i >= 0; --i)
        {
            if(i == input.length - 1)
            {
                result[i] = input[i];
            }
            else
            {
                result[i] = result[i + 1] * input[i];
            }
        }

        //Populate result array
        int currPrefixProd = 1;
        for(int i = 0; i < result.length; ++i)
        {
            int prefixIndex = i - 1;
            int suffixIndex = i + 1;
            int currProd = 1;
            if(prefixIndex >= 0)
            {
                currProd *= currPrefixProd;
            }
            if(suffixIndex < result.length)
            {
                currProd *= result[suffixIndex];
            }
            currPrefixProd *= input[i];
            result[i] = currProd;
        }
        return result;
    }
}
