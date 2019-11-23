/*

Blake Patterson
Homework 3

*/

import java.util.*;

public class BinTree<T> 
{
	private BinTreeNode<T> root;

	public int leftTreeHeight;

	public int rightTreeHeight;

	public BinTreeNode<T> getRoot()
	{

		return this.root;
	}

	public void setRoot(BinTreeNode<T> root)
	{

		this.root = root;

	}

	public boolean isBalanced()
	{

		int leftHeight, rightHeight, balance;

		if(this.root == null)
			return true;

		else if(this.root != null)
		{

			if(treeHeight(root) <= 1)
				return true;

			else
				return false;

		}

		return false;
	}

	public static int treeHeight(BinTreeNode node)
	{

		if(node == null)
			return -1;

		
		int leftHeight = treeHeight(node.getLeftChild());

		int rightHeight = treeHeight(node.getRightChild());

		int currentHeight = Math.abs(leftHeight-rightHeight)+1;

		return currentHeight;

	}


}
