import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        List <String> ls = new ArrayList();
        int a = in.nextInt();
        String str;
        loop:while(true){
            a++;
            str = a+" ";
            ls = new ArrayList();
            for(int i = 0;i<str.length();i++){
                if(ls.contains(str.substring(i,i+1))){
                    continue loop;
                }
                ls.add(str.substring(i,i+1));
            }
            System.out.println(a);
            break;
        }
    }
}