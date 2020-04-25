public class file1 {
    public static int remainder(int a, int b){
        return a%b;
    }
    public static int triArea(int a, int b){
        return  (int) (a*b*0.5);
    }
    public static int animals(int chicks, int cows, int pigs){
        return chicks*2+cows*4+pigs*4;
    }
    public static boolean profitableGamble (double prob,double prize,double pay){
        return  prob * prize > pay;
    }
    public static String operation(int N,int a,int b){
        if (a+b==N) return "added";
        else if (a-b==N) return "subtracted";
        else if (a*b==N) return "multiplied";
        else if (a/b==N) return "divided";
        else return "none";
    }
    public static int ctoa(char a){
        return a;
    }
    public static int addUpTo(int a){
        int count=0;
        for (int i=0; i<=a; i++){
            count+=i;
        }
        return count;
    }
    public static int nextEdge(int a, int b){
        return a+b-1;
    }
    public static int sumOfCubes(int[] ints){
        int count=0;
        for (int i=0; i<ints.length; i++){
            count+=Math.pow(ints[i],3);
        }
        return count;
    }
    public static boolean abcmath(int a, int b, int c){
        for (int i=0; i<b; i++){
            a+=a;
        }
        return a%c==0;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5};
        System.out.println(abcmath(42, 5, 10));
    }
}
