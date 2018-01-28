package cn.lfy.common.utils;

import java.util.Arrays;

public class HeapSort {

	static void AdjustDown(int arr[], int i, int n)
	{
	    int j = i * 2 + 1;//子节点 
	    while (j<n)
	    {
	        if (j+1<n && arr[j] > arr[j + 1])//子节点中找较小的
	        {
	            j++;
	        }
	        if (arr[i] < arr[j])
	        {
	            break;
	        }
	        swap(arr,i, j);
	        i = j;
	        j = i * 2 + 1;
	    }
	}
	static void MakeHeap(int arr[], int n)//建堆
	{
	    int i = 0;
	    for (i = n / 2 - 1; i >= 0; i--)//((n-1)*2)+1 =n/2-1
	    {
	        AdjustDown(arr, i, n);
	    }
	}
	static void sort(int arr[],int len)
	{
	    int i = 0;
	    MakeHeap(arr, len);
	    for (i = len - 1; i >= 0; i--)
	    {
	        swap(arr, i, 0);
	        AdjustDown(arr, 0, i);
	    }

	}
	
	public static void swap(int[] arr, int i, int j) {
		if(arr[i] > arr[j]) {
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
	}
	public static void main(String[] args) {
		int arr[]={8,5,0,3,7,1,2};
		sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
}
