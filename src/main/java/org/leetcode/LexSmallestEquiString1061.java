package org.leetcode;
import java.util.*;


public class LexSmallestEquiString1061
{
    public String smallestEquivalentString(String A, String B, String S)
    {
        StringBuilder sb = new StringBuilder();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < S.length(); ++i)
        {
            char curr = S.charAt(i);
            if(!map.containsKey(curr))
            {
                sb.append(curr);
            }
            else
            {
                sb.append(getMin(curr, map));
            }
        }
        return sb.toString();
    }
    private char getMin(Character ip, Map<Character, Set<Character>> map)
    {
        char min = ip;
        Queue<Character> q = new LinkedList<>();
        Set<Character> seen = new HashSet<>();
        seen.add(min);
        q.add(min);

        while(!q.isEmpty())
        {
            char curr = q.poll();

            Set<Character> neighs = map.get(curr);

            for(char neigh: neighs)
            {
                if(!seen.contains(neigh))
                {
                    seen.add(neigh);
                    q.add(neigh);
                    min = (min < neigh) ? min : neigh;
                }
            }

        }

        return min;
    }
    private Map<Character, Set<Character>> getGraph(String ip1, String ip2)
    {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < ip1.length(); ++i)
        {
            if(!map.containsKey(ip1.charAt(i)))
            {
                map.put(ip1.charAt(i), new HashSet<>());
            }
            if(!map.containsKey(ip2.charAt(i)))
            {
                map.put(ip2.charAt(i), new HashSet<>());
            }
            map.get(ip1.charAt(i)).add(ip2.charAt(i));
            map.get(ip2.charAt(i)).add(ip1.charAt(i));
        }
        return map;
    }
}
