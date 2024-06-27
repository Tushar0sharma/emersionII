class node{
    int val;
    node left;
    node right;
    node(int val){
        this.val=val;
    }
    node (int val,node left,node right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class maxelement {
    
    public static void main(String[] args) {
        int []arr={1,2,34,5,868,758};
        node root=create(arr,0);
        System.out.println(call(root));
    }
    public static int call(node root){
        if(root==null) return Integer.MIN_VALUE; 
        int l=call(root.left);
        int r=call(root.right);
        int ans=Math.max(l,r);
        return Math.max(ans,root.val);
    }
    public  static node create(int []a,int i){
        if(i>=a.length || a[i]==-1) return null;
        node n=new node(a[i]);
        n.left=create(a,2*i+1);
        n.right=create(a,2*i+2);
        return n;
    }
    
}