package com.iqmsoft.concurrency;

import java.util.concurrent.*;

class MyThread1 implements Runnable 
{
	
	CountDownLatch cdl;
	String name;

	public MyThread1(CountDownLatch cdl, String name) {
		
		this.cdl = cdl;
		this.name = name;
		
		new Thread(this);
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<5; i++) 
		{
			System.out.println(i);
			cdl.countDown();
		}
		
	}
	
}

public class CountDownLatchTest {
	
	CountDownLatch cd1 = new CountDownLatch(5);
	CountDownLatch cd2 = new CountDownLatch(5);
	CountDownLatch cd3 = new CountDownLatch(5);
	CountDownLatch cd4 = new CountDownLatch(5);
	
	ExecutorService es1 = Executors.newFixedThreadPool(4);
	
	
	
	
	public CountDownLatchTest()
	{
		System.out.println("Starting CountDownLatch");
		
		es1.execute(new MyThread1(cd1, "test1"));
		es1.execute(new MyThread1(cd2, "test2"));
		es1.execute(new MyThread1(cd3, "test3"));
		es1.execute(new MyThread1(cd4, "test4"));
	}
	
	
	public void test()
	{
		 try {
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		 
		 System.out.println("Done");
		
	}

}
