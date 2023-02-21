import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] arr1 = new String[N], arr2 = new String[N];
        for(int i = 0;i<N;i++) arr1[i] = in.next();
        for(int i = 0;i<N;i++) arr2[i] = in.next();
        
        for(int i = 0;i<N;i++){
            if(arr1[i].equals(arr2[i])){
                System.out.println("bad");return;
            }
            for(int j = 0;j<N;j++){
                if(arr2[i].equals(arr1[j])){
                    if(!arr1[i].equals(arr2[j])){
                        System.out.println("bad");return;
                    }
                }
            }
        }
        System.out.println("good");
    }
}