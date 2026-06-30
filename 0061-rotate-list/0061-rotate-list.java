class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0)
            return head;

        int len = 1;
        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        k %= len;

        if(k == 0)
            return head;

        tail.next = head;

        for(int i = 0; i < len - k; i++)
            tail = tail.next;

        head = tail.next;
        tail.next = null;

        return head;
    }
}