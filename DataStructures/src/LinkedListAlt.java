public class LinkedListAlt<E> {
	public LLNode<E> start, end;
	public int nodeCount = 0;
	
	//Initializes an empty linked list.
	public LinkedListAlt() {
	}
	
	public void Add(E newData) {
		if (start == null) {
			start = new LLNode<E>(newData, null);
			end = start;
		}
		else {
				LLNode<E> newNode = new LLNode<E>(newData, end);
				end.next = newNode;
				end = newNode;
		}
		nodeCount++;
	}
	
	//TODO: Add functionality to protect this code from invalid inputs.
	public void RemoveNode(LLNode<E> node) {
		LLNode<E> left = node.previous;
		LLNode<E> right = node.next;
		if (left == null && right == null) {
			//This is the only node in the set, and therefore we remove the start and end pointers.
			start = null;
			end = null;
		}
		else if (left == null) {
			//This is the starting node, but there is more than one node.
			right.previous = null;
			start = right;
		}
		else if (right == null) {
			//This is the last node in a set with >1 node.
			end = left.next;
			left.next = null;
		}
		else {
			left.next = right;
			right.previous = left;
		}
		nodeCount--;
	}
	

	public void RemoveNodeAt(int index) {
		ValidityCheck(index);
		LLNode<E> toBeRemoved = GetNode(index);
		RemoveNode(toBeRemoved);
	}
	
	public void InsertNode(LLNode<E> newNext, LLNode<E> newNode) {
		LLNode<E> left = newNext.previous;
		if (left== null) {
			//This is the first node in a set with >1 node.
			newNext.previous = newNode;
			newNode.previous = null;
		}
		else {
			left.next = newNode;
			newNext.previous = newNode;
			newNode.previous = left;
			newNode.next = newNext;
		}
		nodeCount++;
	}
	
	public void InsertNodeAt(LLNode<E> newNode, int index) {
		LLNode<E> insertionPoint = GetNode(index);
		InsertNode(insertionPoint, newNode);
	}
	
	public void ReplaceNode(LLNode<E> oldNode, LLNode<E> newNode) {
		LLNode<E> left = oldNode.previous;
		LLNode<E> right = oldNode.next;
		if (left== null && right== null) {
			//This is the only node in the set.
			start = newNode;
			end = newNode;
		}
		else if (left== null) {
			//This is the starting node, but there is more than one node.
			right.previous = newNode;
			start = newNode;
		}
		else if (right== null) {
			//This is the last node in a set with >1 node.
			left.next = newNode;
			end = newNode;
		}
		else {
			left.next = newNode;
			right.previous = newNode;
		}
	}

	public void ReplaceNode(LLNode<E> oldNode, E newNodeData) {
		oldNode.data = newNodeData;
	}
	
	public LLNode<E> MakeNode(E newNodeData){
		return new LLNode<E>(newNodeData, null);
	}
	
	public LLNode<E> GetNode(int index){
		ValidityCheck(index);
		LLNode<E> output = start;
		for (int i = 0; i < index; i++) {
			output = output.next;
		}
		return output;
	}
	private void ValidityCheck(int input) {
		if (input > nodeCount - 1) {
			throw new IllegalArgumentException();
		}
	}
	
	public class LLNode<E>{
		public LLNode<E> previous, next;
		E data;
		
		public LLNode(E newObj, LLNode<E> prev) {
			previous = prev;
			data = newObj;
		}
		
		public E Get() {
			return data;
		}
	}
}

