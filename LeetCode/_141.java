import linkedlist.*;

class _141 {
	
	public static void main(String args[]) {
		int arr[] = {1,2,3,4};
		ListNode head = new LinkedList(arr).getHead();
		
		head = new ListNode(1);
		head.next=head;
		// System.out.println(ll);
		
		System.out.println(new _141().hasCycle(head));
	}
	public boolean hasCycle(ListNode head) {
   		ListNode slow=head, fast=head; 
   		boolean initialFlag = true;
   		while(slow!= null && fast != null && fast.next != null) {
   			if(slow == fast && !initialFlag) {
   				return true;
   			}
   			slow=slow.next;
   			fast=fast.next.next;
   			initialFlag = false;
   		}
   		return false; 
    }
}