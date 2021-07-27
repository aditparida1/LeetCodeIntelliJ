package org.leetcode;
import java.util.*;

public class WordLadder127
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        int level = 0;
        Set<String> words = new HashSet<>();
        for(String word: wordList)
        {
            words.add(word);
        }
        if(!words.contains(endWord))
        {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size > 0)
            {
                String curr = q.poll();
                if(curr.equals(endWord))
                    return level + 1;
                char[] currChar = curr.toCharArray();
                for(int i = 0; i < currChar.length; ++i)
                {
                    char temp = currChar[i];
                    for(int letter = 0; letter < 26; ++letter)
                    {
                        currChar[i] = (char)('a' + letter);
                        if(words.contains(new String(currChar)) && !visited.contains(new String(currChar)))
                        {
                            visited.add(new String(currChar));
                            q.offer(new String(currChar));
                        }
                    }
                    currChar[i] = temp;
                }
                size--;
            }
            level++;
        }

        return 0;
    }
}
