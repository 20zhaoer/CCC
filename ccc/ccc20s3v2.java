import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "abcdefghijklmnopqrstuvwxyz";
        Set<Long> t = new HashSet<Long>();
        int[] fre = new int[26];
        String needle = in.next(),haystack = in.next();
        
        char [] c = haystack.toCharArray();
        long hash[] = new long [c.length+1];
        long a[] = new long[c.length+1]; a[0] = 1;
        int base = 31;
        for(int i = 1;i<=c.length;i++){
            hash[i] = hash[i-1]*base+c[i-1];
            a[i] = a[i-1]*base;
        }
        
        for(int i = 0;i<needle.length();i++){
            int x = s.indexOf(needle.substring(i,i+1));
            fre[x]++;
        }
        if(needle.length()>haystack.length()){
            System.out.println(0);
        }
        else{
            int []check = new int[26];
            int N = haystack.length();
            String s1 = haystack.substring(0,needle.length());
            for(int j = 0;j<s1.length();j++){
                int x = s.indexOf(s1.substring(j,j+1));
                check[x]++;
            }
            if(Arrays.equals(check, fre)){
                t.add(hash[s1.length()]);
            }
            int firstLetter = s.indexOf(s1.substring(0,1));
            int finalLetter = 0;
            for(int i = 1;i<=N-needle.length();i++){
                s1 = haystack.substring(i,i+needle.length());
                finalLetter = s.indexOf(s1.substring(needle.length()-1,needle.length()));
                check[firstLetter]--;check[finalLetter]++;
                firstLetter = s.indexOf(s1.substring(0,1));
                if(Arrays.equals(check, fre)){
                    t.add(hash[i+needle.length()]-hash[i]*a[needle.length()]);
                }
            }
            System.out.println(t.size());
        }
        
    }
    
}