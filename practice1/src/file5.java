import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class file5 {
    public static int[] encrypt(String str){
        int[] ints = new int[str.length()];
        ints[0]=str.charAt(0);
        for (int i=1; i<str.length(); i++){
            ints[i]=str.charAt(i)-str.charAt(i-1);
        }
        return ints;
    }
    public static String decrypt(int[] ints){
        String str=String.valueOf((char) ints[0]);
        for (int i=1; i<ints.length; i++){
            str+=String.valueOf((char)(ints[i]+str.charAt(i-1)));
        }
        return str;
    }
    public static boolean canMove(String a, String b, String c){
        String letters = "ABCDEFGH";
        String numbres = "12345678";
        switch (a){
            case "Rook" :
                if (b.charAt(0)==c.charAt(0) || b.charAt(1)==c.charAt(1))
                    return true;
                else return false;
            case "Bishop" :
                if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==Math.abs(numbres.indexOf(b.charAt(1))-numbres.indexOf(c.charAt(1)))){
                    return true;
                }
                else return false;
            case "King" :
                if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==1){
                    if (Math.abs(numbres.indexOf(b.charAt(1))-letters.indexOf(c.charAt(1)))==1){
                        return true;
                    }
                }
                else return false;
            case "Pawn" :
                if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==1 && Math.abs(numbres.indexOf(b.charAt(1))-numbres.indexOf(c.charAt(1)))==0){
                    return true;
                }
                else if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==0 && Math.abs(numbres.indexOf(b.charAt(1))-numbres.indexOf(c.charAt(1)))==1){
                    return true;
                }
                else return false;
            case "Knight" :
                if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==2 && Math.abs(numbres.indexOf(b.charAt(1))-numbres.indexOf(c.charAt(1)))==1){
                    return true;
                }
                else if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==1 && Math.abs(numbres.indexOf(b.charAt(1))-numbres.indexOf(c.charAt(1)))==2){
                    return true;
                }
                else return false;
            case "Queen" :
                if (b.charAt(0)==c.charAt(0) || b.charAt(1)==c.charAt(1))
                    return true;
                if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==Math.abs(numbres.indexOf(b.charAt(1))-numbres.indexOf(c.charAt(1)))){
                    return true;
                }
                if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==1){
                    if (Math.abs(numbres.indexOf(b.charAt(1))-letters.indexOf(c.charAt(1)))==1){
                        return true;
                    }
                }
                if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==1 && Math.abs(numbres.indexOf(b.charAt(1))-numbres.indexOf(c.charAt(1)))==0){
                    return true;
                }
                else if (Math.abs(letters.indexOf(b.charAt(0))-letters.indexOf(c.charAt(0)))==0 && Math.abs(numbres.indexOf(b.charAt(1))-numbres.indexOf(c.charAt(1)))==1){
                    return true;
                }
                return false;

        }
        System.out.print("not. ");
        return false;
    }
    public static boolean canComplete(String s1, String s2){
        int[] ints=new int[s1.length()];
        for (int i=0; i<s1.length(); i++){
            if (s2.indexOf(s1.charAt(i))==-1){
                return false;
            }
            else ints[i]=s2.indexOf(s1.charAt(i));
        }
        for (int i=1; i<ints.length; i++){
            if (ints[i]<=ints[i-1]) return false;
        }
        return true;
    }
    public static int sumDigProd(int... ints){
        int a=0;
        for (int i=0; i<ints.length; i++){
            a+=ints[i];
        }
        int count = 0;
        int b=1;
        while (a>9){
            b=1;
            while (a>0){
                b=b*(a%10);
                a=a/10;
            }
            count=b;
            a=b;
        }
        return count;
    }
    public static String[] sameVowelGroup(String[] strings){
        String letters="aueioy";
        String s="";
        String[] lresult=new String[strings.length];
        for (int i=0; i<strings[0].length(); i++){
            if (letters.indexOf(strings[0].charAt(i))!=-1 && s.indexOf(strings[0].charAt(i))==-1) s+=strings[0].charAt(i);
        }
        int all=0;
        String s2="";
        for (int i=0; i<strings.length; i++){
            for (int j=0; j<strings[i].length(); j++){
                if (s.indexOf(strings[i].charAt(j))!=-1 && s2.indexOf(strings[i].charAt(j))==-1) s2+=strings[i].charAt(j) ;
                if (j+1==strings[i].length() && s2.length()==s.length()) {
                    lresult[i]=strings[i];
                    s2="";
                    all++;
                }
            }
        }
        String[] result = new String[all];
        for (int i=0; i<all; i++){
            result[i]=lresult[i];
        }
        return result;
    }
    public static boolean validateCard(long a){
        String nums=String.valueOf(a);
        String numK=String.valueOf(nums.charAt(nums.length()-1));
        if (!(nums.length()>=14 && nums.length()<=19)) return false;
        nums=nums.substring(0, nums.length()-1);
        String ddd="";
        for (int i=nums.length()-1; i>=0; i--){
            ddd+=nums.charAt(i);
        }
        String newnum="";
        nums=ddd;
        int count=0;
        for (int i=0; i<nums.length(); i++){
            if (i%2!=0) {
                int h=Integer.parseInt(String.valueOf(nums.charAt(i)))*2;
                if (h>10) { h=(h%10)+(h/10); }
                newnum+=h;
                count+=Integer.parseInt(String.valueOf(h));
            }
            else {
                newnum+=nums.charAt(i);
                count+=Integer.parseInt(String.valueOf(nums.charAt(i)));
            }

        }
        return 10-count%10==Integer.parseInt(numK);

    }
    public static String numToEng(int a){
        String str="";
        if (a==0) return "zero";
        if (a>99){
        switch (a/100){
            case 1: {str += "one hundred ";break;}
            case 2: {str += "two hundred ";break;}
            case 3: {str += "three hundred ";break;}
            case 4: {str += "four hundred ";break;}
            case 5: {str += "five hundred ";break;}
            case 6: {str += "six hundred ";break;}
            case 7: {str += "seven hundred ";break;}
            case 8: {str += "eight hundred ";break;}
            case 9: {str += "nine hundred ";break;}
        }}
        if (a>9){
        switch (a%100/10){
            case 1: {switch (a%10){
                case 1: {str += "eleven";return str;}
                case 2: {str += "twelve";return str;}
                case 3: {str += "thirteen";return str;}
                case 4: {str += "fourteen";return str;}
                case 5: {str += "fifteen";return str;}
                case 6: {str += "sixteen";return str;}
                case 7: {str += "seventeen";return str;}
                case 8: {str += "eighteen";return str;}
                case 9: {str += "nineteen";return str;}}}
            case 2: {str += "twenty ";break;}
            case 3: {str += "thirty ";break;}
            case 4: {str += "forty ";break;}
            case 5: {str += "fifty ";break;}
            case 6: {str += "sixty ";break;}
            case 7: {str += "seventy ";break;}
            case 8: {str += "eighty ";break;}
            case 9: {str += "ninety ";break;}
        }}
        if (a>0){
        switch (a%10){
            case 1: {str += "one";break;}
            case 2: {str += "two";break;}
            case 3: {str += "three";break;}
            case 4: {str += "four";break;}
            case 5: {str += "five";break;}
            case 6: {str += "six";break;}
            case 7: {str += "seven";break;}
            case 8: {str += "eight";break;}
            case 9: {str += "nine";break;}
        }}
        return str;
    }
    public static String numToRus(int num){
        String str="";
        if (num==0) return "ноль";
        if (num>99){
        switch (num/100){
            case 1: {str += "сто ";break;}
            case 2: {str += "двести ";break;}
            case 3: {str += "триста ";break;}
            case 4: {str += "четыреста ";break;}
            case 5: {str += "пятьсот ";break;}
            case 6: {str += "шестьсот ";break;}
            case 7: {str += "семьсот ";break;}
            case 8: {str += "восемьсот ";break;}
            case 9: {str += "девятьсот ";break;}
        }}
        if (num>9){
        switch (num%100/10){
            case 1: {str += "десять ";break;}
            case 2: {str += "двадцать ";break;}
            case 3: {str += "тридцать ";break;}
            case 4: {str += "сорок ";break;}
            case 5: {str += "пятьдесят ";break;}
            case 6: {str += "шестьдесят ";break;}
            case 7: {str += "семьдесят ";break;}
            case 8: {str += "восемьдесят ";break;}
            case 9: {str += "девяносто ";break;}
        }}
        if (num>0){
        switch (num%10){
            case 1: {str += "один";break;}
            case 2: {str += "два";break;}
            case 3: {str += "три";break;}
            case 4: {str += "четыре";break;}
            case 5: {str += "пять";break;}
            case 6: {str += "шесть";break;}
            case 7: {str += "семь";break;}
            case 8: {str += "восемь";break;}
            case 9: {str += "девять";break;}
        }}
        return str;
    }
    public static String getSha256Hash(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static String correctTitle(String str){
        str=str.toLowerCase();
        String[] strings = str.split(" ");
        String result="";
        for (int i=0; i<strings.length; i++){
            if (!(strings[i].equals("and") || strings[i].equals("the") || strings[i].equals("of") || strings[i].equals("in"))){
               if (!strings[i].contains("-")) {
                   strings[i] = String.valueOf(strings[i].charAt(0)).toUpperCase() + strings[i].substring(1);
                   result += strings[i]+" ";
               }
               else {
                   String str1=strings[i].split("-")[0];
                   str1=String.valueOf(str1.charAt(0)).toUpperCase()+str1.substring(1);
                   String str2=strings[i].split("-")[1];
                   str2=String.valueOf(str2.charAt(0)).toUpperCase()+str2.substring(1);
                   strings[i]=str1+str2;
                   result+=strings[i]+" ";
               }
            }
            else result+=strings[i]+" ";
        }
        return result.trim();
    }
    public static String hexLattice(int n){
        int x = (int)(1+(1+Math.pow((4*((double)n-1)/3),0.5f)))/2;
        if ((x*3*(x-1)+1!=n)) return "Invalid";
        String str = "";
        int count=x-1;
        //System.out.println(x);
        //System.out.println(((x%2==0) ? x/2+1 : x/2+2));
        for (int i=0; i<x ; i++){
            count++;
            for (int j=0; j<x+x-1-i; j++) {
               str += " ";
            }
            for (int j=0; j<count; j++) {
                str += "o"+" ";
            }
            str+="\n";
        }
        //
        for (int i=x-1; i>0; i--){
            count--;
            for (int j=x+x-1-i; j>=0; j--){
                str+= " ";
            }
            for (int j=count; j>0; j--){
                str += "o"+" ";
            }
            str+="\n";
        }

        return str;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /*int[] ints = encrypt("Sunshine");
        for (int i=0; i<ints.length; i++){
            System.out.print(ints[i]+" ");
        }*/
        int[] ints = { 72, 33, -73, 84, -12, -3, 13, -13, -68};
        /*String[] strings = {"many", "carriage", "emit", "apricot", "animal"};
        String[] strings1 = sameVowelGroup(strings);
        for (int i=0; i<strings1.length; i++){
            System.out.print(strings1[i]+" ");
        }*/
        //System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        //System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.println(hexLattice(271));
    }
}
