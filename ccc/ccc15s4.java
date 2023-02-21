import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int K = in.nextInt(), N = in.nextInt(), M = in.nextInt();
        List <edge> adj[] = new ArrayList[N+1];
        for(int i = 1;i<=N;i++){
            adj[i] = new ArrayList();
        }
        for(int i = 1;i<=M;i++){
            int u = in.nextInt(), v = in.nextInt();
            int w = in.nextInt(), h = in.nextInt();
            adj[u].add(new edge(v,w,h));
            adj[v].add(new edge(u,w,h));
        }
        int dis[][] = new int[N+1][K];
        boolean vis[] = new boolean[N+1];
        for(int i = 1;i<=N;i++)Arrays.fill(dis[i], Integer.MAX_VALUE);
        int src = in.nextInt(), des = in.nextInt();
        int min[] = new int[N+1];
        dis[src][0] = 0;
        for(int count = 1;count<=N;count++){
            
            for(int i = 1;i<=N;i++){
                int minium = Integer.MAX_VALUE;
                for(int j = 0;j<K;j++){
                    if (minium>dis[i][j]){
                        minium = dis[i][j];
                    }
                } min[i] = minium;
            }
            int current = -1;int m = Integer.MAX_VALUE;
            for(int i = 1;i<=N;i++){
                if(m>min[i]&&!vis[i]){
                    m = min[i]; current = i;
                }
            }
            if(current == -1) break;
            vis[current] = true;
            for(edge e:adj[current]){
                if(!vis[e.v]){
                    for(int i = 0;i<K;i++){
                        if(dis[current][i]!=Integer.MAX_VALUE&&i+e.h<K){
                            if(dis[current][i]+e.w<dis[e.v][i+e.h]){
                                dis[e.v][i+e.h] = dis[current][i]+e.w;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 1;i<=N;i++){
                int minium = Integer.MAX_VALUE;
                for(int j = 0;j<K;j++){
                    if (minium>dis[i][j]){
                        minium = dis[i][j];
                    }
                } min[i] = minium;
        }
        System.out.println(min[des]==Integer.MAX_VALUE? -1:min[des]);
    }
    static class edge{
        int v, w, h;
        edge(int v1, int w1, int h1){
            v = v1; w = w1; h = h1;
        }
    }
}