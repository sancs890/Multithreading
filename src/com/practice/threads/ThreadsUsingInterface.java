package com.practice.threads;
class HiR implements Runnable{
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class HelloR implements Runnable{
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadsUsingInterface {

	public static void main(String[] args) {
		Thread t1 = new Thread(new HelloR());
		Thread t2 = new Thread(new HiR());
		t1.start();
		t2.start();
	}

}
