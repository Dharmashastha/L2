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
		for(int j = 0+i; j < n; j++)
		{
			temp = Math.abs(x-(arr[i]+arr[j]));
			if(temp < min && i != j)
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


public List<Integer> unionExceptIntersect(List<Integer> array1,List<Integer> array2)
{
	
	
	
	return null;
}
}
