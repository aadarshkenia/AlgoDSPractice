package linkedlist;

public class LinkedList {
	private ListNode head;
	
	//Create linkedlist of integers from array.
	public LinkedList(int[] items) {
		ListNode prev=null;
		for(int i : items) {
			if(prev == null) {
				prev = new ListNode(i);
				head = prev;
			} else {
				ListNode node = new ListNode(i);
				prev.next=node;
				prev = node;
			}
		}
	}

	public LinkedList(ListNode head) {
		this.head=head;
	}
	public LinkedList() {}
	public ListNode getHead() {
		return this.head;
	}

	@Override
	public String toString() {
		ListNode temp = head;
		StringBuilder sb = new StringBuilder();
		while(temp != null) {
			sb.append(temp.val + " ");
			temp = temp.next;
		}
		return sb.toString();
	}

}