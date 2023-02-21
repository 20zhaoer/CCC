/**
 *
 * @author 24241
 */
import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        Map <String,Integer> m = new HashMap();
        String str1 = in.nextLine(),str2 = in.nextLine();
        for(int i = 0;i<str1.length();i++){
            String s = str1.substring(i,i+1);
            if(!m.containsKey(s)){
                m.put(s, 1);
            }
            else m.put(s, m.get(s)+1);
        }
        for(int i = 0;i<str2.length();i++){
            String s = str2.substring(i,i+1);
            if(!str1.contains(s)){
                if(!s.equals("*")){
                    System.out.println("N");return;
                }
            }
            if(m.containsKey(s)){
                m.put(s, m.get(s)-1);
                if(m.get(s)<0){
                    System.out.println("N");return;
                }
            }
        }
        System.out.println("A");
        
    }
}