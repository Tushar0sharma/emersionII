public class HCF {
    public static void main(String[] args) {
        int a = 8;
        int b = 20;
        System.out.println(optimal(a , b));
    }

    public static int optimal(int a , int b){
        while(a > 0 && b > 0) {
            if(a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        if(a == 0) {
            return b;
        }
        return a;
    }
}