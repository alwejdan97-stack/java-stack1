import java.util.Stack;

public class InfixExpressionEvaluator {
    static Stack<Double> operand = new Stack<>();
    static Stack<Character> operator = new Stack<>();
    public static void main(String[] args){
        String[] expression={"3+4*2","(1+2)*3","10+5*6","100*(2+12)","8+2*5-3","(7+3)*(5-2)","20/5+6*3", "2^3+4", "10%3+6", "5+6*(2+3)", "50/(5+5)", "9-3*2"};
        for(String str:expression){
            System.out.println("expression: "+str);
            System.out.println("result: "+evaluate(str));
        }
    }
    public static String evaluate(String expression) { //Main evaluation method
        for (int i = 0; i < expression.length(); i++) {
            char chr = expression.charAt(i);
            double hr = Character.getNumericValue(chr);
            if (chr == ' ') {
                continue;
            }
            if (isNumber(chr)) {
                StringBuilder number = new StringBuilder();
                if (i < expression.length() && isNumber(expression.charAt(i))) {
                    number.append(expression.charAt(i));
                }
                operand.push(Double.parseDouble(number.toString()));
            }else if(chr == '('){
                operator.push(chr);
            }else if (chr == ')'){
                while (!(operator.isEmpty()) && operator.peek() != '(') {
                    double a=operand.pop();
                    double b=operand.pop();
                    char op=operator.pop();
                    operand.push(applyOperation(a,b,op));
                }
                //operator.pop(); //remove (
            } else if (isOperator(chr)) {
                while (!(operator.isEmpty()) && operator.peek() != '(' && getPrecedence(operator.peek()) >= getPrecedence(chr)) {
                    double a=operand.pop();
                    double b=operand.pop();
                    char op=operator.pop();
                    operand.push(applyOperation(a,b,op));// apply the operation
                }
                //operator.push(chr);// remove (
            }
            while (!(operator.isEmpty())){
                double a=operand.pop();
                double b=operand.pop();
                char op=operator.pop();
                operand.push(applyOperation(a,b,op));
            }
            //operator.pop();
        }
        return String.valueOf(operand.pop());
    }

    public static double applyOperation(double a, double b, char operator){//Perform arithmetic
        if(operator=='+'){
            return a+b;
        }else if(operator=='-'){
            return a-b;
        }else if(operator=='*'){
            return a*b;
        }else if(operator=='/'){
            return a/b;
        }else if(operator=='%'){
            return a%b;
        }else if(operator=='^'){
            return Math.pow(a,b);
        }
        return 0;
    }
    public static int getPrecedence(char operator){ //Get operator precedence
        if(operator=='^'){
            return 3;
        }else if(operator=='*' || operator=='/' || operator=='%'){
            return 2;
        }else if(operator=='+' || operator=='-'){
            return 1;
        }
        return 0;
    }
    public static boolean isOperator(char ch){ //Check if character is an operator
        if(ch=='/' || ch=='*' || ch=='-' || ch=='+' || ch=='%' || ch=='^'){
            return true;
        }
        return false;
    }
    public static boolean isNumber(char ch){ //Check if character is a digit or decimal point
        if(Character.isDigit(ch) || ch=='.'){
            return true;
        }
        return false;
    }
}