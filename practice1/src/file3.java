import java.util.HashSet;
import java.util.Set;

public class file3 {
    public static String solutions(int a, int b, int c){
        double d = b*b-4*a*c;
        if (d==0) return  "has one solution (x = "+(int)((b+Math.pow(d,0.5))/2*a)+").";
        else if (d>0) return "has two solutions (x = "+(int)((-b+Math.pow(d,0.5))/2*a)+" and x = "+(int)((-b-Math.pow(d,0.5))/2*a)+").";
        else return "has no solutions.";
    }
    public static int findZip(String str){
        int count=0;
        String[] strs = str.split("zip");
        if (strs.length>=2) return strs[0].length()+strs[1].length()+3;
        else return -1;
    }
    public static boolean checkPerfect(int a){
        int count=0;
        for (int i=1; i<a; i++){
            if (a%i==0) count+=i;
        }
        return a==count;
    }
    public static String flipEndChars(String str){
        char[] chars = str.toCharArray();
        if (chars.length<2) return "Incompatible.";
        else if (chars[0]!=chars[chars.length-1]) {
            char a = chars[chars.length - 1];
            chars[chars.length-1]=chars[0];
            chars[0]=a;
            String result="";
            for (int i=0; i<chars.length; i++){
                result+=chars[i];
            }
            return  result;
        }
        else return "Two's a pair.";
    }
    public static boolean isValidHexCode(String str) {
        return str.matches("#[A-F0-9a-f0-9]{6}");
    }
    public static boolean same(int[] arr1, int[] arr2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i=0; i<arr1.length; i++){
            set1.add(arr1[i]);
        }
        for (int i=0; i<arr2.length; i++){
            set2.add(arr2[i]);
        }
        return set1.size()==set2.size();
    }
    public static boolean isKaprekar(int a){
        String n=String.valueOf(a*a);
        if (n.length()==1) return Integer.parseInt(n)==a;
        else if (n.length()%2!=0){
            return Integer.parseInt(n.substring((n.length()-1)/2))+Integer.parseInt(n.substring(0,(n.length()-1)/2))==a;
        }
        else {
            return Integer.parseInt(n.substring(n.length() / 2)) + Integer.parseInt(n.substring(0, n.length() / 2)) == a;
        }
    }
    public static String longestZero(String str){
        char[] chars = str.toCharArray();
        int count=0;
        int max = -1;
        boolean flag;
        for (int i=0; i<chars.length; i++){
            if (chars[i]=='1') {
                if (count>max) max=count;
                count = 0;
            }
            else  if (chars[i]=='0'){
                count++;
                if (i+1==chars.length) {
                    if (count>max) max=count;
                }
            }
        }
        String result="";
        for (int i=0; i<max; i++){
            result+="0";
        }
        return result;
    }
    public static int nextPrime(int a){
        int count=0;
        for (int i=2; i<a; i++){
            if (a%i==0) count++;
        }
        if (count==0) return a;
        int result=0;
        int j=0;
        while (result<a){
            j++;
            count=0;
            for (int i=2; i<j; i++){
                if (j%i==0) count++;
            }
            if (count==0) result=j;
        }
        return result;
    }
    public static boolean rightTriangle(int a, int b, int c){
        return  (a*a+b*b==c*c || b*b+c*c==a*a || c*c+a*a==b*b);
    }
    public static void main(String[] args) {
        String n="1234";
        System.out.println(rightTriangle(70, 130, 110));
    }
}
