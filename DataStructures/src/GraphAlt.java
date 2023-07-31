public class GraphAlt<E> {
	
	//A graph is composed on multiple nodes that are connected by one or more vertices.
	//For the sake of this exercise, this class will function as a generic graph with no directions, weights or other factors in that vein.
	
	GraphNode<E>[] nodeArray;
	int INITIAL_ARRAY_LENGTH = 10;
	int nodeCount = 0;
	
	//Initializes an empty graph.
	public GraphAlt() {
		nodeArray = (GraphNode<E>[])new GraphNode[INITIAL_ARRAY_LENGTH];
	}
	
	//Creates a new node with the given data.
	public GraphNode<E> MakeNode(E newNodeData) {
		GraphNode<E> newNode = new GraphNode<E>(newNodeData);
		AddNodeToCollection(newNode);
		return newNode;
	}
	
	//Adds a new node to the graph.
	public void AddNode(E newNodeData, GraphNode<E>[] connectedNodes) {
		GraphNode<E> newNode = new GraphNode<E>(newNodeData);
		if (connectedNodes != null) {
			newNode.connected = connectedNodes;
			newNode.connectionCount = connectedNodes.length;
			for (int i = 0; i < newNode.connectionCount; i++) {
				connectedNodes[i].AddConnection(newNode);
			}
		}
		AddNodeToCollection(newNode);
	}
	
	public void AddNode(GraphNode<E> newNode, GraphNode<E>[] connectedNodes) {
		if (connectedNodes != null) {
			newNode.connected = connectedNodes;
			newNode.connectionCount = connectedNodes.length;
			for (int i = 0; i < newNode.connectionCount; i++) {
				connectedNodes[i].AddConnection(newNode);
			}
		}
		AddNodeToCollection(newNode);
	}
	
	//Connects a pair of nodes.
	public void ConnectNodes(GraphNode<E> nodeA, GraphNode nodeB) {
		nodeA.AddConnection(nodeB);
		nodeB.AddConnection(nodeA);
	}
	
	//Removes a node from all other nodes.
	public void RemoveNode(GraphNode<E> toBeRemoved) {
		for (int i = 0; i < toBeRemoved.connectionCount; i++) {
			toBeRemoved.connected[i].RemoveConnectionTo(toBeRemoved);
		}
		RemoveNodeFromCollection(toBeRemoved);
	}
	
	public void AddNodeToCollection(GraphNode<E> targetNode) {
		if (nodeCount > nodeArray.length) {
			IncreaseSize();
		}
		nodeArray[nodeCount] = targetNode;
		nodeCount++;
	}
	
	public void RemoveNodeFromCollection(GraphNode<E> toBeRemoved) {
		if (NodeInCollection(toBeRemoved)) {
			int nodeIndex = GetIndexOfNode(toBeRemoved);
			System.arraycopy(nodeArray, nodeIndex + 1, nodeArray, nodeIndex, nodeCount - nodeIndex);
			for (int i = 0; i < toBeRemoved.connectionCount; i++) {
				toBeRemoved.connected[i].RemoveConnectionTo(toBeRemoved);
			}
			nodeCount--;
		}
	}
	
	private boolean NodeInCollection(GraphNode<E> targetNode) {
		for (int i = 0; i < nodeCount; i++) {
			if (nodeArray[i].equals(targetNode)) {
				return true;
			}
		}
		return false;
	}
	
	private int GetIndexOfNode(GraphNode<E> targetNode) {
		if (NodeInCollection(targetNode)) {
			for (int i = 0; i < nodeCount; i++) {
				if (targetNode.equals(nodeArray[i])) {
					return i;
				}
			}
		}
		return -1;
	}
	
	private void IncreaseSize() {
		int newSize = (int)(nodeArray.length * 1.5f) + 2;
		System.out.println("New size: " + newSize);
		GraphNode<E>[] newArray = (GraphNode<E>[])new GraphNode[newSize];
		for(int i = 0; i < nodeArray.length; i++) {
			newArray[i] = (GraphNode<E>)nodeArray[i];
		}
		nodeArray = newArray;
	}
	
	public class GraphNode<E>{
		E data;
		GraphNode<E>[] connected;
		int INITIAL_ARRAY_LENGTH = 10;
		int connectionCount;
		
		public GraphNode(E newObj) {
			data = newObj;
			connected = (GraphNode<E>[]) new GraphNode[INITIAL_ARRAY_LENGTH];
			connectionCount = 0;
		}
		
		public E Get() {
			return data;
		}
		
		private void IncreaseSize() {
			int newSize = (int)(connected.length * 1.5f) + 2;
			System.out.println("New size: " + newSize);
			GraphNode<E>[] newArray = (GraphNode<E>[])new GraphNode[newSize];
			for(int i = 0; i < connected.length; i++) {
				newArray[i] = (GraphNode<E>)connected[i];
			}
			connected = newArray;
		}
		
		public void AddConnection(GraphNode<E> newConnection) {
			//Check if a connection already exists.
			if (!HasConnectionTo(newConnection)) {
				if (connectionCount > connected.length) {
					IncreaseSize();
				}
				connected[connectionCount] = newConnection;
				connectionCount++;
			}
		}
		
		public void RemoveConnectionTo(GraphNode<E> targetNode) {
			//If the given node exists within the list of connections, remove THIS node from their connections list.
			//Then, remove that node from this node's connection list.
			if (HasConnectionTo(targetNode)) {
				int indexOfSelf = FindConnectionIndex(targetNode);
				System.arraycopy(targetNode.connected, indexOfSelf + 1, targetNode.connected, indexOfSelf, targetNode.connectionCount - indexOfSelf);
				targetNode.connectionCount--;
				int indexOfTarget = targetNode.FindConnectionIndex(this);
				System.arraycopy(targetNode.connected, indexOfTarget + 1, targetNode.connected, indexOfTarget, targetNode.connectionCount - indexOfTarget);
				connectionCount--;
			}
		}
		
		//Iterate through own array to find index of target node.
		public int FindConnectionIndex(GraphNode<E> targetNode) {
			if (HasConnectionTo(targetNode)) {
				for (int i = 0; i < targetNode.connectionCount; i++) {
					if (targetNode.connected[i].equals(targetNode)) {
						return i;
					}
				}
			}
			return -1;
		}
		
		public boolean HasConnectionTo(GraphNode<E> node) {
			for (int i = 0; i < connectionCount; i++) {
				if (((GraphAlt<E>.GraphNode<E>) connected[i]).Get().equals(node)) {
					return true;
				}
			}
			return false;
		}
	}
}
