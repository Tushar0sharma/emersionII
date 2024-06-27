 class node{
    int val;
    node left;
    node right;
    node(int val){
        this.val=val;
    }
    node(int val,node left,node right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class maxDepth {
    public static void main(String[] args) {
        int []a={1,2,3,2,2,3,23,2,23,4232,2,2,33};
        node tree=create(a,0);
        System.out.println(depth(tree,1));
    }
    public static node create(int []a,int i){
        if(i>=a.length || a[i]==-1) return null;
        node root=new node(a[i]);
        root.left=create(a,i*2+1);
        root.right=create(a,i*2+1);
        return root;
    }
    public static int depth(node tree,int depth){
        if(tree==null) return depth-1;
        int l=depth(tree.left,depth+1);
        int r=depth(tree.right,depth+1);
        return Math.max(l,r);
    }


}
