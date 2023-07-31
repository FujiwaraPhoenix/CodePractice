
public class TreeAlt {
	//A Tree is a structure that has one 'parent' node, from which any number of children nodes (who are siblings to one another) are connected.
	//For the purposes of this exercise, this will be a binary tree.
	//As a sort was not requested for this exercise, the tree will be unsorted.
	
	public TreeNode root;
	public int nodeCount;
	
	public void SetAsChild(TreeNode newParent, TreeNode newDescendant, boolean isLeft) {
		if (isLeft) {
			newParent.left = newDescendant;
		}
		else {
			newParent.right = newDescendant;
		}
		newDescendant.parent = newParent;
	}
	
	public void AddNode(TreeNode parent, int newData) {
		if (parent == null) {
			//Check if the root node is null. If it is, set this node as the root node.
			//There should always be a root node after the first node has been created unless the only node in
			//the tree has been removed.
			root = new TreeNode(newData);
			nodeCount++;
		}
		else {
			//Check if left is null, then right. If neither is null, do nothing.
			//We are not traversing the graph to add a node in THIS function.
			if (parent.left == null) {
				parent.left = new TreeNode(newData, parent);
				nodeCount++;
			}
			else if (parent.right == null) {
				parent.right = new TreeNode(newData, parent);
				nodeCount++;
			}
			else {
				System.out.println("The given node already has two child nodes.");
			}
		}
	}
	
	public void RemoveNode(TreeNode toBeRemoved) {
		//For the sake of brevity, we assume that all nodes are within the tree, and that 
		//we are not attempting to remove a node that is not within the tree.
		//First, we check if the node has two, one, or no children.
		boolean hasLeft = !(toBeRemoved.left == null);
		boolean hasRight = !(toBeRemoved.right == null);
		//If it has no children, we remove the node and the parent's reference to it.
		if (!hasLeft && !hasRight) {
			RemoveChild(toBeRemoved, toBeRemoved.parent);
		}
		//If it has one child, we replace this node with the child.
		else if (hasLeft && !hasRight) {
			ReplaceNode(toBeRemoved, toBeRemoved.left);
		}
		else if (hasRight && !hasLeft) {
			ReplaceNode(toBeRemoved, toBeRemoved.right);
		}
		//If it has two children, we replace this node with the right branch's leftmost child.
		//If that branch has no children, we replace this node with that child instead.
		else {
			ReplaceNode(toBeRemoved, FindDeepestOnSide(toBeRemoved, true));
		}
	}
	
	//This function can in theory be built to find the deepest node period.
	//This can be done by measuring the depth of the current position on the tree,
	//then only properly returning the deepest node on the given tree, prioritizing whichever
	//side is chosen. For the sake of the exercise, we are electing not to do so.
	public TreeNode FindDeepestOnSide(TreeNode startPoint, boolean leftPriority) {
		boolean hasLeft = !(startPoint.left == null);
		boolean hasRight = !(startPoint.right == null);
		if (!hasLeft && !hasRight) {
			System.out.println("Node found. Value of " + startPoint.data);
			return startPoint;
		}
		else {
			if (leftPriority) {
				if (hasLeft) {
					return FindDeepestOnSide(startPoint.left, leftPriority); 
				}
				else {
					return FindDeepestOnSide(startPoint.right, leftPriority); 
				}
			}
			else {
				if (hasRight) {
					return FindDeepestOnSide(startPoint.right, leftPriority); 
				}
				else {
					return FindDeepestOnSide(startPoint.left, leftPriority); 
				}
			}
		}
	}
	
	
	private void RemoveChild(TreeNode toBeRemoved, TreeNode parent) {
		//Check left, then right.
		//We only use this function within approved contexts.
		if (parent.left.equals(toBeRemoved)) {
			parent.left = null;
		}
		else if (parent.right.equals(toBeRemoved)) {
			parent.right = null;
		}
		else {
			//No child match. Failure state.
		}
	}
	
	public void ReplaceNode(TreeNode oldNode, TreeNode newNode) {
		//We assume that the new node has no children.
		ReplaceChild(oldNode, newNode, oldNode.parent);
	}
	
	private void ReplaceChild(TreeNode oldChild, TreeNode newChild, TreeNode parent) {
		//Check left, then right.
		//We only use this function within approved contexts.
		//If the new child had a parent, node count goes down.
		//Else, node count is unchanged.
		if (!(newChild.parent == null)) {
			nodeCount--;
		}
		if (parent.left.equals(oldChild)) {
			RemoveChild(newChild, newChild.parent);
			parent.left = newChild;
			newChild.parent = parent;
			newChild.left = oldChild.left;
			newChild.right = oldChild.right;
		}
		else if (parent.right.equals(oldChild)) {
			RemoveChild(newChild, newChild.parent);
			parent.right = newChild;
			newChild.parent = parent;
			newChild.left = oldChild.left;
			newChild.right = oldChild.right;
		}
		else {
			//No child match. Failure state.
		}
	}
	
	public class TreeNode{
		public int data;
		public TreeNode parent;
		public TreeNode left, right;
		
		public TreeNode(int newData) {
			data = newData;
		}
		
		public TreeNode(int newData, TreeNode newParent) {
			data = newData;
			parent = newParent;
		}
		
	}
}
