class Node{
    Node left;
    Node right;
    int val;
    Node (int val){
        this.val = val;
    }
    Node(int val,Node left,Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class generate {
    public static void main(String[] args) {
        int []a={2,34,55,45,35,35,5,35,454};
        Node aa=create(a,0);
        preorder(aa);
    }
    public  static Node create(int []a,int i){
        if(i>=a.length || a[i]==-1) return null;
        Node n=new Node(a[i]);
        n.left=create(a,2*i+1);
        n.right=create(a,2*i+2);
        return n;
    }
    public static void preorder(Node tree ){
        if(tree==null) return;
        System.out.println(tree.val);
        preorder(tree.left);
        preorder(tree.right);
    }
}
