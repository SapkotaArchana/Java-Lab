
import java.util.Scanner;
class fibo{
    int fib(int n){
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{
            return (fib(n-2)+fib(n-1));
        }
    }
}
public class fibonacci123 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        fibo f=new fibo();
        System.out.println("Enter number");
        int n=sc.nextInt();
        System.out.println("The list of fibonacci series are:");
        for(int i=0;i<n;i++){
            System.out.print(f.fib(i)+" ");
        }
        System.out.println("\n"+"The fourth element of fibonacci series is:"+f.fib(4));
        
    }
    }

