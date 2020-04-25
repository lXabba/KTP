

public class file2 {
    public static String repeat(String str, int a){
        String result="";
        for (int i=0; i<str.length(); i++){
            for (int g=0; g<a; g++) {
                result += str.charAt(i);
            }
        }
        return result;
    }
    public static int differenceMaxMin(int[] ints){
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for (int i=0; i<ints.length; i++){
            if (ints[i]<min) min=ints[i];
            if (ints[i]>max) max=ints[i];
        }
        return (max-min);
    }
    public static boolean isAvgWhole(int[] ints){
        int sum=0;
        for (int i=0; i<ints.length; i++){
            sum+=ints[i];
        }
        return  (double)sum%(double) ints.length==0;
    }
    public static int[] cumulativeSum(int[] ints){
        int[] result = new int[ints.length];
        int count=0;
        for (int i=0; i<ints.length; i++){
            count+=ints[i];
            result[i]=count;
        }
        return result;
    }
    public static int getDecimalPlaces(String a){
        if (!a.contains(".")) return 0;
        else return a.split("\\.")[1].length();
    }
    public static int Fibonacci(int a){
        int b=1, c=1, count=0;

        for (int i=1; i<a; i++){
            count = b+c;
            c=b;
            b=count;
        }
        return count;
    }
    public static boolean isValid(String a){
        if (a.length()==5)
            try{
                Integer.parseInt(a);
                return true;
            }
            catch (Exception e){
                return false;
            }
        return false;
    }
    public static boolean isStrangePair(String a, String b){
        return a.charAt(0)==b.charAt(b.length()-1)&&b.charAt(0)==a.charAt(a.length()-1);
    }
    public static boolean isPrefix(String word,String prefix){
        return word.startsWith(prefix.substring(0,prefix.length()-1));
    }
    public static boolean isSuffix(String word,String suffix){
        return  word.endsWith(suffix.substring(1));
    }
    public static int boxSeq(int a){
        if (a%2!=0) return a+2;
        else return a;
    }
    public static void main(String[] args) {
        System.out.println(boxSeq(2));
    }
}
