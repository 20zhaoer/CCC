import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        String [] symbol = {"I","V","X", "L" ,"C", "D","M"};
        int [] value = {1, 5, 10, 50, 100, 500 ,1000};
        String str = in.next();
        int index1 = 0,index2=0,sum = 0;
        for(int j = 0;j<7;j++){
            if(symbol[j].equals(str.substring(1,2)))index2 = j;
        }
        for(int i = 1;i<str.length()-2;i=i+2){
            for(int j = 0;j<7;j++){
                if(symbol[j].equals(str.substring(i,i+1)))index1 = j;
                if(symbol[j].equals(str.substring(i+2,i+3)))index2 = j;
            }
            if(index2>index1)sum-= Integer.parseInt(str.substring(i-1,i))*value[index1];
            else sum+= Integer.parseInt(str.substring(i-1,i))*value[index1];
            
        }
        sum+= Integer.parseInt(str.substring(str.length()-2,str.length()-1))*value[index2];
        System.out.println(sum);
    }
}