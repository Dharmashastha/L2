package array2;

public class Solution {

public int minimumGetValue(int arr[],int n,int m)
{
	int min = Integer.MAX_VALUE;
	
	for(int i = 0; i < n;i++)
	{
		for(int j = i; j < m+i ;j++)
		{
			min = Math.min((arr[i] - arr[j]),min);
			if(min < 0)
			{
				min = 0 - min;
			}
		}
	}
	
	return min;
}
	
}
