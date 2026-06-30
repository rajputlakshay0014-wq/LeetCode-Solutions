class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] ans = new ListNode[k];

        int len = 0;

        for(ListNode cur = head; cur != null; cur = cur.next)
            len++;

        int size = len / k;
        int extra = len % k;

        ListNode curr = head;

        for(int i = 0; i < k; i++){

            ans[i] = curr;

            int partSize = size + (extra > 0 ? 1 : 0);

            if(extra > 0)
                extra--;

            for(int j = 1; j < partSize; j++)
                curr = curr.next;

            if(curr != null){

                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }

        return ans;
    }
}