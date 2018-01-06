package com.iqmsoft.datastructures;

import java.io.*;




class TreeHashTable
{
	private Tree[] hashArray;
	private int arraySize;
	
	public TreeHashTable(int size)
	{
		arraySize = size;
		hashArray = new Tree[arraySize];
		for(int j = 0; j < arraySize; j++)
			hashArray[j] = new Tree();
	}
	
	public void displayTable()
	{
		for(int j = 0; j < arraySize; j++)
		{
			System.out.print(j + ". ");
			hashArray[j].traverse(2);
		}
	}
	
	public int hashFunc(int key)
	{ return key % arraySize; }
	
	public void insert(Node theNode)
	{
		int key = theNode.iData;
		int hashVal = hashFunc(key);
		if(find(key) != null)
		{
			System.out.println("Value already exists in table.");
			return;
		}
		else
			hashArray[hashVal].insert(theNode.iData, theNode.dData);
	}
	
	public void delete(int key)
	{
		int hashVal = hashFunc(key);
		if(!hashArray[hashVal].isEmpty()) hashArray[hashVal].delete(key);
	}
	
	public Node find(int key)
	{
		int hashVal = hashFunc(key);
		if(!hashArray[hashVal].isEmpty())
		{	
			Node theNode = hashArray[hashVal].find(key);
			return theNode;
		}
		else
			return null;
	}
}

public class TreeHashMapApp
{
	public void test()
	{
		int aKey;
		
		int temp = 0;
		
		Node aDataItem;
		int size, n, keysPerCell = 20;
		System.out.print("Enter size of hash table: ");
		size = 10;
		System.out.print("Enter initial number of items: ");
		n = 10;
		
		TreeHashTable theHashTable = new TreeHashTable(size);
		
		for(int j = 0; j<n; j++)
		{
			aKey = (int)(java.lang.Math.random() * keysPerCell * size);
			aDataItem = new Node();
			aDataItem.iData = aKey;
			theHashTable.insert(aDataItem);
			temp = aKey;
		}
		
		theHashTable.displayTable();
		
		
		
		aDataItem = theHashTable.find(temp);
		
		if(aDataItem != null)
			System.out.println("Found " + temp);
		else
			System.out.println("Could not find ");
		
		theHashTable.delete(temp);
		theHashTable.displayTable();
		
		
		
	}
	
	
}
