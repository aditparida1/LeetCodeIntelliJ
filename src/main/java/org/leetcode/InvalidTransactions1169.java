package org.leetcode;
import java.util.*;
public class InvalidTransactions1169
{
    public List<String> invalidTransactions(String[] transactions)
    {
        List<String> result = new ArrayList<>();
        int[] flags = new int[transactions.length];
        Map<String, List<Integer>> map = new HashMap<>();
        List<String[]> transactionsLs = new ArrayList<>();

        for(String transaction: transactions)
        {
            String[] split = transaction.split(",");
            transactionsLs.add(split);
        }
        for(int i = 0; i < transactionsLs.size(); ++i)
        {
            String[] transaction = transactionsLs.get(i);
            if(!map.containsKey(transaction[0]))
            {
                map.put(transaction[0], new ArrayList<>());
            }
            map.get(transaction[0]).add(i);
        }
        for(String key: map.keySet())
        {
            List<Integer> val = map.get(key);

            Collections.sort(val, new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    String[] trans1 = transactionsLs.get(o1);
                    String[] trans2 = transactionsLs.get(o2);
                    int a = Integer.parseInt(trans1[1]);
                    int b = Integer.parseInt(trans2[1]);
                    return a - b;
                }
            });
            processTransactions(val, transactionsLs, flags);
        }
        for(int i = 0; i < transactionsLs.size(); ++i)
        {
            if(flags[i] == -1)
                result.add(transactions[i]);
        }
        return result;
    }
    private void processTransactions(List<Integer> transactions, List<String[]> transactionLs, int[] flags)
    {
        for (int i = 0; i < transactions.size(); ++i)
        {
            int currTime = Integer.parseInt(transactionLs.get(transactions.get(i))[1]);
            String currState = transactionLs.get(transactions.get(i))[3];
            int currAmt = Integer.parseInt(transactionLs.get(transactions.get(i))[2]);
            if(currAmt > 1000)
                flags[transactions.get(i)] = -1;
            for(int j = i - 1; j >= 0 && currTime <= Integer.parseInt(transactionLs.get(transactions.get(j))[1]) + 60; --j)
            {
                String otherState = transactionLs.get(transactions.get(j))[3];
                if(!currState.equals(otherState))
                {
                    flags[transactions.get(i)] = -1;
                    flags[transactions.get(j)] = -1;
                }
            }
        }
    }
}
