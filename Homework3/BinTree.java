import java.util.*;

public class BinTree<T> 
{
	private BinTreeNode<T> root;


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

		int leftHeight, rightHeight, diff;

		if(this.root == null)
			return false;

		else if(this.root != null)
		{


			leftHeight = leftTree();

			rightHeight = rightTree();

			balance = leftHeight - rightHeight;

			Math.abs(balance);

			System.out.println(balance);

			if(balance <= 1)
				return true;

			else if(diff > 1)
				return false;

		}

		return false;
	}

	public int leftTree(BinTreeNode<T> node)
	{
		if(node == null)
			return 0;

		
		return 0;

	}


	public int rightTree()
	{

	return 0;

	}
}
