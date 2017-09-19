import linkedlist.ListNode;
class _148 {
	public ListNode sortList(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	ListNode pivot = head;
    	ListNode curr = pivot.next, prev = pivot;
    	ListNode leftPtr, leftHead;
    	while(curr != null) {
    		if(curr.val < pivot.val) {
    			if(leftHead == null){
    				leftHead = curr;
    			}
    			if(leftPtr != null) {
                    leftPtr.next = curr;    
                }   
    			leftPtr = curr;
    			prev.next = curr.next;
    			curr.next = pivot;
    			curr = prev.next;
    		} else {
    			curr = curr.next;
    			prev = prev.next;
    		}
    	}
    	l//Sort left sublist
    	if(leftHead != null) {
            leftPtr.next = null;
            leftHead = sortList(leftHead);
        }
    	//Sort left, right sublists
    	pivot.next = sortList(pivot.next);
    	if(leftHead == null) {
    		return pivot;
    	}
    	curr = leftHead;
    	while(curr.next != null){
    		curr = curr.next;
    	}
    	curr.next = pivot;
    	return leftHead;
    }
}