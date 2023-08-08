
public class Solution02 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int firstNum = LinkedListTotal(0, l1);
        System.out.println(firstNum);
        int secondNum = LinkedListTotal(0, l2);
        System.out.println(secondNum);
        int sum = firstNum + secondNum;
        System.out.println(sum);
        ListNode start = new ListNode(sum % 10);
        CompileList(sum / 10, start);
        return start;
    }
	
	//The numbers are in reverse order, so we want to just keep adding to a value to get the output.
	
	public int LinkedListTotal(int baseValue, ListNode start) {
		int output = baseValue + start.val;
		if (start.next == null) {
			return output;
		}
		else {
			return LinkedListTotal(output*10, start.next);
		}
	}
	
	//Keep getting x % 10 from the start, then divide the value by 10 to get the next number to use.
	//Repeat until x < 10, at which point the loop ends.
	public void CompileList(int startingValue, ListNode currentNode) {
		//We already have the first node established, so we proceed until the list is done.
		currentNode.next = new ListNode(startingValue % 10);
		System.out.println("Starting value: " + startingValue + "; created node with value of "+ currentNode.next.val);
		if (startingValue > 9)
		{
			CompileList(startingValue / 10, currentNode.next);
		}
	}
	
	//For testing purposes.
	public ListNode ConvertArray(int[] input) {
		ListNode start = new ListNode(input[0]);
		ListNode current = start;
		for (int i = 1; i < input.length; i++) {
			current.next = new ListNode(input[i]);
			current = current.next;
		}
		return start;
	}
	
	
	//Node class declared locally.
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		}
	
	public static void main(String[] args) {
		Solution02 sol02 = new Solution02();
		int[] testA = new int[] {9,9,9,9,9,9,9};
		int[] testB = new int[] {9,9,9,9};
		ListNode lnA = sol02.ConvertArray(testA);
		ListNode lnB = sol02.ConvertArray(testB);
		ListNode start = sol02.addTwoNumbers(lnA, lnB);
		while (start != null) {
			System.out.println(start.val);
			start = start.next;
		}
	}
}
