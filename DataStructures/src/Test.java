public class Test {
	
	public static void main(String[] args) {
		//Testing alt ArrayList
		/*
		ArrayListAlt<String> a = new ArrayListAlt<String>(1);
		System.out.println(a.currentSize);
		a.Add("Hello");
		System.out.println(a.currentSize);
		a.Add("Goodbye");
		System.out.println(a.currentSize);
		System.out.println(a.Get(0));
		a.RemoveAt(0);
		System.out.println(a.Get(0));
		a.ReplaceAt(0, "Huh?");
		System.out.println(a.Get(0));
		*/
		
		//Testing alt Stack
		/*
		StackAlt<String> b = new StackAlt<String>();
		b.Push("Oh.");
		b.Push("Okay.");
		System.out.println(b.Peek());
		System.out.println(b.Pop());
		System.out.println(b.Peek());
		*/
		
		//Testing alt Queue
		/*
		QueueAlt<String> c = new QueueAlt<String>();
		c.Push("Oh.");
		c.Push("Okay.");
		System.out.println(c.Peek());
		System.out.println(c.Pop());
		System.out.println(c.Peek());
		*/
		
		//Testing alt Linked List
		/*
		LinkedListAlt<Integer> ll = new LinkedListAlt<Integer>();
		for (int i = 0; i < 10; i++) {
			ll.Add(i);
		}
		System.out.println(ll.start.data);
		System.out.println(ll.end.data);
		System.out.println("----------------");
		ll.InsertNodeAt(ll.MakeNode(0), 3);
		for (int i = 0; i < ll.nodeCount; i++) {
			System.out.println(ll.GetNode(i).data);
		}
		*/
		
		//Testing alt Graph
		/*
		GraphAlt<Integer> ga = new GraphAlt<Integer>();
		ga.AddNode(1, null);
		ga.ConnectNodes(ga.nodeArray[0], ga.MakeNode(3));
		ga.ConnectNodes(ga.nodeArray[0], ga.MakeNode(4));
		ga.ConnectNodes(ga.nodeArray[0].connected[0], ga.MakeNode(5));
		ga.RemoveNode(ga.nodeArray[2]);
		for (int i = 0; i < ga.nodeCount; i++) {
			System.out.println(ga.nodeArray[i].data);
		}
		*/
		
		//Testing alt Tree
		/*
		TreeAlt t = new TreeAlt();
		t.AddNode(null, 0);
		System.out.println(t.root.data);
		t.AddNode(t.root, 1);
		t.AddNode(t.root, 2);
		System.out.println(t.root.left.data);
		System.out.println(t.root.right.data);
		t.AddNode(t.root.left, 3);
		t.AddNode(t.root.left, 4);
		System.out.println(t.root.left.left.data);
		System.out.println(t.root.left.right.data);
		t.AddNode(t.root.left.right, 5);
		t.AddNode(t.root.left.right, 6);
		System.out.println(t.root.left.right.left.data);
		System.out.println(t.root.left.right.right.data);
		System.out.println("Node Count: " + t.nodeCount);
		t.RemoveNode(t.root.left.right);
		System.out.println("Node Count: " + t.nodeCount);

		System.out.println(t.root.data);
		System.out.println(t.root.left.data);
		System.out.println(t.root.right.data);
		System.out.println(t.root.left.left.data);
		System.out.println(t.root.left.right.data);
		System.out.println(t.root.left.right.left);
		System.out.println(t.root.left.right.right.data);
		*/
		
		//Testing alt HashMap
		
		HashMapAlt hm = new HashMapAlt();
		System.out.println(hm.GenerateHashCode("Okay"));
		System.out.println(hm.GenerateHashCode("But"));
		System.out.println(hm.GenerateHashCode("Why"));
		System.out.println(hm.GenerateHashCode("Though"));
		System.out.println(hm.GenerateHashCode("?"));
		hm.AddPair("Okay", 0);
		hm.AddPair("But", 1);
		hm.AddPair("Why", 2);
		hm.AddPair("Though", 3);
		hm.AddPair("?", 4);
		System.out.println(hm.FindData("Okay"));
		System.out.println(hm.FindData("But"));
		System.out.println(hm.FindData("Why"));
		System.out.println(hm.FindData("Though"));
		System.out.println(hm.FindData("?"));
		hm.RemovePair("Though");
		System.out.println(hm.FindData("Though"));
		System.out.println(hm.FindData("?"));
	}

}
