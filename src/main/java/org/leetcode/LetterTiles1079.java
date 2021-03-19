package org.leetcode;
import java.util.*;

public class LetterTiles1079
{
    int total;
    StringBuilder sb;
    public int numTilePossibilities(String tiles)
    {
        total = 0;

        Map<Character, Integer> map = new HashMap<>();
        sb = new StringBuilder();
        for(int i = 0; i < tiles.length(); ++i)
        {
            if(!map.containsKey(tiles.charAt(i)))
            {
                map.put(tiles.charAt(i), 0);
            }
            map.put(tiles.charAt(i), map.get(tiles.charAt(i)) + 1);
        }

        for (int i = 1 ; i <= tiles.length(); ++i)
        {
            traverse(map, i, 0);
        }

        return total;
    }
    private void traverse(Map<Character, Integer> map, int maxSize, int currSize)
    {
        if(currSize == maxSize)
        {
            total++;
            return;
        }
        for(char c: map.keySet())
        {
            if(map.get(c) > 0)
            {
                sb.append(c);
                map.put(c, map.get(c - 1));
                traverse(map, maxSize, currSize + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
