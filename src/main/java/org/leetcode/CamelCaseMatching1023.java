package org.leetcode;
import java.util.*;

public class CamelCaseMatching1023
{
    public List<Boolean> camelMatch(String[] queries, String pattern)
    {
        List<Boolean> result = new ArrayList<>();

        for(String word: queries)
        {
            result.add(doesMatchPattern(word, pattern));
        }

        return result;
    }
    private boolean doesMatchPattern(String word, String pattern)
    {
        int wordPos = 0;
        int patternPos = 0;

        while(wordPos < word.length())
        {
            if(word.charAt(wordPos) == pattern.charAt(patternPos))
            {
                wordPos++;
                patternPos++;
            }
            else if(word.charAt(wordPos) >= 'a' && word.charAt(wordPos) <= 'z')
            {
                wordPos++;
            }
            else
            {
                return false;
            }
        }
        if(wordPos == word.length() && patternPos == pattern.length())
            return true;
        return false;
    }
}
