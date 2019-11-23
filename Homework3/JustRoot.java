// Devon Gadarowski 2019

// A binary tree with just a root node is always balanced.
public class JustRoot
{
	public static void main(String [] args)
	{
		BinTree<String> tree = new BinTree<>();

		tree.setRoot(new BinTreeNode<String>("hope this works", 99));

		if (!tree.isBalanced())
		{
			System.out.println("Oh no! A tree with only a root element is always balanced.");
			return;
		}

		System.out.println("Amazing Work");
	}
}
