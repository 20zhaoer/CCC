/**
 *  
 * @author 24241
 */ 
import java.io.*;
import java.util.*;
public class Main{
    /*public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int G = in.nextInt(), P = in.nextInt();
        boolean a[] = new boolean[G+1];a[0] = true;
        int sum = 0;
        loop:for(int i = 0;i<P;i++){
            int x = in.nextInt();
            if(!a[x]){
                a[x] = true; sum++;
            }
            else{
                for(int j = x-1;j>0;j--){
                    if(!a[j]){
                        a[j] = true; sum++;
                        continue loop;
                    }
                }
                break loop;
            }
        }
        System.out.println(sum);
    }
    */
    static int plane = 0;
    public static void main(String [] args) throws Exception{
        try{
            Scanner in = new Scanner(System.in);
            TreeSet <Integer> t = new TreeSet();
            int G = in.nextInt(), P = in.nextInt();
            for(int i = 1;i<=G;i++){
                t.add(i);
            }
            for(int i = 0;i<P;i++){
                int a = in.nextInt();
                t.remove(t.floor(a));
                plane++;
            }
            System.out.println(plane);
        }
        catch(Exception e){
            System.out.println(plane);
        }
    }
    
}