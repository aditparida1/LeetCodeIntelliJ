package org.leetcode;
import java.util.*;

public class ConcatenatedWords472
{
    public List<String> findAllConcatenatedWordsInADict(String[] words)
    {
        List<String> result = new ArrayList<>();
        Set<String> wordsSet = new HashSet<>();
        Set<String> dpWords = new HashSet<>();
        List<String> wordsList = new ArrayList<>();
        for(String word: words)
        {
            wordsSet.add(word);
            wordsList.add(word);
        }
        Collections.sort(wordsList, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        for(int i = 0; i < words.length; ++i)
        {
            if(isConcat(wordsList.get(i), 0, new HashMap<>(), wordsSet, dpWords))
            {
                result.add(wordsList.get(i));
            }
        }
        return result;
    }
    private boolean isConcat(String ip, int index, HashMap<Integer, Boolean> dp, Set<String> words, Set<String> dpWords)
    {
        if(index >= ip.length())
            return true;
        if(dp.containsKey(index))
            return dp.get(index);
        if(dpWords.contains(ip.substring(index)))
            return true;
        for(int i = index + 1; i <= ip.length(); ++i)
        {
            if(index == 0 && i == ip.length())
                continue;
            String sub = ip.substring(index, i);
            if(words.contains(sub) || dpWords.contains(sub))
            {
                boolean isPoss = isConcat(ip, i, dp, words, dpWords);
                if(isPoss)
                {
                    dpWords.add(sub);
                    return true;
                }

            }
        }
        dp.put(index, false);
        return false;
    }
}
