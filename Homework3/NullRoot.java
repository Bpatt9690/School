// Devon Gadarowski 2019

// Empty trees are always balanced because every subtree in an empty tree has the same height (-1)
public class NullRoot
{
	public static void main(String [] args)
	{
		BinTree<Integer> tree = new BinTree<>();

		boolean balanced = tree.isBalanced();

		if (!balanced)
		{
			System.out.println("Oh no! An empty tree is always balanced!");
			return;
		}

		System.out.println("Success"); 
	}
}
