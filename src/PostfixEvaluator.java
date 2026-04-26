import java.util.Stack;

public class PostfixEvaluator {

    public static Integer evaluatePostfix(String expression){
        Stack<Integer> evaluate=new Stack<>(); //creating the stack
        for(char token: expression.toCharArray()){
            if(Character.isDigit(token)){ //first check if the character digit or not
                evaluate.push(token-'0'); //add digit to the stack
            }else{
                int opperand1=evaluate.pop(); // if character is oprator, pop 2 opperand to stack to do different opperations
                int opperand2= evaluate.pop();
                switch(token){
                    case '*': evaluate.push(opperand1*opperand2);
                    break;
                    case '+': evaluate.push(opperand1+opperand2);
                    break;
                    case '-': evaluate.push(opperand1-opperand2);
                    break;
                    case '/': evaluate.push(opperand1/opperand2);
                    break;
                }
            }
        }
        return evaluate.pop();
    }
}
