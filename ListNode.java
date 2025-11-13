public class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class RemoveNode2 {
     public ListNode removeNodes(ListNode head) {
        ListNode rev = reverse(head);

        int max =rev.val;
        ListNode curr = rev;

        while (curr != null && curr.next != null){
            if ( curr.next.val < max){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }
         return reverse(rev);
    }

     private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(5,
                        new ListNode(2,
                        new ListNode(13,
                        new ListNode(3,
                        new ListNode(8)))));
         RemoveNode2 sol = new  RemoveNode2();
         ListNode ans = sol.removeNodes(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }

    }
}




