public class cool {
    public static void main(String[] args) {
        int []a={1,4,323,4,5,32};
        System.out.println(arraySortedOrNot(a, 6));
    }
    public static boolean arraySortedOrNot(int[] arr, int n) {
        // code here
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]) return false;
        }
        return true;
    }
}
