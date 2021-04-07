package org.leetcode;
import java.util.*;

public class AlphabetBoard1138
{
    public String alphabetBoardPath(String target)
    {
        StringBuilder sb = new StringBuilder();
        Map<Character, int[]> map = new HashMap<>();

        char currChar = 'a';
        int i = 0;

        while(currChar < 'z')
        {
            for (int j = 0; j < 5; ++j)
            {
                map.put(currChar, new int[]{i, j});
                currChar++;
            }
            i++;
        }
        int[] currPos = {0,0};
        for (i = 0; i < target.length(); ++i)
        {
            currChar = target.charAt(i);
            int[] dest = map.get(currChar);
            traverse(sb, currPos, dest);
            currPos = dest;
        }
        return sb.toString();
    }
    private void traverse(StringBuilder sb, int[] source, int[] dest)
    {
        int[] currPos = {source[0], source[1]};
        char vertical;
        if(dest[0] < source[0])
        {
            vertical = 'U';
        }
        else
        {
            vertical = 'D';
        }
        char hor;
        if(dest[1] < source[1])
        {
            hor = 'L';
        }
        else
        {
            hor = 'D';
        }
        while(currPos[0] != dest[0])
        {
            if(vertical == 'D')
            {
                currPos[0]++;
                sb.append(vertical);
                if(currPos[0] == 4)
                    break;
            }
            else
            {
                currPos[0]--;
                sb.append(vertical);
            }
        }
        while(currPos[1] != dest[1])
        {
            if(hor == 'L')
            {
                currPos[1]--;
                sb.append(hor);
            }
            else
            {
                currPos[1]++;
                sb.append(hor);
            }
        }
        while (currPos[0] != dest[0])
        {
            if(vertical == 'D')
            {
                currPos[0]++;
                sb.append(vertical);
            }
            else
            {
                currPos[0]--;
                sb.append(vertical);
            }
        }
    }
}

/*
"DR!DDR!UULL!R!DDR!DLL!!D!UUUURRRR!DDLL!ULL!DRRRR!ULL!DL!UL!DDD!UUUURRR!UL!DDDDLLD!UR!UUUR!URR!DDDDLLLLD!UUU!D!UURRRR!DDDLLLLD!!URRR!UL!UUUR!DDR!ULLLL!URRR!DDD!ULLL!DRRR!!!DLL!U!URRR!DLLL!L!DR!R!RR!UUUULLL!DDDR!UULL!RRR!LL!DL!U!URRRR!DDLLLL!UURR!DDDDLL!D!UUR!UUURR!DDR!DLLLL!DRR!UULL!UR!DDDR!URR!UUULLLL!DRRRR!U!DDLLL!DL!U!D!DRRR!R!UULL!DDL!DL!UUUURRR!DLLL!DRR!UUU!DDDDRR!UU!ULLL!D!DDLD!UUUUURRRR!D!DD!UULLL!DDRR!UULL!DDDLD!UURRR!R!DLLLL!UURRR!"
 */
