package com.iqmsoft.concurrency;

import java.util.concurrent.locks.*;

import java.util.concurrent.atomic.*;

class Shared {
	static int count = 0;
	static AtomicInteger a = new AtomicInteger(0);
}

class MyAtomic implements Runnable {

	String name;

	MyAtomic(String name) {
		this.name = name;
		new Thread(this).start();
	}

	@Override
	public void run() {

				
			System.out.println("Atomic Integer ");
			
			for(int i=0; i < 10; i++) 
			{
			   Shared.a.getAndSet(i);
			   System.out.println(i);
			}

		
	
	
	}

}


class MyLock implements Runnable {

	ReentrantLock r;
	String name;

	MyLock(ReentrantLock r, String name) {
		this.r = r;
		this.name = name;

		new Thread(this).start();
	}

	@Override
	public void run() {

		try {

			System.out.println("ReentrantLock ");
			r.lock();
			Shared.count++;
			System.out.println(Shared.count);

			System.out.println("ReentrantLock ");

			Thread.sleep(1000);

			r.unlock();

			System.out.println("ReentrantLock Unlock");

		} catch (InterruptedException e) {

			System.out.println("ReentrantLock Unlock " + e.getMessage());
		}

	}

}

public class LockTest {

	public void test() {
		ReentrantLock r = new ReentrantLock();

		new MyLock(r, "one");
		new MyLock(r, "two");
		new MyLock(r, "three");
		
		new MyAtomic("test1");
		new MyAtomic("test2");
	}

}
