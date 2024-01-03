public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the character is a space, append it
            if (c == 32) {
                ans += c;
            // If the character appears for the first time, append it
            } else if (ans.indexOf(c) == -1) {
                ans += c;
            }
        }
        return ans;
    }
}