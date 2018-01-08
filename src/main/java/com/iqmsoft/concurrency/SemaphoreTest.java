package com.iqmsoft.concurrency;

import java.util.concurrent.*;

class Que
{
	static Semaphore scons = new Semaphore(0);
	static Semaphore sprod = new Semaphore(1);
	
	void get()
	{
		try {
			scons.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sprod.release();
	}
	
	void put()
	{
		try {
			sprod.acquire();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		scons.release();
	}
}

class Prod implements Runnable
{

	Que q;
	
	Prod(Que q) {
		this.q = q;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i<10 ; i++)
		{
			q.put();
			System.out.println("Producing " + i);
		}
		
	}
	
}

class Cons implements Runnable
{

    Que q;
	
	Cons(Que q) {
		this.q = q;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i<10 ; i++)
		{
			q.get();
			System.out.println("Consuming " + i);
		}
		
	}
	
}

public class SemaphoreTest {
	
	public void test()
	{
	   Que q = new Que();

	   new Prod(q);
	   new Cons(q);
	}
}
