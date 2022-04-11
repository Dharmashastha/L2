package sorting;

public class Sort 
{

public static int[] selectionSort(int array[])
{
	int i,j,temp,minIndex;
	for(i = 0; i < array.length; i++)
	{
		minIndex = i;
		for(j = i+1; j < array.length; j++)
		{
			if(array[j] < array[minIndex])
			{
				minIndex = j;
			}
		}
		temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;
	}
return array;
}

public static int[] bubbleSort(int array[])
{
	int i,j,temp;
	boolean flag;
	for(i = 1; i < array.length; i++)
	{
		flag = false;
		for(j = 0; j < array.length - i; j++)
		{
			if(array[j] > array[j+1])
			{
				flag = true;
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
		if(!flag)
		{
			break;
		}
	}
return array;	
}

public static int[] insertionSort(int array[])
{
	int i,j,temp;
	for(i = 1; i < array.length; i++)
	{
		for(j = i; j > 0; j--)
		{
			if(array[j] < array[j - 1])
			{
				temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
			}
			else
			{
				break;
			}
		}
	}
return array;	
}

}
