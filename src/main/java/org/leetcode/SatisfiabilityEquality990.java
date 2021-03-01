package org.leetcode;
import java.util.*;
public class SatisfiabilityEquality990
{
        public boolean equationsPossible(String[] equations)
        {
            Map<Character, Holder> map = new HashMap<>();

            for (String eq: equations)
            {
                if(eq.charAt(1) == '=')
                {
                    char a = eq.charAt(0);
                    char b = eq.charAt(3);
                    if(!map.containsKey(a))
                    {
                        Holder h = new Holder();
                        h.a = a;
                        h.parent = h;
                        map.put(a, h);
                    }
                    if(!map.containsKey(b))
                    {
                        Holder h = new Holder();
                        h.a = b;
                        h.parent = h;
                        map.put(b, h);
                    }
                    Holder aH = map.get(a);
                    Holder bH = map.get(b);
                    if(a != b)
                    {
                        Holder aP = search(aH);
                        Holder bP = search(bH);
                        if(search(aH) != search(bH))
                        {
                            aP.parent = bP;
                        }
                    }
                }
            }

            for(String eq: equations)
            {
                if(eq.charAt(1) == '!')
                {
                    char a = eq.charAt(0);
                    char b = eq.charAt(3);
                    if(a == b)
                        return false;

                    if(map.containsKey(a) && map.containsKey(b))
                    {
                        Holder aH = map.get(a);
                        Holder bH = map.get(b);
                        if(search(aH) == search(bH))
                            return false;
                    }

                }
            }

            return true;
        }
        private Holder search(Holder a)
        {
            Holder temp = a;
            while(temp.parent != temp)
            {
                temp = temp.parent;
            }
            return temp;
        }

}
class Holder
{
    char a;
    Holder parent;
}