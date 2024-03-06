package coding_practice.linkedList;

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        next = null;
    }
}

public class FindMiddleOfLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

      System.out.println(middle(head).val);
    }

    public static Node middle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
