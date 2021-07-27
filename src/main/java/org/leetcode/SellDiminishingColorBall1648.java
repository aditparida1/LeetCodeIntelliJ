package org.leetcode;
import java.util.*;

public class SellDiminishingColorBall1648
{
    public int maxProfit(int[] inventory, int orders)
    {
        int mod = 1_000_000_007;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> inventory[b] - inventory[a]);
        for(int i = 0; i < inventory.length; ++i)
        {
            pq.offer(i);
        }
        int total = 0;
        while(orders > 0)
        {
            int index = pq.poll();
            total += inventory[index];
            inventory[index]--;
            if(inventory[index] > 0)
                pq.offer(index);
        }
        return total;
    }
}
