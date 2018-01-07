package com.iqmsoft.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class TreePriorityQueueApp
{
	Tree theTree;
	
	public TreePriorityQueueApp()
	{
		theTree = new Tree();
	}
	
	public void insert(int value)
	{
		theTree.insert(value, 0); //no use for dData in this exercise
	}
	
	public Node remove()
	{
		return theTree.removeMax();
	}
	
	public void change(int oldValue, int newValue)
	{	
		if(theTree.delete(oldValue))
			theTree.insert(newValue, 0);
		else
			System.out.println("Value does not exist!");
	}
	
	public boolean isEmpty()
	{
		return theTree.isEmpty();
	}
	
	public void display()
	{
		theTree.traverse(2);
	}
} 

public class TreePriorityQueueAppTest
{
	public static void main(String[] args) throws IOException
	{
		
		System.out.println("Tree Priority Queue App");
		
		TreePriorityQueueApp theQueue = new TreePriorityQueueApp();
		
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
		theQueue.insert(200);
		
		theQueue.display();
		
		if(!theQueue.isEmpty())
			theQueue.remove();
		else
			System.out.println("Can't remove; queue empty");
		
		theQueue.display();
		
		theQueue.change(2, 300);
		
		theQueue.display();
	
	} 
	
} 