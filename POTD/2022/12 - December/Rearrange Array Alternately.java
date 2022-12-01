//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        
        // Your code here
        long max = arr[n-1]+1;  // max+1 so it gives 0 when it divides any element in array and doesn't manipulate it
        int left = 0;
        int right = n-1;
        
        // % gives original value
        // / gives expected value
        // current + (max * The value we want)
        for(int i=0; i<n; i++) {
            if(i % 2 == 0) {
                // max value here
                arr[i] = arr[i] + (max * (arr[right--] % max) );
            }
            else {
                arr[i] = arr[i] + (max * (arr[left++] % max) );
            }
        }
        
        for(int i=0; i<n; i++) {
            arr[i] /= max;
        }
    }
}
    
    
    
        
        
        // O(N) space
    //     long[] arr2 = new long[n];
        
    //      for(int i=0; i<n; i++)
    //         arr2[i] = arr[i];
            
    //     int j= 0;
    //     for(int i=0; i<n;i++) {
            
    //         if(i%2 == 0)
    //             arr[i] = arr2[n-j-1];
    //         else
    //             arr[i] = arr2[j++];
    //     }
    // }
    
// }


