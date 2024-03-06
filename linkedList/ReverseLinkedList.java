package coding_practice.linkedList;


class Node{
    int val;
    Node next;
    Node random;

    public Node(int val){
        this.val = val;
    }
    public Node(int val,Node next,Node random){
        this.val = val;
        this.next = next;
        this.random = random;
    }
}


public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

       Node res =  reverse(head);
        while (res != null) {
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    public static Node reverse(Node head){
        Node cur = head;
        Node prev = null;
        Node next = null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
