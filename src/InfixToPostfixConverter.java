import java.util.*;
public class InfixToPostfixConverter {
    static Stack<Character> ops = new Stack<>();
    static StringBuilder output = new StringBuilder();
    static String precedent;
    public static void main(String[] args){
        String[] array={"3+4*2","8/4+2","5/5%2","20-5/3","1+2*3","15/5*3","8*9/2","7*3%10"};
        for(String result:array){
            System.out.println("expression is :"+result);
            String postfix=infixToPostfix(result);
            System.out.println("to post fix is: "+postfix);
            int evaluation=evaluatePostfix(result);
            System.out.println("the evaluation of postfix is: "+evaluation);
        }
    }
    //
    public static String infixToPostfix(String infix){
        String result="";
        for(int i=0; i<infix.length(); i++){
            char chr=infix.charAt(i);
            if(chr==' '){
                continue;
            }else if(Character.isDigit(chr)){
                result= result + chr + " ";
            }else if(chr=='('){
                ops.push(chr);
                System.out.println(ops);
            }else if(chr==')'){
                while(ops.isEmpty() && ops.peek()!='('){
                    result= result + ops.pop() + " ";
                }
                ops.push(chr);
                if(!(ops.isEmpty()) && ops.peek()!='('){
                    result= result + ops.pop() + " ";
                }else{
                    while(!(ops.isEmpty()) && (getPrecedence(ops.peek())>=(getPrecedence(chr)))){
                        result= result + ops.pop() + " ";
                    }
                    ops.push(chr);
                }
            }else if(!(ops.isEmpty())){
                result= result + ops.pop() + " ";
            }
        }
        return result;
    }
    public static int evaluatePostfix(String postfix){
        Stack<Integer> evaluate=new Stack<>();
        int result=0;
        for(String str:postfix.split(" ")){ //convert string operation to mathmatic operations
            if(str.matches("\\d+(\\.\\d+)?")){
                evaluate.push(Integer.parseInt(str));
            }else if(evaluate.size()>2){
                int a=evaluate.pop();
                int b=evaluate.pop();
                result=result+applyOperation(a,b,str.charAt(0));
                evaluate.push(result);
            }
        }
        return result;
    }
    //check from the precedence of operator
    public static int getPrecedence(char operator){
        if(operator=='^'){
            return 3;
        }else if(operator=='*' || operator=='/' || operator=='%'){
            return 2;
        }else if(operator=='+' || operator=='-'){
            return 1;
        }else{
            return 0;
        }
    }
    //check the character if operator or not
    public static boolean isOperator(char ch){
        if(ch =='*' || ch=='-' || ch=='+' || ch=='/' || ch=='%'){
        }
        return false;
    }
    //apply the operation
    public static int applyOperation(int a, int b, char operator) {
        int result = 0;
        if (operator == '*') {
            result=result+(a * b);
        }else if(operator=='+'){
            result=result+(a+b);
        }else if(operator=='-'){
            result=result+(a-b);
        }else if(operator=='/'){
            result=result+(a/b);
        }else if(operator=='%'){
            result=result+(a%b);
        }
        return result;
    }
}
