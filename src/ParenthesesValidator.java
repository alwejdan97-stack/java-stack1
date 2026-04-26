import java.util.*;

public class ParenthesesValidator {
    public static void main(String[] args){
        Stack<String> parentheses=new Stack<>();
        parentheses.push("()");
        parentheses.push("[]");
        parentheses.push("{}");
        parentheses.push("{)");
        parentheses.push("[}");
        for(String item: parentheses){
            System.out.println(isBalanced(item));
        }
    }
    public static boolean  isBalanced(String expression){
        if(expression=="[]" || expression=="()" || expression=="{}"){
            return true;
        }
        return false;
    }
}
