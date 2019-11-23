/*

Blake Patterson
Homework 3

*/

import java.util.*;


public class BinTreeNode<T>
{

	private T key;

	private Object satelliteData;

	private BinTreeNode<T> parent;

	private BinTreeNode<T> leftChild;

	private BinTreeNode<T> rightChild;

	public BinTreeNode(T key, Object satelliteData)
	{

		this.key = key;

		this.satelliteData = satelliteData;

		this.parent = null;

		this.leftChild = null;

		this.rightChild = null;

	}

	public void addLeftChild(BinTreeNode<T> leftChildNode)
	{

		this.leftChild = leftChildNode;
	}

	public void addRightChild(BinTreeNode<T> rightChildNode)
	{
		this.rightChild = rightChildNode;

	}

	public void setParent(BinTreeNode<T> parentNode)
	{
		this.parent = parentNode;

	}

	public BinTreeNode<T> getParent()
	{
		return  parent;
	}

	public BinTreeNode<T> getLeftChild()
	{

		return leftChild;

	}

	public BinTreeNode<T> getRightChild()
	{
		return rightChild;
	}

	@Override
	public String toString()
	{

		String keyString;

		String dataString;

		if(this.key == null)
			keyString = "null";
		else
			keyString = this.key.toString();

		if(this.satelliteData == null)
			dataString = "null";
		else
			dataString = this.satelliteData.toString();

		return ("(" + keyString + "," + dataString + ")");


	}

}