import java.util.*;

public class file4 {
    static long timer=0;
    public static String essay(int a, int b, String str){
        String[] words = str.split(" ");
        String result = "";
        int count = 0;
        for (int i=0; i<a; i++){
            if (words[i].length()+count<=b){
                result +=words[i]+" ";
                count+=words[i].length();
            }
            else {
                result=result.trim();
                result+="\n";
                result+=words[i]+" ";
                count=words[i].length();
            }
        }
        result=result.trim();
        return result;
    }
    public static String Split(String str){
        char[] chars = str.toCharArray();
        String result="[";
        int countL=0, countR=0;
        for (int i=0; i<chars.length; i++){
          if (chars[i]=='('){
              if (countL==0) result+="\"";
              result+="(";
              countL++;
          }
          else {
              countR++;
              if (countR==countL) {
                  result+=")\"";
                  countL=0;
                  countR=0;
                  if (i+1!=chars.length) result+=",";
              }
              else {
                  result+=")";
              }
          }
        }
        return result+"]";

    }
    public static void timeSet(){
        if (timer==0) timer=System.nanoTime();
        else {
            double val = (double)(System.nanoTime()-timer);
            System.out.println(val/1000000);
            timer=0;
        }
    }
    public static String toCamelCase(String str){
        String[] strings = str.split("_");
        String result=strings[0];
        for (int i=1; i<strings.length; i++){
            result+=Character.toUpperCase(strings[i].charAt(0))+strings[i].substring(1);
        }
        return result;
    }
    public static String toSnakeCase(String str){
        String res="";
        char[] chars = str.toCharArray();
        char[] result = str.toLowerCase().toCharArray();
        for (int i=0; i<result.length; i++){
            if (Character.toUpperCase(result[i])==chars[i]){
                res+="_"+result[i];
            }
            else res+=result[i];
        }
        return res;
    }
    public static String overTime(double[] arr){
        if (arr[1]>17){
            return  String.format("$%.2f",(((17-arr[0])*arr[2])+((arr[1]-17)*arr[2]*arr[3])));
        }
        else return  String.format("$%.2f",((arr[1]-arr[0])*arr[2]));
    }
    public static String BMI(String a, String b){
        double kg=0;
        double mt=0;
        String str=a.split(" ")[1];
        kg=Double.parseDouble(a.split(" ")[0]);
        if (str.equals("pounds")) {
            kg/=2.2;
        }
        str=b.split(" ")[1];
        mt=Double.parseDouble(b.split(" ")[0]);
        if (str.equals("inches")) {
            mt=mt*2.54/100;
        }
        double result = kg/(mt*mt);
        if (result<18.5){
            return  (Math.round(result*10.0)/10.0)+" Underweight";
        }
        else if (result<=24.9){
            return (Math.round(result*10.0)/10.0)+" Normal weight";
        }
        else return  (Math.round(result*10.0)/10.0)+"  Overweight";
    }
    public static int bugger(int a){
        int count = 0;
        int b=1;
        while (a>9){
            b=1;
            while (a>0){
                b=b*(a%10);
                a=a/10;
            }
            count++;
            a=b;
        }
        return count;
    }
    public static String toStarShorthand(String str){
        String string="";
        for (int i=0; i<str.length(); i++){
            if (string.indexOf(str.charAt(i))==-1)
           string+=str.charAt(i);
        }
        int [] ints = new int[string.length()];
        String res="";
        for (int i=0; i<string.length(); i++){
            for (int j=0; j<str.length(); j++){
                if (str.charAt(j)==string.charAt(i)){
                    ints[i]++;
                }
            }
        }
        String result="";
        for (int i=0; i<ints.length; i++){
            if (ints[i]==1) result+=string.charAt(i);
            else result+=string.charAt(i)+"*"+ints[i];
        }
        return result;
    }
    public static boolean doesRhyme(String str1, String str2){
        str1 = str1.substring(str1.lastIndexOf(" ")).toLowerCase();
        str2 = str2.substring(str2.lastIndexOf(" ")).toLowerCase();
        String letters="aueioy";
        String s1="";
        String s2="";
        boolean flag=false;
        for (int i=0; i<str1.length(); i++){
            for (int j=0; j<letters.length(); j++ ){
                if (str1.charAt(i)==letters.charAt(j)) flag=true;
            }
            if (flag) {
                s1+=str1.charAt(i);
                flag=false;
            }
        }
        for (int i=0; i<str2.length(); i++){
            for (int j=0; j<letters.length(); j++ ){
                if (str2.charAt(i)==letters.charAt(j)) flag=true;
            }
            if (flag) {
                s2+=str2.charAt(i);
                flag=false;
            }
        }
        return s1.equals(s2);
    }
    public static boolean trouble(long num1, long num2){
        String a=String.valueOf(num1);
        String b=String.valueOf(num2);
        for(int i=0;i<10;i++){
            String s = i+String.valueOf(i)+i;
            String z = i+String.valueOf(i);
            if (a.contains(s) && b.contains(z)) return true;
        }
        return false;
    }
    public static int countUniqueBooks(String str, char s){
        String string=String.valueOf(s);
        int count=0;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i)==s) count = (count==0) ? 1 : 0;
            if (!string.contains(String.valueOf(str.charAt(i))) && count==1) {
                string+=str.charAt(i);
            }
        }
        return string.length()-1;
    }
    public static void main(String[] args) {
        double[] arr = {13.25, 15, 30, 1.5};
        timeSet();
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
        timeSet();
    }
}
