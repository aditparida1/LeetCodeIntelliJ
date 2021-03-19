package org.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DistantBarcode1054
{
    public int[] rearrangeBarcodes(int[] barcodes)
    {
        PriorityQueue<HolderBar> q = new PriorityQueue<>(new Comparator<HolderBar>()
        {
            @Override
            public int compare(HolderBar o1, HolderBar o2)
            {
                return -1 * Integer.compare(o1.freq, o2.freq);
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < barcodes.length; ++i)
        {
            if(!map.containsKey(barcodes[i]))
            {
                map.put(barcodes[i], 0);
            }
            map.put(barcodes[i], map.get(barcodes[i]) + 1);
        }

        for(int key: map.keySet())
        {
            q.add(new HolderBar(key, map.get(key)));
        }

        int index = 0;

        while(index < barcodes.length)
        {
            var curr1 = q.poll();
            if(index == 0)
            {
                barcodes[index++] = curr1.key;
                curr1.freq -= 1;
            }
            else if(index != 0 && barcodes[index - 1] != curr1.key)
            {
                barcodes[index++] = curr1.key;
                curr1.freq -= 1;
            }

            if(index == barcodes.length)
                break;
            if(!q.isEmpty())
            {
                var curr2 = q.poll();
                if(index == 0)
                {
                    barcodes[index++] = curr2.key;
                    curr2.freq -= 1;
                }
                else if(index != 0 && barcodes[index - 1] != curr2.key)
                {
                    barcodes[index++] = curr2.key;
                    curr2.freq -= 1;
                }

                if(curr2.freq != 0)
                {
                    q.add(curr2);
                }
            }
            if(curr1.freq != 0)
                q.add(curr1);
        }

        return barcodes;
    }
}
class HolderBar
{
    int key;
    int freq;
    public HolderBar(int key, int value)
    {
        this.key = key;
        this.freq = value;
    }
}
