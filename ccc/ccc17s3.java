import java.io.*;
import java.util.*;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    
    static StringTokenizer st;
    public static void main(String [] args)throws Exception{
        int N = readInt();
        int [] arr = new int[2001],sum = new int[4001];
        for(int i = 0;i<N;i++){
            arr[readInt()]+=1;
        }
        for(int i = 2000;i>0;i--){
            if(arr[i]>0){
                sum[2*i] += (arr[i]/2);
            }
            for(int j = i-1;j>0;j--){
                if(arr[j]>0){
                    if(arr[j]>arr[i]) sum[i+j]+= arr[i];
                    else sum[i+j]+=arr[j];
                 }
            }
        }
        int max = 0, count = 0;
        for(int i = 2;i<=4000;i++){
            if(sum[i]>max) max = sum[i];
        }
        for(int i = 2;i<=4000;i++){
            if(sum[i]==max) count++;
        }
        System.out.println(max+" "+count);
    }
    static String next () throws IOException {  
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}