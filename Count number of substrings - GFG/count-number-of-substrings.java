//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String S, int K) {
        return atmostKdistinct(S, K) - atmostKdistinct(S, K-1);
    }
    
    long atmostKdistinct (String S, int K) {
        // your code here
        int[] map = new int[26];
        int i = -1, j = -1;
        long size = 0, count = 0;
        
        while(i < S.length()-1) {
            // acquire
            while(i < S.length()-1 && size <= K) {
                i++;
                
                char ch = S.charAt(i);
                
                if(map[ch-'a'] == 0) size++;
                map[ch-'a']++;
                
                if(size <= K) {
                    count+= i-j; // ans creation
                }
            }
            
            // release
            while(j < i && size > K) {
                j++;
                
                char ch = S.charAt(j);
                
                if(map[ch-'a'] == 1) {
                    size--;
                    count+= i-j; // ans creation
                }
                map[ch-'a']--;
            }
        }
        return count;
    }
}