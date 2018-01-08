package com.iqmsoft.concurrency;

import java.util.concurrent.*;

class Sender implements Runnable
{
	Exchanger<String> ex = new Exchanger<String>();
	String str;
	
	Sender(Exchanger<String> ex) 
	{
		this.ex = ex;
		str = new String();
		
		new Thread(this).start();
	}

	@Override
	public void run() {
		
		char ch = 'A';
		
		for(int i =0 ; i < 3; i++)
		{
			for(int j =0 ; j < 5; j++)
			{
			    str += ch++;	
			    
			    try {
					str = ex.exchange(str);
					
					System.out.println("Sending  " + str);
					
				} catch (InterruptedException e) {
				
					System.out.println(" Exhanging String ");;
				}
			    
			}
			
		}
		
	}
	
}

class Receiver implements Runnable
{
	
	Exchanger<String> ex;
	
	String str;
	
	Receiver(Exchanger<String> ex) 
	{
		this.ex = ex;
		
		new Thread(this).start();
	}

	@Override
	public void run() {
		
		for(int i =0 ; i < 3; i++)
		{
		    
		    
		    try {
				str = ex.exchange(new String());
				System.out.println("Receiving  " + str);
			} catch (InterruptedException e) {
			
				System.out.println(" Exhanging String ");;
			}
		    
		}
		
		
	}
	
}


public class ExchangerTest {
	
	Exchanger<String> ex = new Exchanger<String>();
	
	public void test() 
	{
		new Sender(ex); 
		new Receiver(ex); 
	}

}
