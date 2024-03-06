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

public class CloneALinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.random = head.next.next;//1--->3
        head.next.random = head;//2--->1

        Node res = clone(head);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }

    public static Node clone(Node head){
        if(head == null){
            return null;
        }

        Node cur = head;

        //Inserting new Nodes In Between
        while(cur != null){
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }

        cur = head;

        //setting random pointers
        while(cur != null){
            cur.next.random = (cur.random != null && cur.random.next != null) ? cur.random.next : null;
            cur=cur.next.next;
        }
       
        Node orig = head,copy = head.next;
        Node temp = copy;

        while(orig != null){
            orig.next = orig.next.next;
            orig = orig.next;
            if(copy.next != null){
            copy.next = copy.next.next;
        }
            copy = copy.next;
        }
        return temp;

    }
}
