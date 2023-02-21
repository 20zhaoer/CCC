import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0;t<T;t++){
            int N = in.nextInt();
            int lake = 1; int []arr = new int[N];
            Stack <Integer> s = new Stack();
            for(int i = 0;i<N;i++){
                arr[i] = in.nextInt();
            }
            for(int i = N-1;i>=0;i--){
                s.add(arr[i]);
                while(!s.isEmpty()&&s.peek()==lake){
                    s.pop();
                    lake++;
                }
                
            }
            System.out.println(lake==N+1? "Y":"N");
            
        }
        
    }
}