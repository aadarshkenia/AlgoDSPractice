import linkedlist.ListNode;
import linkedlist.LinkedList;
import tree.TreeNode;
class _109 {
	public static void main(String args[]) {
		int x[] = {1,2,3};
		LinkedList linkedlist = new LinkedList(x);
		new _109().sortedListToBST(linkedlist.getHead());
	}

	public TreeNode sortedListToBST(ListNode head) {
     	if(head == null){
     		return null;
     	}
     	ListNode mid = mid(head);     	
     	ListNode nextHead = mid.next;
     	mid.next = null;  
     	TreeNode midNode = new TreeNode(mid.val);
     	midNode.left = sortedListToBST(head);
     	midNode.right = sortedListToBST(nextHead); 
    	return midNode;
    }

//Returns mid and sets next value of mid's previous to null;
    private ListNode mid(ListNode head) {
    	ListNode slow = head, fast = head;
    	ListNode prev = null;
    	while(fast != null && fast.next != null) {
    		if(prev == null) {
    			prev = slow;
    		}
    		// print(head);
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	if(prev != null){
    		prev.next = null;
    	}
    	return slow;
    }

    private void print(ListNode l) {
    	while(l!= null) {    		
    		l=l.next;
    	}
    }
}