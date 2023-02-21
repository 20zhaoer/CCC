import java.util.*;
import java.io.*;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));   
    static StringTokenizer st;
    public static void main(String [] args) throws Exception{
        int [] level = new int[1001];
        int N = readInt(), b;
        for(int i = 1;i<=N;i++){
            b = readInt();
            level[b]++;
        }
        int largest = 1,fre = 0,index = 0;
        for(int i = 1;i<=1000;i++){
            if(level[i]>largest){
                largest = level[i];fre = 1;index = i;
            }
            else if(level[i]==largest)fre++;
        }
        
        if(fre==1){
            int second = 1,diff = 0;
            for(int i = 1;i<=1000;i++){
                if(level[i]>second&&level[i]<largest){
                    second = level[i];
                }
            }
            for(int i = 1;i<=1000;i++){
                if(level[i]==second){
                    if(Math.abs(i-index)>diff)diff = Math.abs(i-index);
                }
            }
            System.out.println(diff);
        }
        
        else{
            int a = 0;
            for(int i = 1;i<=1000;i++){
                if(level[i]==largest){
                    a = i;break;
                }
            }
            for(int i = 1000;i>=1;i--){
                if(level[i]==largest){
                    System.out.println(i-a);
                    break;
                }
            }
            
        }
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