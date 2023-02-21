import java.util.*;
import java.io.*;
public class Main{
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        int M = readInt(), N = readInt();
        int adj[][] = new int[M+1][N+1];
        boolean vis[][] = new boolean[M+1][N+1];
        Queue <Integer> q = new LinkedList();
        for(int i = 1;i<=M;i++){
            for(int j = 1;j<=N;j++){
                adj[i][j] = readInt();
            }
        }
        vis[M][N] = true;
        q.add(M*N);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1;i<=M;i++){
                for(int j = 1;j<=N;j++){
                    if(!vis[i][j]){
                        if(cur==adj[i][j]){
                            q.add(i*j);
                            vis[i][j] = true;
                        }
                    }
                }
            }
        }
        if(vis[1][1])System.out.println("yes");
        else System.out.println("no");
        
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