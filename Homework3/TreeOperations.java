// Devon Gadarowski 2019
//
//                                       +=======+
//                                       |  14   |
//                                       |banana |
//                                       +=======+
//                                        |     |
//                          ---------------     ----------------
//                          |                                  |
//                      +=======+                          +=======+
//                      |  777  |                          |  117  |
//                      |orange |                          |spartan|
//                      +=======+                          +=======+
//                       |     |                            |
//                --------     --------              --------
//                |                   |              |
//            +=======+           +=======+      +=======+
//            |  49   |           |  343  |      |   7   |
//            |forest |           |trees  |      |canada |
//            +=======+           +=======+      +=======+
//             /
//        +=======+
//        |  7777 |
//        | ocean |
//        +=======+
//
//
// This test creates the tree above using BinTree and BinTreeNode methods. If the tree is built
// correctly we expect the following traversals:
//
// preorder traversal:  banana, orange, forest, ocean, trees, spartan, canada
// inorder traversal:   ocean, forest, orange, trees, banana, canada, spartan
// postorder traversal: ocean, forest, trees, orange, canada, spartan, banana
//

import java.util.HashMap;
import java.util.ArrayList;

public class TreeOperations
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
		nodes.put("spartan", new BinTreeNode<Integer>(117, "spartan"));
		nodes.put("canada", new BinTreeNode<Integer>(7, "canada"));

		ArrayList<BinTreeNode<Integer>> expectedPreorder = new ArrayList<>();
		expectedPreorder.add(nodes.get("banana"));
		expectedPreorder.add(nodes.get("orange"));
		expectedPreorder.add(nodes.get("forest"));
		expectedPreorder.add(nodes.get("ocean"));
		expectedPreorder.add(nodes.get("trees"));
		expectedPreorder.add(nodes.get("spartan"));
		expectedPreorder.add(nodes.get("canada"));

		ArrayList<BinTreeNode<Integer>> expectedInorder = new ArrayList<>();
		expectedInorder.add(nodes.get("ocean"));
		expectedInorder.add(nodes.get("forest"));
		expectedInorder.add(nodes.get("orange"));
		expectedInorder.add(nodes.get("trees"));
		expectedInorder.add(nodes.get("banana"));
		expectedInorder.add(nodes.get("canada"));
		expectedInorder.add(nodes.get("spartan"));

		ArrayList<BinTreeNode<Integer>> expectedPostorder = new ArrayList<>();
		expectedPostorder.add(nodes.get("ocean"));
		expectedPostorder.add(nodes.get("forest"));
		expectedPostorder.add(nodes.get("trees"));
		expectedPostorder.add(nodes.get("orange"));
		expectedPostorder.add(nodes.get("canada"));
		expectedPostorder.add(nodes.get("spartan"));
		expectedPostorder.add(nodes.get("banana"));

		// Make sure nodes were created properly
		for (BinTreeNode<Integer> node : nodes.values())
			if (!nodeConstructionTest(node))
				return;

		// Attempt to create the tree
		if(!createTreeTest(tree, nodes))
			return;

		// Check our three traversals

		// Check preorder traversal
		ArrayList<BinTreeNode<Integer>> preorder = new ArrayList<>();
		preorderTraversal(tree.getRoot(), preorder);
		if (!preorder.equals(expectedPreorder))
		{
			System.out.println("Oh no! Your tree nodes are all out of order!");
			return;
		}

		// Check inorder traversal
		ArrayList<BinTreeNode<Integer>> inorder = new ArrayList<>();
		inorderTraversal(tree.getRoot(), inorder);
		if (!inorder.equals(expectedInorder))
		{
			System.out.println("Oh no! Your tree nodes are all out of order!");
			return;
		}

		// Check postorder traversal
		ArrayList<BinTreeNode<Integer>> postorder = new ArrayList<>();
		postorderTraversal(tree.getRoot(), postorder);
		if (!postorder.equals(expectedPostorder))
		{
			System.out.println("Oh no! Your tree nodes are all out of order!");
			return;
		}

		System.out.println("Tree created successfully! :)");
	}

	private static boolean nodeConstructionTest(BinTreeNode<Integer> node)
	{
		if (node.getLeftChild() != null)
		{
			System.out.println("Oh no! Your nodes should have null left childen when they are constructed.");
			return false;
		}

		if (node.getRightChild() != null)
		{
			System.out.println("Oh no! Your nodes should have null right childen when they are constructed");
			return false;
		}

		if (node.getParent() != null)
		{
			System.out.println("Oh no! Your nodes should have null parents when they are constructed");
			return false;
		}

		return true;
	}

	// Constructs the tree at the beginning of this file
	private static boolean createTreeTest(BinTree<Integer> tree, HashMap<String, BinTreeNode<Integer>> nodes)
	{
		if(!setRootTest(tree, nodes.get("banana")))
			return false;

		if(!setLeftChildTest(nodes.get("banana"), nodes.get("orange")))
			return false;

		if(!setRightChildTest(nodes.get("banana"), nodes.get("spartan")))
			return false;

		if(!setLeftChildTest(nodes.get("orange"), nodes.get("forest")))
			return false;

		if(!setRightChildTest(nodes.get("orange"), nodes.get("trees")))
			return false;

		if(!setLeftChildTest(nodes.get("forest"), nodes.get("ocean")))
			return false;

		if(!setLeftChildTest(nodes.get("spartan"), nodes.get("canada")))
			return false;

		return true;
	}

	private static boolean setRootTest(BinTree<Integer> tree, BinTreeNode<Integer> root)
	{
		tree.setRoot(root);

		if (tree.getRoot() != root)
		{
			System.out.println("Oh no! setRoot() or getRoot() (or both) is not working correctly!");
			return false;
		}

		return true;
	}

	private static boolean setParentTest(BinTreeNode<Integer> parent, BinTreeNode<Integer> child)
	{
		BinTreeNode<Integer> oldLeftChild = parent.getLeftChild();
		BinTreeNode<Integer> oldRightChild = parent.getRightChild();

		child.setParent(parent);

		if (child.getParent() != parent)
		{
			System.out.println("Oh no! setParent() or getParent() (or both) is not working correctly!");
			return false;
		}

		if (parent.getLeftChild() != oldLeftChild || parent.getRightChild() != oldRightChild)
		{
			System.out.println("Oh no! setParent() should only change the parent of a node (not children)!");
			return false;
		}

		return true;
	}

	private static boolean setLeftChildTest(BinTreeNode<Integer> parent, BinTreeNode<Integer> leftChild)
	{
		BinTreeNode<Integer> oldParent = leftChild.getParent();

		parent.addLeftChild(leftChild);

		if (parent.getLeftChild() != leftChild)
		{
			System.out.println("Oh no! Your addLeftChild() or getLeftChild() (or both) is not working correctly!");
			return false;
		}

		if (leftChild.getParent() != oldParent)
		{
			System.out.println("Oh no! addLeftChild() should only change the child of a node (not parents)!");
			return false;
		}

		if (!setParentTest(parent, leftChild))
			return false;

		return true;	
	}

	private static boolean setRightChildTest(BinTreeNode<Integer> parent, BinTreeNode<Integer> rightChild)
	{
		BinTreeNode<Integer> oldParent = rightChild.getParent();

		parent.addRightChild(rightChild);

		if (parent.getRightChild() != rightChild)
		{
			System.out.println("Oh no! Your addRightChild() or getRightChild() (or both) is not working correctly!");
			return false;
		}

		if (parent.getRightChild().getParent() != oldParent)
		{
			System.out.println("Oh no! addRightChild() should only change the child of a node (not parents)!");
			return false;
		}

		if (!setParentTest(parent, rightChild))
			return false;

		return true;	
	}

	private static void preorderTraversal(BinTreeNode<Integer> currentNode, ArrayList<BinTreeNode<Integer>> list)
	{
		if (currentNode == null)
			return;

		list.add(currentNode);
		preorderTraversal(currentNode.getLeftChild(), list);
		preorderTraversal(currentNode.getRightChild(), list);
	}

	private static void inorderTraversal(BinTreeNode<Integer> currentNode, ArrayList<BinTreeNode<Integer>> list)
	{
		if (currentNode == null)
			return;

		inorderTraversal(currentNode.getLeftChild(), list);
		list.add(currentNode);
		inorderTraversal(currentNode.getRightChild(), list);
	}

	private static void postorderTraversal(BinTreeNode<Integer> currentNode, ArrayList<BinTreeNode<Integer>> list)
	{
		if (currentNode == null)
			return;

		postorderTraversal(currentNode.getLeftChild(), list);
		postorderTraversal(currentNode.getRightChild(), list);
		list.add(currentNode);
	}
}
