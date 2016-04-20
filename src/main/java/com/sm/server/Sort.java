package com.sm.server;

public class Sort {

	public static void quickSortByMid(int[] a, int low, int high) {
	    if (low >= high)
	      return;
	    // 分割
	    int pivot = a[low];// 基准值
	    int i = low, j = high;
	    while (i < j) {
	      while (i < j && a[j] >= pivot)
	        --j;
	      a[i]=a[j];
	      while (i < j && a[i] <= pivot)
	        ++i;
	      a[j]=a[i];
	    }
	    a[i]=pivot;
	    quickSortByMid(a, low, i-1);
	    quickSortByMid(a, i+1, high);
	  }
	
	public static void main(String[] args) {
		int[] a = {100,44,65,878,22};
		Sort.quickSortByMid(a, 0, 4);
		System.out.print(a);
	}
}
