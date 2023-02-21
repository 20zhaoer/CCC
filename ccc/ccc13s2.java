import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int max = input.nextInt();
        int N = input.nextInt();
        int a[] = new int [N], sum = 0, count = 0;
        for(int i = 0;i<N;i++){
            a[i] = input.nextInt();
        }
        for(int i =0;i<4&&i<N;i++){
            sum += a[i];
            if(sum >max) break;
            count++;
        }
        if(sum<=max&&N>4){
            for(int i = 1;i<N-3;i++){
                sum = a[i]+a[i+1]+a[i+2]+a[i+3];
                if(sum>max){
                    break;
                }
                count++;
            }
            System.out.println(count);
        }
        else System.out.println(count);
    }
}