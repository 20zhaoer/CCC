import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        Map <String,String> m = new HashMap();
        int N = in.nextInt();
        int max = 0;
        for(int i = 0;i<N;i++){
            String a = in.next(), b = in.next();
            if(b.length()>max)max = b.length();
            m.put(a,b);
        }
        
        String s = in.next();
        loop:while(true){
        for(int i = 1;i<=max;i++){
            String s1 = s.substring(0,i);
            for(String s2:m.keySet()){
                if(s1.equals(m.get(s2))){
                    System.out.print(s2);
                    if(s.length()==i)break loop;
                    s = s.substring(i,s.length());
                    continue loop;
                }
            }
        }
        }
    }
}