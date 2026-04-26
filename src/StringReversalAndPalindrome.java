import java.util.Stack;

public class StringReversalAndPalindrome {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String[] text={"mom","","s","hello","level","java"};
        for(String result: text){
            System.out.println("Original String :"+result);
            System.out.println("Reverse String :"+reverseString(result));
            System.out.println(isPalindrome(result));
            for (int i = 0; i<result.length(); i++) {
                stack.push(result.charAt(i));
                System.out.println("pushed "+result.charAt(i)+" to stack");
            }
            for (int i = 0; i<result.length(); i++) {
                char chr = stack.pop();
                System.out.println("popped "+chr+" from stack");
            }
        }
    }
    public static String reverseString(String text) {
        Stack<Character> stack = new Stack<>();
        if(text == null){
            return null; // check if the text string is null or not
        }else if(text.length() == 0){
            return "";
        }else if(text.length() == 1){
            return text;
        }
        String result = "";
        for (int i=0; i <text.length(); i++){ //pushing characters to stack using loop
            stack.push(text.charAt(i));
        }
        for (int i = 0; i < text.length(); i++) { //added pushed character to result ..reversed string using for loop
            result += stack.pop();
        }
        return result;
    }
    public static Boolean isPalindrome(String s) {
        s=s.toLowerCase().trim();  //ignoring sensitive case with space by convert the text to lowercase
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){  //check if isPalindrome
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
