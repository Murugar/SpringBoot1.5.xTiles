package com.iqmsoft.datastructures;

import java.io.*;

class HeapNode {
	private int iData;

	public HeapNode(int key) {
		iData = key;
	}

	public int getKey() {
		return iData;
	}

	public void setKey(int id) {
		iData = id;
	}
}

class Heap {
	private HeapNode[] heapArray;
	private int maxSize;
	private int currentSize;

	public Heap(int mx) {
		maxSize = mx;
		currentSize = 0;
		heapArray = new HeapNode[maxSize];
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean insert(int key) {
		if (currentSize == maxSize)
			return false;
		HeapNode newNode = new HeapNode(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}

	public void trickleUp(int index) {
		int parent = (index - 1) / 2;
		HeapNode bottom = heapArray[index];
		while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		heapArray[index] = bottom;
	}

	public HeapNode remove() {
		HeapNode root = heapArray[0]; // save root for function return
		heapArray[0] = heapArray[--currentSize]; // put the last node at the
													// root
		trickleDown(0); // then trickle it down to appropriate place
		return root;
	}

	public void trickleDown(int index) {
		int largerChild;
		HeapNode top = heapArray[index];
		while (index < currentSize / 2) // while node has at least one child
		{
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			if (rightChild < currentSize && // rightchild exists?
					heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
				largerChild = rightChild;
			else
				largerChild = leftChild;
			if (top.getKey() >= heapArray[largerChild].getKey())
				break;

			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}

	public boolean change(int index, int newValue) {
		if (index < 0 || index >= currentSize)
			return false;
		int oldValue = heapArray[index].getKey();
		heapArray[index].setKey(newValue);

		if (oldValue < newValue)
			trickleUp(index);
		else
			trickleDown(index);
		return true;
	}

	public void displayHeap() {
		System.out.print("heapArray: ");
		for (int m = 0; m < currentSize; m++)
			if (heapArray != null)
				System.out.print(heapArray[m].getKey() + " ");
			else
				System.out.print("-- ");
		System.out.println();

		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = "............................";
		System.out.println(dots + dots);

		while (currentSize > 0) {
			if (column == 0)
				for (int k = 0; k < nBlanks; k++)
					System.out.print(' ');
			System.out.print(heapArray[j].getKey());
			if (++j == currentSize)
				break;

			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			} else
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');
		}
		System.out.println("\n" + dots + dots);
	}
} // end class Heap

public class HeapApp {
	public void test() {
		
		System.out.println("Heap Array App");

		Heap theHeap = new Heap(31);
		boolean success;

		theHeap.insert(70);
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);

		theHeap.displayHeap();

		if (!theHeap.isEmpty())
			theHeap.remove();
		else
			System.out.println("Can't remove; heap empty");

		if (!theHeap.isEmpty())
			theHeap.remove();
		else
			System.out.println("Can't remove; heap empty");
		
		if (!theHeap.isEmpty())
			theHeap.remove();
		else
			System.out.println("Can't remove; heap empty");

		theHeap.displayHeap();

		success = theHeap.change(2, 210);
		if (!success)
			System.out.println("Invalid index\n");
		
		success = theHeap.change(3, 220);
		if (!success)
			System.out.println("Invalid index\n");


		theHeap.displayHeap();
		
		success = theHeap.insert(260);
		if (!success)
			System.out.println("Can't insert; heap full");
		
		success = theHeap.insert(270);
		if (!success)
			System.out.println("Can't insert; heap full");
		
		success = theHeap.insert(280);
		if (!success)
			System.out.println("Can't insert; heap full");
		
		theHeap.displayHeap();

	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
} // end class HeapApp