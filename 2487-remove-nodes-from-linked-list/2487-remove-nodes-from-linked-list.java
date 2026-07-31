class Solution {

    public ListNode removeNodes(ListNode head) {

        head = reverse(head);

        int max = head.val;

        ListNode curr = head;

        while(curr != null && curr.next != null){

            if(curr.next.val < max){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
                max = curr.val;
            }
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head){

        ListNode prev = null;

        while(head != null){

            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}