package org.leetcode;
import java.util.*;

public class CarPooling1094
{
    public boolean carPooling(int[][] trips, int capacity)
    {

        HolderCar[] tripInfo = new HolderCar[trips.length * 2];
        int idx = 0;
        for (int[] trip: trips)
        {
            tripInfo[idx++] = new HolderCar(trip[1], trip[0]);
            tripInfo[idx++] = new HolderCar(trip[2], -1 * trip[0]);
        }

        Arrays.sort(tripInfo, new Comparator<HolderCar>()
        {
            @Override
            public int compare(HolderCar o1, HolderCar o2)
            {
                if(o1.location < o2.location)
                {
                    return -1;
                }
                else if(o1.location > o2.location)
                {
                    return 1;
                }
                else
                {
                    if(o1.passenger < o2.passenger)
                        return -1;
                    else
                        return 1;
                }
//                return 0;
            }
        });
        int currSum = 0;

        for (int i = 0; i < tripInfo.length; ++i)
        {
            currSum += tripInfo[i].passenger;
            if(currSum > capacity)
                return false;
        }
        return true;
    }
}
class HolderCar
{
    int location, passenger;
    public HolderCar(int location, int passenger)
    {
        this.location = location;
        this.passenger = passenger;
    }
}
