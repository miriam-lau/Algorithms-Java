package elements_of_programming_interviews;


public class BTNode {
    public int data;
    public BTNode left;
    public BTNode right;
    public BTNode parent;

    public BTNode(int data, BTNode left, BTNode right, BTNode parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public static void main(String[] args) {
        BTNode A = new BTNode(1, null, null, null);
        BTNode B = new BTNode(2, null, null, null);
        BTNode C = new BTNode(3, null, null, null);
        BTNode D = new BTNode(4, null, null, null);
        BTNode E = new BTNode(5, null, null, null);
        BTNode F = new BTNode(6, null, null, null);
        BTNode G = new BTNode(7, null, null, null);
        BTNode H = new BTNode(8, null, null, null);

        A.left = B;
        A.right = C;

        B.parent = A;
        B.left = D;
        B.right = E;

        D.parent = B;

        E.parent = B;
        E.right = G;

        G.parent = E;

        C.parent = A;
        C.left = F;

        F.parent = C;
        F.right = H;

        H.parent = F;

        System.out.println("PARENT NODES");
        System.out.println(A.parent);
        System.out.println(B.parent.data);
        System.out.println(C.parent.data);
        System.out.println(D.parent.data);
        System.out.println(E.parent.data);
        System.out.println(F.parent.data);
        System.out.println(G.parent.data);
        System.out.println(H.parent.data);

        System.out.println("CHILDREN NODES");
        System.out.println("-A");
        System.out.println(A.left.data);
        System.out.println(A.right.data);

        System.out.println("-B");
        System.out.println(B.left.data);
        System.out.println(B.right.data);

        System.out.println("-C");
        System.out.println(C.left.data);
        System.out.println(C.right);

        System.out.println("-D");
        System.out.println(D.left);
        System.out.println(D.right);

        System.out.println("-E");
        System.out.println(E.left);
        System.out.println(E.right.data);

        System.out.println("-F");
        System.out.println(F.left);
        System.out.println(F.right.data);

        System.out.println("-G");
        System.out.println(G.left);
        System.out.println(G.right);

        System.out.println("-H");
        System.out.println(H.left);
        System.out.println(H.right);
    }
}
