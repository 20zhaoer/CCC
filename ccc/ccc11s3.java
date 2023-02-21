/**
 *
 * @author 24241
 */
import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int [][] glass = new int[5][5];
        glass[1][0] = 1;glass[2][0] = 1;glass[3][0] = 1;glass[2][1] = 1;
        glass[1][1] = -1;glass[2][2] = -1;glass[3][1] = -1;
        loop:for(int i = 0;i<T;i++){
            int level = in.nextInt(), a = in.nextInt(), b = in.nextInt();
            for(int j = level;j>0;j--){
                int c = a/(int)(Math.pow(5, j-1)), d = b/(int)(Math.pow(5, j-1));
                if(glass[c][d]==0){
                    System.out.println("empty");
                    continue loop;
                }
                else if(glass[c][d]==1){
                    System.out.println("crystal");
                    continue loop;
                }
                else{
                    a = a%(int)(Math.pow(5, j-1));
                    b = b%(int)(Math.pow(5, j-1));
                }
            }
            if(glass[a][b]==0){
                System.out.println("empty");
            }
            else if(glass[a][b]==1){
                System.out.println("crystal");
            }
        }
    }
}