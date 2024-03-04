package coding_practice.linkedList;

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = null;

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = null;
        ListNode ans = sum(l1, l2);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    public static ListNode sum(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode ptr = result;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0 + carry;

            // Use Number From First List
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Use Number From Second List
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // get carry and sum

            carry = sum / 10;
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if (carry == 1)
            ptr.next = new ListNode(1);

        return result.next;
    }
}
