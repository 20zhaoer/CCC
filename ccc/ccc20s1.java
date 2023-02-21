import java.util.*;
import java.io.*;
public class Main{

    /**
     * @param args the command line arguments
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        int N = readInt();
        Queue <Long> q = new PriorityQueue();
        Map<Long,Long> m = new HashMap();
        for(int i = 0;i<N;i++){
            long a = readLong(), b = readLong();
            q.add(a);m.put(a, b);
        }
        double maxspeed = 0;
        long x = q.poll();long y = m.get(x);
        for(int i = 0;i<N-1;i++){
            long x1 = q.poll(),y1 = m.get(x1);
            double n = Math.abs((y1-y)/((x1-x)*1.0));
            if(n >maxspeed) maxspeed = n;
            x = x1; y = y1;
        }
        System.out.println(maxspeed);
        
        
    }
    static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
    static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
    static long readLong () throws IOException {
		return Long.parseLong(next());
	}
    
}