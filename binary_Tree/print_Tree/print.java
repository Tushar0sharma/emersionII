class node{
    int val;
    node left;
    node right;
    public node(int v){
        this.val=v;
        this.left=null;
        this.right=null;
    }
}
public class print {
    public static void main(String[] args) {
        int[]arr={7,8,10,17,-1,5,6};
        postorder(0,arr);
    }
    public static void preorder(int i,int[]arr ){
        if(i>=arr.length || arr[i]==-1) return;
        System.out.println(arr[i]);
        preorder(2*i+1,arr);
        preorder(2*i+2,arr);
    }
    public static void inorder(int i,int[]arr ){
        if(i>=arr.length || arr[i]==-1) return;
        inorder(2*i+1,arr);
        System.out.println(arr[i]);
        inorder(2*i+2,arr);
    }
    public static void postorder(int i,int[]arr ){
        if(i>=arr.length || arr[i]==-1) return;
        postorder(2*i+1,arr);
        postorder(2*i+2,arr);
        System.out.println(arr[i]);
    }
}
