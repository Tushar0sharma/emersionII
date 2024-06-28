/**
 * cool
 */
public class cool {
    public static void main(String[] args) {
        System.out.println(check(18));
    }
    public static boolean check(int n){
        while(n>1){
            if(n%2!=0) return false;
            n/=2;
        }
        return true;
    }    
}