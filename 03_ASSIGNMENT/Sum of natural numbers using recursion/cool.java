
class cool 
{  
    public static int recurSum(int n) 
    { 
        if (n <= 1) 
            return n; 
        return n + recurSum(n - 1); 
    } 
       
    public static void main(String args[]) 
    { 
        int n = 6; 
        System.out.println(recurSum(n)); 
    } 
} 