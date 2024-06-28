public class cool {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(64));
    }
    public static boolean isPowerOfFour(int n) {
        while(n>1){
            if(n%4!=0){
                return false;
            }
            n/=4;
        }
        return n==1;
        
    }
}
