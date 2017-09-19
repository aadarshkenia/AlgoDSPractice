import linkedlist.*;
class _143 {

    public static void main(String args[]) {
        int x[] = {1,2,3};
        LinkedList ll = new LinkedList(x);
        System.out.println(ll);
        new _143().reorderList(ll.getHead());
        System.out.println(ll);
    }

    public void print(ListNode head) {
        ListNode temp = head;
        StringBuilder sb = new StringBuilder();
        while(temp != null) {
            sb.append(temp.val + " ");
            temp = temp.next;
        }
        System.out.println(sb.toString());
    }

	public void reorderList(ListNode head) {
           if(head == null) {
                return;
           }
           //Get mid of linkedlist.
           ListNode mid = getMid(head);
           
           //Reverse the part after middle node
           ListNode start2 = reverse(mid.next);           

           mid.next = null;

           //Merge
           ListNode start1 = head;
           while(start2 != null) {
                ListNode temp1 = start1.next;
                ListNode temp2 = start2.next;
                start1.next = start2;
                start2.next = temp1;
                start1 = temp1;
                start2 = temp2;
           } 
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;                
        }
        return prev;
    }
}