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
public class check {
    
    public static void main(String[] args) {
        int []arr={};
        int []arr1={1,2,34,5};
        node root1=create(arr,0);
        node root2=create(arr1,0);
        System.out.println(call(root1,root2));
    }
    public static boolean call(node root1,node root2){
        if(root1==null && root2==null) return true;
        if((root1==null && root2!=null)||(root1!=null && root2==null)) return false;
        if(root1.val!=root2.val) return false;
        
        if(!call(root1.left,root2.left)) return false;
        if(!call(root2.right,root2.right)) return false;
        
        return true;
    }
    public  static node create(int []a,int i){
        if(i>=a.length || a[i]==-1) return null;
        node n=new node(a[i]); 
        n.left=create(a,2*i+1);
        n.right=create(a,2*i+2);
        return n;
    }
    
}