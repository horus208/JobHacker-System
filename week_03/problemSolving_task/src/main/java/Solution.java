import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution
{
    //20. Valid Parentheses

    public static boolean isValid(String s)
    {
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');



        Stack<Character> stack = new Stack<>();
        int n=s.length();
        for(int i=0; i<n;i++)
        {
            char x=s.charAt(i);
            if(map.containsKey(x))
            {
                if(stack.isEmpty()||stack.pop()!=map.get(x))
                    return false;
            }
            else
                stack.push(x);


        }
        return stack.isEmpty();


    }

    //14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs)
    {
        int count =0;
        for(int i= 0;i<strs[0].length();i++)
        {
            char curr = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if(i>=strs[j].length()||strs[j].charAt(i)!=curr)
                    return strs[0].substring(0,i);
            }

        }

        return strs[0];

    }

    //1. Two Sum

    public int[] twoSum(int[] nums, int target)
    {
        int[]ans=new int[2];
        Map<Integer,Integer> hold=new HashMap<>();
        for(int i=0; i<nums.length;i++)
        {
            if(hold.containsKey(target-nums[i]))
            {
                ans[0]=i;
                ans[1]=hold.get(target-nums[i]);
                return ans;
            }
            hold.put(nums[i],i);

        }
        return ans;


    }


    //1832. Check if the Sentence Is Pangram
    public boolean checkIfPangram(String sentence)
    {
        int[] freq = new int[26];
        for(int i=0;i<sentence.length();i++)
            freq[sentence.charAt(i)-'a']+=1;

        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]==0)
                return false;
        }
        return true;


    }
}
