// Devon Gadarowski 2019
//
//                                       +=======+
//                                       |  14   |
//                                       |banana |
//                                       +=======+
//                                        |
//                          ---------------
//                          |
//                      +=======+
//                      |  777  |
//                      |orange |
//                      +=======+
//                       |     |
//                --------     --------
//                |                   |
//            +=======+           +=======+
//            |  49   |           |  343  |
//            |forest |           |trees  |
//            +=======+           +=======+
//             /
//        +=======+
//        |  7777 |
//        | ocean |
//        +=======+
//

import java.util.HashMap;

public class UnbalancedExample
{
	public static void main(String [] args)
	{
		BinTree<Integer> tree = new BinTree<>();

		HashMap<String, BinTreeNode<Integer>> nodes = new HashMap<>();
		nodes.put("banana", new BinTreeNode<Integer>(14, "banana"));
		nodes.put("orange", new BinTreeNode<Integer>(777, "orange"));
		nodes.put("forest", new BinTreeNode<Integer>(49, "forest"));
		nodes.put("ocean", new BinTreeNode<Integer>(7777, "ocean"));
		nodes.put("trees", new BinTreeNode<Integer>(343, "trees"));

		buildTree(tree, nodes);

		if (tree.isBalanced())
		{
			System.out.println("Oh no! This tree is not balanced!");
			return;
		}

		System.out.println("Amazing Work");
	}

	private static void buildTree(BinTree<Integer> tree, HashMap<String, BinTreeNode<Integer>> nodes)
	{
		tree.setRoot(nodes.get("banana"));

		nodes.get("banana").addLeftChild(nodes.get("orange"));
		nodes.get("orange").setParent(nodes.get("banana"));

		nodes.get("orange").addLeftChild(nodes.get("forest"));
		nodes.get("forest").setParent(nodes.get("orange"));

		nodes.get("orange").addRightChild(nodes.get("trees"));
		nodes.get("trees").setParent(nodes.get("orange"));

		nodes.get("forest").addLeftChild(nodes.get("ocean"));
		nodes.get("ocean").setParent(nodes.get("forest"));
	}
}
