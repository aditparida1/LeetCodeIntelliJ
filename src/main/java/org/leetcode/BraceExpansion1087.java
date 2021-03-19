package org.leetcode;
import java.util.*;

public class BraceExpansion1087
{
    public String[] expand(String s)
    {
        ArrayList<ArrayList<Character>> ip = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i)
        {
            if(s.charAt(i) == '}' || s.charAt(i) == ',')
                continue;
            ip.add(new ArrayList<>());
            if(s.charAt(i) == '{')
            {
                i++;
                while(s.charAt(i) != '}')
                {
                    ip.get(ip.size() - 1).add(s.charAt(i));
                    i++;
                }
            }
            else
            {
                ip.get(ip.size() - 1).add(s.charAt(i));
            }
        }
        List<String> res = new ArrayList<>();
        traverse(ip, 0, new StringBuilder(), res);
        Collections.sort(res);
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); ++i)
        {
            result[i] = res.get(i);
        }
        return result;
    }
    private void traverse(ArrayList<ArrayList<Character>> ip, int idx, StringBuilder sb, List<String> res)
    {
        if(idx >= ip.size())
        {
            res.add(sb.toString());
            return;
        }
        for(char c: ip.get(idx))
        {
            sb.append(c);
            traverse(ip, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
