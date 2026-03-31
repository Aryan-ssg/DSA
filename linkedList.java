


class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class linkedList {
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2,n1);
        Node n3 = new Node(3,n2);
        Node n4 = new Node(4,n3);
        Node n5 = new Node(5,n4);
        
        System.out.println(n3.next.data);

    }

}
