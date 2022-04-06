package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	ArrayList<Long> alternateSort(long arr[] ,int N)
    {
        ArrayList<Long> ans = new ArrayList<>();
        
        Arrays.sort(arr);
        
        int j = N - 1;
        
        for(int i = 0; i < N;i++)
        {
            if(i % 2 == 0)
            {
                ans.add(arr[j]);
                j--;
            }
        }
        j=0;
        for(int i = 0; i < N;i++)
        {
            if(i % 2 == 1)
            {
                ans.add(i,arr[j]);
                j++;
            }
        }
    return ans;    
    }

static int majorityElement(int a[], int size)
    {
        int count = 0;
        int j = size -1;
        for(int i = 0; i < size;)
        {
        	if(a[i] == a[j])
        	{
        		count++;
        		i++;
        	}
        	j--;
        }
        
        if(size/2 < count)
        {
            return count;
        }
        else
        {
            return -1;
        }
}

int getPairsCount(int[] arr, int n, int k) {
    
    int count = 0;
    int ans = 0;
  
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
        	if(j > i)
        	{
            ans = arr[i] + arr[j];
            if(ans == k)
            {
                count++;
            }
        	}
        }
    }
return count;    
}

public int numIdenticalPairs(int[] nums) {
    int count = 0;
    int i = 0;
    int j = nums.length - 1;
    
    while(i < j)
    {
        if(nums[i] == nums[j])
        {
            count++;

        }
     
        if(i!=nums.length-1 && i+1==j)
        {
            i++;
            j=nums.length-1;
        }
        j--;
    }
return count;
}

//calculation of weight after balance point 
public String balancePoint(String inp, int len) { 
        int j = 1; 
        if (len == inp.length() - 1) { 
                return "not balanced"; 
        } 
        char ch1 = inp.charAt(len); 
        int out = 0; 
        Map<Character, Integer> map = new HashMap<Character, Integer>(); 
        for (char ch = 'a'; ch <= 'z'; ++ch) { 
                map.put(ch, j); 
                j++; 
        } 
        j = 1; 
        int output = 0; 
        int ind = inp.indexOf(ch1); 
        for (int i = ind + 1; i < inp.length(); i++) { 
                output += j * map.get(inp.charAt(i)); 
                j++; 
        } 
        j = 1; 
        for (int i = 0; i < ind; i++) { 
                out += j * map.get(inp.charAt(i)); 
                j++; 
        } 
        if (output - out == 0) { 
                return "balanced at " + inp.charAt(len); 
        } else { 
                return balancePoint(inp, len + 1); 
        } 
}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); 
		
		Solution solCall = new Solution();
		
		int number = sc.nextInt();
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * // int length = sc.nextInt();
		 * 
		 * int len = sc.nextInt();
		 * 
		 * int rotate = sc.nextInt();
		 * 
		 * int z = len - 1;
		 * 
		 * int arr[] = new int[len];
		 * 
		 * int temp = 0;
		 * 
		 * for(int j = 0; j < arr.length;j++) { arr[j] = sc.nextInt(); }
		 * System.out.println(Arrays.toString(arr)); int dummy[]=new int[len]; int i=0;
		 * for(int k = rotate; k < len;k++) { dummy[i]=arr[k]; i++; } for(int
		 * k=0;k<rotate;k++) { dummy[i]=arr[k]; i++; }
		 * 
		 * System.out.println(Arrays.toString(dummy));
		 */
		switch(number)
		{
			case 1:
				long arr[] = {7,1,2,3,4,5,6};
				System.out.println(solCall.alternateSort(arr,7));
				break;
				
			case 2:
				int a[] = {3,1,3,3,5};
				System.out.println(Solution.majorityElement(a, 5));
				break;
				
			case 3:
				int a1[] = {1,5,7,1};
				System.out.println(solCall.getPairsCount(a1, 4, 6));
				break;
				
			case 4:
				int a2[] = {1,1,3,5,3,2,2};
				System.out.println(solCall.numIdenticalPairs(a2));
				break;	
		}
		
	}

}
