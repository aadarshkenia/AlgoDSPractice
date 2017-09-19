import linkedlist.ListNode;


class _142 {
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.next = two;
		two.next=null;
		System.out.println(new _142().detectCycle(head));
	}

	public ListNode detectCycle(ListNode head) {
 	   		ListNode slow=head, fast=head; 
	   		boolean initialFlag = true;
	   		while(slow!= null && fast != null && fast.next != null) {
	   			if(slow == fast && !initialFlag) {
	   				break; //Break out of the loop when the nodes meet
	   			}
	   			slow=slow.next;
	   			fast=fast.next.next;
	   			initialFlag = false;
	   		}
   			//No cycle
	   		if(slow == null || fast == null || fast.next == null) {
	   			return null;
	   		}	

	   		//Detect the start node of loop
	   		ListNode runner = head;
	   		while(slow != runner) {
	   			runner = runner.next;
	   			slow = slow.next;
	   		}

	   		return runner;
    }
}