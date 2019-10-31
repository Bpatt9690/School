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

		parent = null;
		leftChild = null;
		rightChild = null;


	}


	public void addLeftChild(BinTreeNode leftChildNode)
	{


	}

	public void addRightChild(BinTreeNode rightChildNode)
	{
		this.rightChild = rightChildNode;

	}

	public void setParent(BinTreeNode parentNode)
	{

	}

	public BinTreeNode<T> getParent()
	{





		return null;

	}

	public BinTreeNode<T> getLeftChild()
	{
		return null;

	}

	public BinTreeNode<T> getRightChild()
	{
		return rightChildNode;

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