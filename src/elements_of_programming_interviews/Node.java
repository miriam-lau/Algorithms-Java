package elements_of_programming_interviews;


public class Node {
    // Declare member variables
    public int data;
    public Node next;

    // Constructor
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {
        Node a = new Node(4, null);
        Node b = new Node(9, null);
        Node c = new Node(2, null);

        System.out.println("CREATES A NODE");
        System.out.println(a.data);
        System.out.println(b.data);
        System.out.println(c.data);

        System.out.println("NEXT NODE IS NULL IF NODE IS NOT SET");
        System.out.println(a.next);

        System.out.println("SETS NEXT NODE IF NEXT NODE IS PASSED IN, NEXT NODE SHOULD EQUAL 5");
        Node e = new Node(5, null);
        Node d = new Node(15, e);
        System.out.println(d.next.data);

        System.out.println("CAN SET NEXT NODE");
        System.out.println("- NEXT NODE BEFORE, NEXT NODE SHOULD BE NULL");
        System.out.println(a.next);
        System.out.println("- NEXT NODE AFTER, NEXT NODE SHOULD EQUAL 9");
        a.next = b;
        System.out.println(a.next.data);
    }
}
