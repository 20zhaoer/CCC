import java.util.*;
/**
 *
 * @author 24241
 */
public class Main{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer> a = new ArrayList();
        for(int i =0;i<n;i++){
            int b = input.nextInt();
            if(b==0) a.remove(a.size()-1);
            else{
                a.add(b);
            }
        }
        int sum =0;
        if(!a.isEmpty()){
            for(int i =0;i<a.size();i++){
                sum+=a.get(i);
            }
        }
        System.out.println(sum);
    }
}