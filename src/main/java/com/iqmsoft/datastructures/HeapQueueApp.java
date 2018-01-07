package com.iqmsoft.datastructures;

class HeapPriorityQ
{
	Heap theHeap;
	
	public HeapPriorityQ(int size)
	{
		theHeap = new Heap(size);
	}
	
	public boolean insert(int value)
	{
		return theHeap.insert(value);
	}
	
	public int remove()
	{
		int temp = theHeap.remove().getKey();
		return temp;
	}
	
	public boolean isEmpty()
	{
		return theHeap.isEmpty();
	}
	
	public void display()
	{
		theHeap.displayHeap();
	}
}

public class HeapQueueApp
{
	public void test()
	{
		
		System.out.println("HeapPriorityQ");
		
		HeapPriorityQ theQueue = new HeapPriorityQ(31);
		boolean success;
		
		theQueue.insert(70);
		theQueue.insert(40);
		theQueue.insert(50);
		theQueue.insert(20);
		theQueue.insert(60);
		theQueue.insert(100);
		theQueue.insert(80);
		theQueue.insert(30);
		theQueue.insert(10);
		theQueue.insert(90);
		
		theQueue.display();
		
		if(!theQueue.isEmpty())
			theQueue.remove();
		else
			System.out.println("Can't remove; queue empty");
		
		theQueue.display();
		
		success = theQueue.insert(200);
		
		success = theQueue.insert(210);
		success = theQueue.insert(220);
		
		theQueue.display();
		
		
		
		
		
		
	} 
	
	
}
