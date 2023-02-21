import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int J = input.nextInt();
        int A = input.nextInt();
        ArrayList<String> arrList = new ArrayList();
        for(int i = 0;i<J;i++){
            String a = input.next();
            arrList.add(a);
        }

        int count =0;
        for(int i =0;i<A;i++){
            String a = input.next();
            int b = input.nextInt()-1;
            if(a.equals("S")&!arrList.get(b).equals("N")){
                count++;
                arrList.set(b, "N");
            }
            else if(a.equals("M")&(arrList.get(b).equals(a)|arrList.get(b).equals("L"))){
                count++;
                arrList.set(b, "N");
            }
            else if(a.equals("L")&arrList.get(b).equals(a)){
                count++;
                arrList.set(b, "N");
            }
        }
        System.out.println(count);
    }
}