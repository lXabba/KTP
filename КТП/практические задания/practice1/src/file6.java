import java.util.*;

public class file6 {
    public static int bell(int a){
        int[][] ints = new int[a+1][a+1];
        ints[0][0]=1;
        ints[a][a]=1;
        for (int n=1; n<a+1; n++ ){
            for (int k=1; k<a+1; k++){
                ints[n][k]=ints[n-1][k-1]+k*ints[n-1][k];
            }
        }
        int bell=0;
        for (int k=0; k<a+1; k++){
            bell+=ints[a][k];
        }
        return bell;
    }
    public static String translateWord(String str){
        String letters="aueioyAUEIOY";
        String firstL="";
        boolean flag=true;
        int lastindex=0;
        if (!letters.contains(String.valueOf(str.charAt(0)))) {
            for (int i = str.length()-1; i>=0; i--){
                if (letters.contains(String.valueOf(str.charAt(i)))) {
                    lastindex=i;
                    break;
                }
            }
            for (int i=0; i<str.length(); i++){
                if (letters.contains(String.valueOf(str.charAt(i)))) break;
                if (!letters.contains(String.valueOf(str.charAt(i)))) firstL+=str.charAt(i);
            }

            return str.substring(firstL.length())+firstL+"ay";
        }
        else {
            System.out.println("here");
            return str+"yay";
        }
    }
    public static String translateSentence(String str){
        String[] strings = str.split(" ");
        String result="";
        for (int i=0; i<strings.length; i++){
            if (strings[i].indexOf(".")==strings[i].length()-1) result+=translateWord(strings[i].substring(0,strings[i].length()-1))+". ";
            else result+=translateWord(strings[i])+" ";
        }
        return result.trim();
    }
    public static boolean validColor(String str) {
        String[] strings = str.split("[\\(\\),]");
        if (!(strings[0].equals("rgb") || strings[0].equals("rgba"))) return false;
        else if (strings[0].length() == strings.length - 1) {
            for (int i = 1; i < strings.length; i++) {
                try {
                    if (Double.parseDouble(strings[i])<0 || Double.parseDouble(strings[i])>255) return false;
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static String stripUrlParams(String str, String[] arr){
        Map<String, String> map = new HashMap<>();
        if (str.contains("?")) {
            String[] strings = str.split("\\?")[1].split("&");
            String result = "";
            String[] seq = new String[strings.length];
            for (int i = 0; i < strings.length; i++) {
                if (!(map.containsKey(strings[i].split("=")[0]))) {
                    seq[i] = strings[i].split("=")[0];
                }
                map.put(strings[i].split("=")[0], strings[i].split("=")[1]);
            }
            for (int i = 0; i < arr.length; i++) {
                map.remove(arr[i]);
            }
            for (int i = 0; i < seq.length; i++) {
                if (map.get(seq[i]) != null)
                    result += seq[i] + "=" + map.get(seq[i]) + "&";
            }
            result = result.substring(0, result.length() - 1);
            return str.split("\\?")[0] + "?" + result;
        }
        else return str;
    }
    public static String stripUrlParams(String str){
        return  stripUrlParams(str, new String[]{});
    }
    public static String[] getHashTags(String str){
        String[] strings=str.split(" ");
        ArrayList<String> words = new ArrayList<>();
        for (int i=0; i<strings.length; i++){
            words.add(strings[i].replaceAll( "\\W", ""));
        }
        Comparator<String> comprator = (o1, o2) -> o2.length() - o1.length();
        words.sort(comprator);
        int len = (words.size()>=3) ? 3 : words.size();
        String[] strings1 = new String[len];
        for (int i=0; i<len; i++){
            strings1[i]="#"+words.get(i).toLowerCase();
        }
        return strings1;
    }
    public static int ulam(int a){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int count=0, i=2;
        boolean flag=false;
        for (int s=0; s<a; s++) {
            flag=false;
            while (!flag){
                i++;
                count = 0;
                for (int j = 0; j < list.size() - 1; j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        if (list.get(j) + list.get(k) == i) count++;
                        if (count>1) break;
                    }
                    if (count>1) break;
                }
                if (count == 1) {
                    list.add(i);
                    flag=true;
                }
            }
        }
        return list.get(a-1);
        //return  list.size();
    }
    public static String longestNonrepeatingSubstring(String str){
        char a=str.charAt(0);
        String word = String.valueOf(a);
        String maxword=String.valueOf(a);
        for (int i=1; i<str.length(); i++){
            if (word.contains(String.valueOf(str.charAt(i)))){
                if (word.length()>maxword.length()) {
                    maxword=word;
                    word=String.valueOf(str.charAt(i));
                }
            }
            else {
                word+=String.valueOf(str.charAt(i));
            }
        }
        if (word.length()>maxword.length()) {
            maxword=word;}
        return maxword;
    }
    public static String convertToRoman(int n){
        String result ="";
     while (n>1000){
        result+="M";
        n-=1000;
     }
     while (n>500){
         result+="D";
         n-=500;
     }
     while (n>100){
         result+="S";
         n-=100;
     }
     while (n>50){
         result+="L";
         n-=50;
     }
     while (n>10){
         result+="X";
         n-=10;
     }
     while (n>5){
         result+="V";
         n-=5;
     }
     while (n>=1){
         result+="I";
         n-=1;
     }
     return result;

    }
    public static boolean formula(String str){
        String[] strings = str.split(" ");
        int count=0;
        String operators = "-+*/=";
        int[] nums = new int[str.length()];
        for (int i=0; i<strings.length; i++){
            if (!operators.contains(String.valueOf(strings[i]))){
                nums[count]=Integer.parseInt(strings[i]);
                count++;
            }
        }
        if (nums[3]==0){
            if (strings[1].equals("+")){
                return nums[0]+nums[1]==nums[2];
            }
            else if (strings[1].equals("-")){
                return nums[0]-nums[1]==nums[2];
            }
            else if (strings[1].equals("*")){
                return nums[0]*nums[1]==nums[2];
            }
            else if (strings[1].equals("/")){
                return nums[0]/nums[1]==nums[2];
            }
        }
        return false;
    }
    public static boolean palindromedescendant(long a){
        String str = String.valueOf(a);
        //System.out.println(a);
        if (str.length()%2==1)
           return str.equals(new StringBuilder(str).reverse().toString());
        else  if (str.equals(new StringBuilder(str).reverse().toString())) return true;
        else {
                int b=0;
                String res="";
                for (int i=0; i<str.length(); i++){
                    if (i%2==0){
                        b=Integer.parseInt(String.valueOf(str.charAt(i)))+Integer.parseInt(String.valueOf(str.charAt(i+1)));
                        res+=String.valueOf(b);
                    }
                }
                return palindromedescendant(Long.parseLong(res));
        }

    }
    public static void main(String[] args) {
        System.out.println(bell(3));
    }
}
