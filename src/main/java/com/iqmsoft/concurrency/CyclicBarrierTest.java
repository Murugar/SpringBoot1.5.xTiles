package com.iqmsoft.concurrency;

import java.util.concurrent.*;

class Cyclic implements Runnable
{
	public void run() 
	{
		System.out.println("Cyclic Barrier Test Completed");
	}
}

class MyThread implements Runnable {

	CyclicBarrier cb;
	String s;
	
	public MyThread(CyclicBarrier cb, String s)
	{
		this.cb = cb;
		this.s = s;
		
		
		
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		
		System.out.println(this.s);
		
		try {
			this.cb.await();
		} catch (InterruptedException e) {
		    System.out.println(e.getMessage());	
			
		} catch (BrokenBarrierException e) {
			System.out.println(e.getMessage());	
		
		}
		
	}
	
	
	
}


public class CyclicBarrierTest {
	
	 CyclicBarrier cb = new CyclicBarrier(3, new Cyclic());
	 
	 public void test() 
	 {
		 new MyThread(cb, "test1");
		 new MyThread(cb, "test2");
		 new MyThread(cb, "test3");
		 
	 }

}
