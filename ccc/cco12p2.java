/**
 *
 * @author 24241
 */
import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt();
        List<edge> adj[] = new ArrayList[N+1], adj2[] = new ArrayList[N+1];
        Queue <Integer> q1 = new LinkedList(), q2 = new LinkedList();
        for(int i = 1;i<=N;i++){
            adj[i] = new ArrayList();
            adj2[i] = new ArrayList();
        }
        for(int i = 0;i<M;i++){
            int u = in.nextInt(),v = in.nextInt(), w = in.nextInt();
            adj[u].add(new edge(v,w));
            adj2[v].add(new edge(u,w));
        }
        int dis[] = new int[N+1], dis2[] = new int[N+1];
        boolean vis[] = new boolean[N+1],  vis2[] = new boolean[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);Arrays.fill(dis2, Integer.MAX_VALUE);
        int src = 1, des = N;
        dis[src] = 0;q1.add(src);
        while(!q1.isEmpty()){
            int current = q1.poll(); vis[current] = false;
            for(edge e: adj[current]){
                if(dis[current]+e.w<dis[e.v]){
                    dis[e.v]=dis[current]+e.w;
                    if(!vis[e.v]){
                        vis[e.v] = true;
                        q1.add(e.v);
                    }
                }
            }
        }
        dis2[des] = 0;q2.add(des);
        while(!q2.isEmpty()){
            int current = q2.poll(); vis2[current] = false;
            for(edge e: adj2[current]){
                if(dis2[current]+e.w<dis2[e.v]){
                    dis2[e.v]=dis2[current]+e.w;
                    if(!vis2[e.v]){
                        vis2[e.v] = true;
                        q2.add(e.v);
                    }
                }
            }
        }
        
       

        int secondMin = Integer.MAX_VALUE;
        for(int i = 1;i<=N;i++){
                for(edge e: adj[i]){
                    if(dis[i]!=Integer.MAX_VALUE&&dis2[e.v]!=Integer.MAX_VALUE){
                        if(dis[i]+e.w+dis2[e.v]>dis[des]){
                            if(dis[i]+e.w+dis2[e.v]<secondMin){
                                secondMin = dis[i]+dis2[e.v]+e.w;
                            }
                        }
                    }
                    
                }
            }
        System.out.println(secondMin==Integer.MAX_VALUE? -1:secondMin);
        }                 
    static class edge{
        int v, w;
        edge(int v0, int w0){
            v = v0; w = w0;
        }
    }
}