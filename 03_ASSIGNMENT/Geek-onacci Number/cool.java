import java.util.Scanner;

class cool
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc=new Scanner(System.in);
	    int k=sc.nextInt();
	    while(k-->0){
	        int a=sc.nextInt();
	        int b=sc.nextInt();
	        int c=sc.nextInt();
	        int n=sc.nextInt();
	        int[]dp=new int[n];
	        dp[0]=a;
	        dp[1]=b;
	        dp[2]=c;
	        for(int i=3;i<n;i++){
	            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
	        }
	        System.out.println(dp[n-1]);
	    }
        sc.close();
	 }
	 
}