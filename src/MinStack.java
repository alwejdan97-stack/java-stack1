import java.util.Stack;

public class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public static void main(String[] args){
        MinStack min=new MinStack();
        min.push(5);
        min.push(4);
        min.push(10);
        min.push(8);
        min.pop();
        min.pop();
        min.peek();
        min.getMin();
        min.push(25);
        min.display();
    }
    public void push(int value){
        mainStack.push(value);
        if(minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }
        System.out.println("push: "+ value);
    }
    public void pop(){
        int remove=mainStack.pop();
        if(remove==minStack.peek()){
            minStack.pop();
        }
        System.out.println("pop: "+remove);
    }
    public void peek(){
        System.out.println("peek: "+mainStack.peek());
    }
    public Integer getMin(){
        return minStack.peek();
    }
    public void display(){
        System.out.println("MainStack :"+mainStack);
        System.out.println("MinStack :"+minStack);
        System.out.println("current Min: "+ getMin());
    }
}
