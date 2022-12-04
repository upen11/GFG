//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String S, int N){
        int vowels[]=new int[26];
        int consonents[]=new int[26];
        int noOfVowels=0, noOfCons=0;
        
        for(int i=0; i<S.length(); i++){
            char ch=S.charAt(i);
            if(ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u'){
                vowels[ch-'a']++;
                noOfVowels++;
            }
            else{
                consonents[ch-'a']++;
                noOfCons++;
            }
        }
        //System.out.println(noOfVowels+" "+noOfCons);
        if(Math.abs(noOfVowels - noOfCons)>1){
            return "-1";
        }
        int i=0,j=0;
        StringBuffer str=new StringBuffer();
        boolean startWithVowel=true;
        if(noOfVowels >= noOfCons){
            startWithVowel=true;
        }
        else{
            startWithVowel=false;
        }
        while(i<26 && j<26)
        {
            while(i<26 && startWithVowel){
                if(i<26 && vowels[i]>0){
                    str.append((char)(i+'a'));
                    vowels[i]--;
                    startWithVowel=false;
                    break;
                }
                i++;
            }
            while(j<26 && startWithVowel==false){
                if(j<26 && consonents[j]>0){
                    str.append((char)(j+'a'));
                    consonents[j]--;
                    startWithVowel=true;
                    break;
                }
                j++;
            }
        }
        return str.toString();
    }
}
