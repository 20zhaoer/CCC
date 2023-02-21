import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String b = in.next();int n = 0;
        boolean [][] adjMat = new boolean[26][26];
        while(!b.equals("**")){
            int v = a.indexOf(b.substring(0,1)), u = a.indexOf(b.substring(1,2));
            adjMat[v][u] = true;adjMat[u][v] = true;
            b = in.next();
        }
        for(int i = 0;i<25;i++){
            for(int j = i+1;j<26;j++){
                if(adjMat[i][j]){
                adjMat[i][j] = false;adjMat[j][i] = false;
                boolean vis[] = new boolean[26];vis[0] = true;
                Queue <Integer> q = new LinkedList();q.add(0);
                while(!q.isEmpty()){
                    int v = q.poll();
                    for(int u = 0;u<26;u++){
                        if(!vis[u]&&(adjMat[v][u]||adjMat[u][v])){
                            q.add(u);
                            vis[u] = true;
                        }
                    }
                }
                if(!vis[1]){
                    System.out.println(a.substring(i, i+1)+a.substring(j,j+1));
                    n++;
                }
                adjMat[i][j] = true;adjMat[j][i] = true;
                }
            }
        }
        System.out.println("There are "+n+" disconnecting roads.");
    }
}