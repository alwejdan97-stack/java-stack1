import java.util.Stack;

public class StackSorter {
    static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args){
        stack.push(5);
        stack.push(8);
        stack.push(1);
        stack.push(4);
        stack.push(3);
        displayStack(stack, "original");
        sortStack(stack);
        displayStack(stack, "sorted");
    }
    public static void sortStack(Stack<Integer> stack){//sort stack using another stack
        Stack<Integer> temporary=new Stack<>();
        if(!(stack.isEmpty())){
            int current=stack.pop();
            if(!(temporary.isEmpty())&&temporary.peek()<current){ // move the small element to main stack
                stack.push(temporary.pop());
            }
            temporary.push(current);
            System.out.println("step: ");
            System.out.println("main: "+stack);
            System.out.println("temporary: "+temporary);
        }
        if(!(temporary.isEmpty())){
            stack.push(temporary.pop());
        }
    }
    public static void sortStackRecursive(Stack<Integer> stack){ //recursive sorting approach
        if(stack.isEmpty()){
            return;
        }
        int top=stack.pop();
        sortStackRecursive(stack);
        insertInSortedOrder(stack,top);
    }
    public static void insertInSortedOrder(Stack<Integer> stack, int value){ //hHelper for recursive sort
        if(stack.isEmpty() || stack.peek()<value){
            stack.push(value);
            return;
        }
        int temporary= stack.pop();
        insertInSortedOrder(stack,value);
        stack.push(temporary);
    }
    public static void displayStack(Stack<Integer> stack, String name){ //display stack contents
        System.out.println(name + " : "+stack);
    }

}
