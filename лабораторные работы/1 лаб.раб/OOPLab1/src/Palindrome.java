public class Palindrome {
        public static void main(String[] args) {
            for (int i = 0; i < args.length; i++) {
                String s = args[i];
                if (isPalindrome(s)) System.out.println(s);
            }
        }
        public static String reverseString(String s)
        {
            String rW ="";
            for (int i=s.length()-1;i>=0; i--)
            {

                char a = s.charAt(i);
                rW += a;
            }
            return rW;
        }
        public static boolean isPalindrome(String s)
        {
            String rW = reverseString(s);
            return s.equals(rW);
        }
}
