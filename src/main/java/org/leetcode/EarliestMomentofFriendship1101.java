package org.leetcode;
import java.util.*;
public class EarliestMomentofFriendship1101
{
    public int earliestAcq(int[][] logs, int n)
    {
        if(n == 0)
            return 0;
        Map<Integer, UnionNode> map = new HashMap<>();
        for (int i = 0; i < n; ++i)
        {
            var node = new UnionNode();
            node.parent = node;
            map.put(i, node);
        }

        Arrays.sort(logs, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {

                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < logs.length; ++i)
        {
            UnionNode first = map.get(logs[i][1]);
            UnionNode second = map.get(logs[i][2]);
            var parent1 = first.findParent();
            var parent2 = second.findParent();
            if(parent1 != parent2)
            {
                parent1.rank += parent2.rank;
                parent2.parent = parent1;
                if(parent1.rank == n || parent2.rank == n)
                    return logs[i][0];
            }
        }

        return -1;
    }
}

class UnionNode
{
    UnionNode parent;
    int rank = 1;
    public UnionNode findParent()
    {
        UnionNode node = this;
        while(node.parent != node)
        {
            node = node.parent;
        }
        return node;
    }

}