package coding_practice.linkedList;
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        next = null;
    }
}
public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node b1 = new Node(3);
        Node b2 = new Node(4);
        Node b3 = new Node(5);

        Node c1 = new Node(6);
        Node c2 = new Node(7);
        Node c3 = new Node(8);

        a1.next = a2;
        a2.next = c1;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        c1.next = c2;
        c2.next = c3;
        c3.next = null;

        System.out.println(intersection(a1, b1).val);

    }

    public static Node intersection(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;

            // this is a if else statement but the new features of java
        }

        return a;
    }
}
