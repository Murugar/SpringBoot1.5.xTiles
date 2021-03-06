package com.iqmsoft.datastructures;

import java.util.Stack;

class Node
{
	public int iData;			//data item (key)
	public double dData;		//data item
	public Node leftChild;
	public Node rightChild;
	
	public void displayNode()
	{
		System.out.print("{" + iData + ", " + dData + "} ");
	}
}

class Tree
{
	private Node root;			//first node of tree
	
	public Tree()
		{ root = null; }
	
	public boolean isEmpty()
	{ return (root == null) ? true : false; }
	
	public Node find(int key)	//find node with given key in NON-EMPTY TREE
	{
		Node current = root;
		while(current.iData != key)
		{
			if(key < current.iData)		//go left?
				current = current.leftChild;
			else						//or go right?
				current = current.rightChild;
			if(current == null)			//if no child
				return null;			//didn't find it
		}
		return current;					//found it
	} //end find()
	
	public void insert(int id, double dd)
	{
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		if(root == null)				//no node in root
			root = newNode;
		else
		{
			Node current = root;
			Node parent;
			while(true)
			{
				parent = current;
				if(id < current.iData)	//go left?
				{
					current = current.leftChild;
					if(current == null) //if end of the line
					{					//insert on left
						parent.leftChild = newNode;
						return;
					}
				}
				else					//or go right?
				{
					current = current.rightChild;
					if(current == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	} //end insert()
	
	public boolean delete(int key) //delete node with given key
	{								//assumes non-empty list
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData != key)		//search for node
		{
			parent = current;
			if(key < current.iData)		//go left?
			{
				isLeftChild = true;
				current = current.leftChild;
			}
			else
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null)			//end of the line,
				return false;			//didn't find it
		}
		//found node to delete
		
		//if no children, simply delete it
		if(current.leftChild==null && current.rightChild==null)
		{
			if(current == root)
				root = null;
			else if(isLeftChild)		//disconnect deleted node from parent
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		
		//if no right child, replace with left subtree
		else if(current.rightChild == null)
		{
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		}
		
		//if no left child, replace with right subtree
		else if(current.leftChild == null)
		{
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}
		
		else		//two children, replace with in-order successor
		{
			//get successor of node to delete (current)
			Node successor = getSuccessor(current);
			
			//connect parent of current to successor instead
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			
			//connect successor to current's left child
			successor.leftChild = current.leftChild;
		}
		
		return true;
	} //end delete()
	
	public Node removeMax() //delete biggest node and return it
	{								//assumes non-empty list
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false;
		
		//in case of empty tree/queue
		if(root == null) return null;
		
		//find rightmost descendant (max node)
		while(current.rightChild != null)
		{
			parent = current;
			current = current.rightChild;
		}
		//found node to delete
		Node result = current;
		
		//if no children, simply delete it
		if(current.leftChild==null && current.rightChild==null)
		{
			if(current == root)
				root = null;
			else if(isLeftChild)		//disconnect deleted node from parent
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		
		//if no right child, replace with left subtree
		else if(current.rightChild == null)
		{
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		}
		
		//if no left child, replace with right subtree
		else if(current.leftChild == null)
		{
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}
		
		else		//two children, replace with in-order successor
		{
			//get successor of node to delete (current)
			Node successor = getSuccessor(current);
			
			//connect parent of current to successor instead
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			
			//connect successor to current's left child
			successor.leftChild = current.leftChild;
		}
		
		return result;
	} //end removeMax()
	
	private Node getSuccessor(Node delNode)
	{
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;		//go to right child
		while(current != null)					//and then go to left child
		{										//until there are none left
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != delNode.rightChild)		//if successor not right child,
		{										//make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
	
		return successor;
	} 
	
	public void traverse(int traverseType)
	{
		switch(traverseType)
		{
		case 1: 
				preOrder(root);
				break;
		case 2: 
				inOrder(root);
				break;
		case 3: 
				postOrder(root);
				break;
		}
		System.out.println("");
	}
	
	private void preOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}
	
	public void displayTree()
	{
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(".......................................................");
		
		while(isRowEmpty==false)
		{
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;
			
			for(int j = 0; j < nBlanks; j++)
				System.out.print(" ");
			
			while(globalStack.isEmpty() == false)
			{
				Node temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null ||
							temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j = 0; j < nBlanks*2 - 2; j++)
					System.out.print(" ");
			} 
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty() == false)
				globalStack.push( localStack.pop() );
		} 
		System.out.println(".......................................................");
	} 
} 

public class TreeApp
{
	public void test()
	{
		
		Tree theTree = new Tree();
		
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		
		theTree.displayTree();
		
		boolean didDelete = theTree.delete(93);
		didDelete = theTree.delete(97);
		didDelete = theTree.delete(30);
		didDelete = theTree.delete(25);
		didDelete = theTree.delete(37);
		didDelete = theTree.delete(75);
		
		if(didDelete)
			System.out.print("Deleted \n");
		else
			System.out.print("Could not delete \n");
		
		theTree.insert(44, 44 + 0.9);
		
		Node found = theTree.find(12);
		if(found != null)
		{
			System.out.print("Found: ");
			found.displayNode();
			System.out.print("\n");
		}
		else
			System.out.print("Could not find node \n");
		
		theTree.displayTree();
		theTree.traverse(1);
		theTree.traverse(2);
		theTree.traverse(3);
		
	} 
	
	
}