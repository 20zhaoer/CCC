/**
 *
 * @author 24241
 * Who is taller?
 */
import java.io.*;
import java.util.*;
public class Main{
    final private static int BUFFER_SIZE = 1 << 16;
    private static DataInputStream din = new DataInputStream(System.in);
    private static byte[] buffer = new byte[BUFFER_SIZE];
    private static int bufferPointer = 0, bytesRead = 0;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String [] args) throws Exception{
        int n = readInt(), e = readInt();
        List <Integer> adj[] = new ArrayList[n+1], adj2[] = new ArrayList[n+1];
        for(int i =1;i<=n;i++){
            adj[i] = new ArrayList();
            adj2[i] = new ArrayList();
        }
        boolean vis[] = new boolean[n+1];
        Queue <Integer> q = new LinkedList();
        int v,u;
        for(int i = 1;i<=e;i++){
            v = readInt(); u = readInt();
            adj[v].add(u);adj2[u].add(v);
        }
        int src = readInt(), des = readInt();
        q.add(src);vis[src] = true;
        int cur;
        while(!q.isEmpty()){
            cur = q.poll();
            for(int nxt: adj[cur] ){
                if(!vis[nxt]){ 
                    q.add(nxt);
                    vis[nxt] = true;
                }
            }
        }
        if(vis[des]){
            System.out.println("yes");return;
        }
        vis = new boolean[n+1];
        q.add(src);vis[src] = true;
        while(!q.isEmpty()){
            cur = q.poll();
            for(int nxt: adj2[cur] ){
                if(!vis[nxt]){ 
                    q.add(nxt);
                    vis[nxt] = true;
                }
            }
        }
        System.out.println(vis[des]?"no":"unknown");
            
        
        }
        private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private static byte Read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
        public static int readInt() throws IOException {
		int ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}
    
    
  
}