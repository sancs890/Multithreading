package com.practice.threads;

class A
{
	int num;
	boolean valueSet = false;
	public synchronized  void put(int num) {
		while(valueSet) {
			try { wait(); } catch(Exception e) {};
		}
		System.out.println("Put :: "+num);
		this.num = num;
		notify();
		valueSet = true;
	}
	
	public synchronized int get() {
		while(!valueSet) {
			try { wait();} catch(Exception e) {}
		}
		valueSet = false;
		notify();
		return num;
	}
}

class Producer implements Runnable{
	
	A a;
	public Producer(A a) {
		this.a = a;
		Thread t = new Thread(this,"Producer");
		t.start();
	}

	@Override
	public void run() {
		int i=0;
		while(true) {
			a.put(i++);
			try { Thread.sleep(5000);}catch(Exception e) {}
		}
	}
	
}

class Consumer implements Runnable{
	A a;
	public Consumer(A a) {
		this.a = a;
		Thread t = new Thread(this,"Consumer");
		t.start();
	}
	@Override
	public void run() {
		while(true) {
			System.out.println(a.get());
			try { Thread.sleep(1000);}catch(Exception e) {}
		}
	}
	
}


public class ThreadCommunication {

	public static void main(String[] args) {
		A a = new A();
		new Producer(a);
		new Consumer(a);
	}

}
