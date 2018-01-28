package cn.lfy.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.google.common.collect.Lists;

public class TopN {

	private static final int K = 10;
	
	private static int[] dui = new int[10];
	static void create_dui()
	{
	    int i;
	    int pos=K/2 - 1;      ///从末尾数，第一个非叶节点的位置K/2
	    for(i=pos;i>=1;i--)
	        UpToDown(i);
	}

	static void UpToDown(int i)
	{
	    int t1,t2,tmp,pos;
	    t1=2*i; ///左孩子(存在的话)
	    t2=t1+1;    ///右孩子(存在的话)
	    if(t1>=K)    ///无孩子节点
	        return;
	    else
	    {
	        if(t2>K)  ///只有左孩子
	            pos=t1;
	        else
	            pos=dui[t1]>dui[t2]? t2:t1;

	        if(dui[i]>dui[pos]) ///pos保存在子孩子中，数值较小者的位置
	        {
	            tmp=dui[i];
	            dui[i]=dui[pos];
	            dui[pos]=tmp;
	            UpToDown(pos);
	        }
	    }
	}
	
	public static void swap(int[] arr, int i, int j) {
		if(arr[i] > arr[j]) {
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
	}
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
	public static void main(String[] args) {
		int[] data = new int[]{8,5,0,3,7,1,2,34, 54, 6, 93, 23, 32, 21, 11, 66, 88, 90, 12};
		int i;
	    int tmp;
	    for(i=0;i<K;i++) ///先输入K个
            dui[i] = data[i];
        create_dui();  ///建小顶堆
        System.out.println(Arrays.toString(dui));
        for(i=K;i<data.length;i++)
        {
        	tmp = data[i];
            if(tmp>dui[0])  ///只有大于根节点才处理
            {
                dui[0]=tmp;
                UpToDown(0);    ///向下调整堆
            }
        }
        System.out.println(Arrays.toString(dui));
        for (i = dui.length - 1; i >= 0; i--)
	    {
	        swap(dui, i, 0);
	        AdjustDown(dui, 0, i);
	    }
        System.out.println(Arrays.toString(dui));
        ArrayList<Integer> arrayList = Lists.newArrayList(8,5,0,3,7,1,2,34, 54, 6, 93, 23, 32, 21, 11, 66, 88, 90, 12);
        Collections.sort(arrayList);
        System.out.println(arrayList);
	}
	
}
