import java.util.*;
public class Main{
    static int G,T,n=0;
    static int [] a1,a2;
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        T = in.nextInt();G = in.nextInt();
        boolean [][] m = new boolean[5][5];
        int score[] = new int[5];
        for(int i = 0;i<G;i++){
            int a = in.nextInt();int b = in.nextInt();
            int c = in.nextInt();int d = in.nextInt();
            m[a][b] = true;m[b][a]=true;
            if(c>d)score[a]+=3;
            else if(d>c)score[b]+=3;
            else{
                score[a]++;score[b]++;
            }
        }
        int k = 6-G;
        a1 = new int[k+1];a2 = new int[k+1];
        for(int i = 1;i<=3;i++){
            for(int j = i+1;j<=4;j++){
                if(!m[i][j]){
                    a1[k] = i;a2[k]=j;k--;
                }
            }
        }
        game(score, 6-G);
        System.out.println(n);
    }
    public static void game(int [] score1,int level){
        if(level == 0){
            int max = -1,index=0;
            for(int j = 1;j<=4;j++){
                if(score1[j]>max){
                    max = score1[j];index = j;
                }
                else if(score1[j]==max)index=-1;
            }
            if(index==T){
                n++;
            }
            
        }
        else{
            for(int i = 0;i<3;i++){
                int score2[] = score1.clone();
                int a = a1[level], b = a2[level];
                if(i==0){
                    score2[a]+=3;
                    game(score2, level-1);
                }
                else if(i==1){
                    score2[a]++;score2[b]++;
                    game(score2, level-1);
                }
                else{
                    score2[b]+=3;
                    game(score2, level-1);
                }
                
             }
        }
    }
}