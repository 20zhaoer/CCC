import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(),sum1 = 0, sum2 = 0, a = 0;
        int [] arr1 = new int[N], arr2 = new int[N];
        for(int i = 0;i<N;i++) arr1[i] = in.nextInt();
        for(int i = 0;i<N;i++) arr2[i] = in.nextInt();
        for(int i = 0;i<N;i++){
            sum1+=arr1[i];
            sum2+=arr2[i];
            if(sum1==sum2) a = i+1;
        }
        System.out.println(a);
    }
}