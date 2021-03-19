package org.leetcode;
import java.util.*;

public class kLenSubStringNoRepeatedChars1100
{
    public int numKLenSubstrNoRepeats(String ip, int k)
    {
        int count = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> set = new HashMap<>();
        set.put(ip.charAt(left), left);
        while(right < ip.length())
        {
            if(right - left + 1 < k)
            {
                right++;
                if(right >= ip.length())
                    break;
                if(set.containsKey(ip.charAt(right)))
                {
                    int newLeft = set.get(ip.charAt(right)) + 1;
                    while(left < newLeft)
                    {
                        set.remove(ip.charAt(left));
                        left++;
                    }
                    left = newLeft;
                    set.put(ip.charAt(right), right);
                }
                else
                {
                    set.put(ip.charAt(right), right);
                }
            }
            else
            {
                count++;
                set.remove(ip.charAt(left++));
            }
        }
        return count;
    }
}
