public class cool {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(33));
    }
    public static boolean isPowerOfThree(int n) {
        while(n>1){
            if(n%3!=0) return false;
            n=n/3;
        }   
        return n>0;
    }
}
