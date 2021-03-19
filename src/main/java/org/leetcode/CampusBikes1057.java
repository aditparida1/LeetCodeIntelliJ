package org.leetcode;
import java.util.*;

public class CampusBikes1057
{
    public int[] assignBikes(int[][] workers, int[][] bikes)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                int disto1 = getDistance(workers[o1[0]], bikes[o1[1]]);
                int disto2 = getDistance(workers[o2[0]], bikes[o2[1]]);
                if(disto1 < disto2)
                {
                    return -1;
                }
                else if(disto1 == disto2)
                {
                    if(o1[0] < o2[0])
                    {
                        return -1;
                    }
                    else if(o1[0] == o2[0])
                    {
                        if(o1[1] < o2[1])
                        {
                            return -1;
                        }
                        else
                        {
                            return 1;
                        }
                    }
                    else
                    {
                        return 1;
                    }
                }
                return 1;
            }
        });

        for (int i = 0; i < workers.length; ++i)
        {
            for (int j = 0; j < bikes.length; ++j)
            {
                pq.add(new int[]{i, j});
            }
        }
        int[] res = new int[workers.length];
        Set<Integer> usedWorkers = new HashSet<>();
        Set<Integer> usedBikes = new HashSet<>();
        while(usedWorkers.size() != workers.length)
        {
            int[] currPair = pq.poll();
            if(!usedWorkers.contains(currPair[0]) && !usedBikes.contains(currPair[1]))
            {
                usedWorkers.add(currPair[0]);
                usedBikes.add(currPair[1]);
                res[currPair[0]] = currPair[1];
            }
        }
        return res;
    }

    private void fillDistance(int[][] dist, int[][] workers, int[][] bikes)
    {
        for (int i = 0 ; i < dist.length; ++i)
        {
            for(int j = 0; j < dist[0].length; ++j)
            {
                dist[i][j] = getDistance(workers[i], bikes[j]);
            }
        }
    }

    private int getDistance(int[] a, int[] b)
    {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

}
