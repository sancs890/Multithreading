package com.practice.threads;

public class MyThread implements Runnable{
	
	int [] arr = {1,3,4,5,6,7,8};
	@Override
	public void run(){
	for(int i=0;i<arr.length;i++) {
		arr[i] = arr[i]*2;
	}
	}
}
