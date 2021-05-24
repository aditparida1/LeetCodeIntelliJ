package org.leetcode;
import java.util.*;

public class ReverseSubStringWithineachPara1190
{
    public String reverseParentheses(String s)
    {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < s.length())
        {
            if(s.charAt(index) == '(')
            {
                int start = index;
                int count = 1;
                index++;
                while(count > 0)
                {
                    if(s.charAt(index) == '(')
                    {
                        count++;
                    }
                    else if(s.charAt(index) == ')')
                    {
                        count--;
                    }
                    index++;
                }
                String sub = s.substring(start + 1, index - 1);
                sb.append(process(sub));
            }
            else
            {
                sb.append(s.charAt(index));
                index++;
            }
        }

        return sb.toString();
    }
    private String process(String s)
    {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while(index < s.length())
        {
            if(s.charAt(index) == '(')
            {
                int start = index;
                int count = 1;
                index++;
                while(count > 0)
                {
                    if(s.charAt(index) == '(')
                    {
                        count++;
                    }
                    else if(s.charAt(index) == ')')
                    {
                        count--;
                    }
                    index++;
                }
                String sub = s.substring(start + 1, index - 1);
                sb.append(process(sub));
            }
            else
            {
                sb.append(s.charAt(index));
                index++;
            }
        }
        return sb.reverse().toString();
    }
}
