package array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

public int minimumGetValue(int arr[],int m)
{
	Arrays.sort(arr);
	int min = Integer.MAX_VALUE;
	return minimunGetValueSum(arr, 0, m - 1, min);
}	

public int minimunGetValueSum(int arr[],int start,int end,int min) 
{
	min = Math.min((Math.abs(arr[end] - arr[start])), min);
	
	if(end == arr.length - 1)
	{
		return min;
	}
	return minimunGetValueSum(arr, start + 1, end + 1, min);
}

public String sumClosestValue(int arr[],int n,int x)
{
	int  min=Integer.MAX_VALUE;
	int temp = 0;
	String saved = "";
	for(int i = 0; i < n; i++)
	{
		for(int j = i+1; j < n; j++)
		{
			temp = Math.abs(x-(arr[i]+arr[j]));
			if(temp < min)
			{
				min = Math.min(temp,min);
				saved = arr[i]+" "+arr[j];
			}
		}
	}
	
	return saved;
}

public int[] rotateOnePosition(int arr[],int n)
{
	int temp = arr[n-1];
	for(int i = n - 1;i > 0;i--)
	{
		arr[i] = arr[i - 1];		
	}
	arr[0] = temp;
return arr;	
}

public List<String> mismatchPair(char arr1[],char arr2[])
{
	if(arr1.length != arr2.length)
	{
		return null;
	}
	
	List<String> ans = new ArrayList<>();
	String output = "";
	String saved = "";
	
	for(int i = 0; i < arr1.length;i++)
	{
		if(arr1[i] != arr2[i] && arr1[i+1] != arr2[i+1])
		{
			output = arr1[i]+""+arr1[i+1];
			saved = arr2[i]+""+arr2[i+1];
			ans.add(output);
			ans.add(saved);
			i++;
		}
		else if(arr1[i] != arr2[i])
		{
			output = arr1[i]+"";
			saved = arr2[i]+"";
			ans.add(output);
			ans.add(saved);
		}
	}
	return ans;
}

public List<String> sumIsEqualNumber(int array[],int n,int sum)
{
	Map<Integer,Integer> ans = new HashMap<>();
	String saved = "";
	List<String> output = new ArrayList<>();

	for(int i = 0; i < n; i++)
	{
		int temp=sum - array[i];
		if(ans.containsKey(temp))
		{
			saved = "("+array[i]+","+temp+")";
			output.add(saved);
		}
		else
		{
			ans.put(array[i], 1);
		}
	}
	
	return output;
}

public int[] rotateArrayPosition(int array[],int n)
{
	int temp = 0;
	int loop = n;
	while(loop > 0)
	{
	for(int i = 0; i < n - 1; i++)
	{
		temp = array[i];
		array[i] = array[i+1];
		array[i+1] = temp;
	}
	loop--;
	}
return array;	
}


public void unionExceptIntersect(List<Integer> array1,List<Integer> array2)
{
 	List<Integer> union = new ArrayList<>();
	List<Integer> except = new ArrayList<>();
	List<Integer> intersect = new ArrayList<>();
	
	for(int i = 0; i < array1.size(); i++)
	{
		Integer dummy = (Integer) array1.get(i);
		
		if(!union.contains(dummy))
		{
			union.add(dummy);
		}
		
		if(dummy % 2 == 0)
		{
			except.add(dummy);
		}
		
		if(array2.contains(dummy) && !intersect.contains(dummy))
		{
			intersect.add(dummy);
		}
	}
	
	for(int i = 0; i < array2.size(); i++)
	{
		Integer dummy = (Integer) array2.get(i);
		
		if(!union.contains(dummy))
		{
			union.add(dummy);
		}
		
		if(dummy % 2 == 1)
		{
			except.add(dummy);
		}
		
		if(array1.contains(dummy) && !intersect.contains(dummy))
		{
			intersect.add(dummy);
		}
	}
	
	System.out.println(union);
	System.out.println(except);
	System.out.println(intersect);
}

public Map<Integer,Integer> duplicateCount(int array[],int n)
{
	Map<Integer,Integer> ans = new HashMap<>();
	
	for(int i = 0; i < n; i++)
	{
		if(ans.containsKey(array[i]))
		{
			ans.put(array[i], ans.get(array[i])+1);
		}
		else
		{
			ans.put(array[i], 1);
		}
	}
return ans;	
}

public int longestSubSequence(int arr[],int n)
{
	List<Integer> ans = new ArrayList<>();
	
	for(int i = 0; i < n - 1;i++)
	{
		if(arr[i] < arr[i+1])
		{
			ans.add(arr[i]);
		}
	}
	if(arr[n - 1] > arr[n - 2])
	{
		ans.add(arr[n - 1]);
	}
return ans.size();	
}

public boolean nonDecreasingArray(int arr[],int n)
{
	int count = 0;
	for(int i = 0; i < n - 1; i++)
	{
		if(arr[i] > arr[i+1])
		{
			 count++;
		}
	}
	if(1 >= count)
	{
		return true;
	}
return false;	
}

public boolean multiSetSum(int arr[],int n)
{
	Arrays.sort(arr);
	return sumDigitArray(arr, 0, 1, n);
}

public boolean sumDigitArray(int arr[],int start,int end,int n)
{
	int ans1 = 0;
	int ans2 = 0;
	
	for(int i = 0; i < end; i++)
	{
		ans1 += arr[i];
	}
	for(int i = end; i < n; i++)
	{
		ans2 += arr[i];
	}
	if(ans1 == ans2)
	{
		return true;
	}
	if(end == n - 1)
	{
		return false;
	}
return sumDigitArray(arr, start, end+1, n);	
}

public int multiplyMaxValue(int arr[],int n)
{
	int max = Integer.MIN_VALUE;
	
	for(int i = 0; i < n;i++)
	{
		for(int j = i+1; j < n; j++)
		{
			for(int k = j+1;k < n; k++)
			{
				max = Math.max(max, Math.abs((arr[i])*arr[j]*arr[k]));
			}
		}
	}
	return max;
}

public int sumOfDigits(int number)
{
	int sum=0,digit = 0;
	
	while(number > 0)
	{
		digit = number % 10;
		sum += digit;
		number /= 10;
	}
return sum;	
}

public String getPerfectNumber(int number)
{
	int saved = 0;
	
	saved = sumOfDigits(number);
	
	saved = 10 - saved;
	
return number+""+saved;	
}

public int[] rotateArraySizePosition(int array[],int n,int rotate)
{
	int temp = 0;

	while(rotate > 0)
	{
	for(int i = 0; i < n - 1; i++)
	{
		temp = array[i];
		array[i] = array[i+1];
		array[i+1] = temp;
	}
	rotate--;
	}
return array;	
}

public int[] ascendingOrder(int arr[],int n)
{
	int dummy = 0;
	int min = Integer.MAX_VALUE;
	int j = 0;
	
	for(int i = 0; i < n; i++)
	{
		dummy = sumOfDigits(arr[i]);
		if(dummy < min)
		{
			min = Math.min(min, dummy);
			arr[j] = arr[i];
		}
	}
	return arr;
}

public String closestNumberPair(int arr[],int n)
{
	int min = Integer.MAX_VALUE;
	int dummy = 0;
	String saved = "";
	
	for(int i = 0; i < n; i++)
	{
		for(int j = i+1; j < n; j++)
		{
			dummy = Math.abs(arr[i] - arr[j]);
			if(min  > dummy)
			{
				min = Math.min(dummy, min);
				saved = arr[j]+","+arr[i];  
			}
		}
	}
return saved; 	
}

public void patternOutput(int arr[],int n)
{
	for(int i = 0; i < n ;i++)
	{
		for(int j = 0; j <= i; j++)
		{
			if(j == 0)
			{
				System.out.print(arr[i]+" ");
			}
			else if(j == 1)
			{
				System.out.print(arr[i+4]+" ");
			}
			else if(j == 2)
			{
				System.out.print(arr[i+7]+" ");
			}
			else if(j == 3) 
			{ 
				System.out.print(arr[i+9]+" "); 
			} 
			else
			{
				System.out.print(arr[i+10]+" "); 
			}
		}	
		System.out.println();
	}
}

public void maximumNumberOne(int arr[][],int n,int m)
{
	int count = 0;
	int index;
	for(int i = 0; i < n; i++)
	{
		int row[] = arr[i];
		for(int j = 0; j < m; j++)
		{
			if(row[j] == 1)
			{
				count++;
				index = i;
			}
			
		}
	}
	return ;
}

public void sorting(int arr[][])
{
	
	for(int i = 0; i < arr[0].length; i++)
	{
		int row[] = arr[i];
		Arrays.sort(row);
		arr[i] = row;
	}
	System.out.println(Arrays.deepToString(arr));
}

}