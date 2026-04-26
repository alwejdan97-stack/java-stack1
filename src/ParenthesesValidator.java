import java.util.*;

public class ParenthesesValidator {
    public static void main(String[] args){
        Stack<String> parentheses=new Stack<>(); // creating stack
        parentheses.push("()"); // add elements to the stack
        parentheses.push("[]");
        parentheses.push("{}");
        parentheses.push("{)");
        parentheses.push("[}");
        for(String item: parentheses){ // enter the stack to check the validation of balancing
            System.out.println(isBalanced(item));
        }
    }
    public static boolean  isBalanced(String expression){ // method for checking the balancing of parentheses
        if(expression=="[]" || expression=="()" || expression=="{}"){
            return true;
        }else if(expression.isEmpty()){
            return false;
        }
        return false;
    }
}
