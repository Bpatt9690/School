import java.util.*

public class BinTree
{

	public void addLeftChild(BinTreeNode leftChildNode);

	public void addRightChild(BinTreeNode rightChildNode);

	public void setParent(BinTreeNode parentNode);

	public BinTreeNode<T> getParent();

	public BinTreeNode<T> getLeftChild();

	public BinTreeNode<T> getRightChild();

	public class BinTree<T>
	{


		private BinTreeNode<T> root;


	}

	public BinTreeNode<T> getRoot();

	public void setRoot(BinTreeNode<T>);

	public boolean isBalanced();

}