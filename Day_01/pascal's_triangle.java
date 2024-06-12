import java.util.*;
class Solution {
    public static void main(String []args){
        int n=6;
        System.out.println(generate(n));
    }
    public static List<List<Integer>> generate(int n) {
        List<List<Integer>>ll=new ArrayList<>();
        for(int i=1;i<=n;i++){
            ll.add(generaterow(i));
        }
        return ll;
    }
    public static List<Integer> generaterow(int i){
        long ans=1;
        List<Integer>l=new ArrayList<>();
        l.add(1);
        for(int j=1;j<i;j++){
            ans=ans*(i-j);
            ans=ans/j;
            l.add((int)ans);
        }
        return l;
    }
}