import java.util.*;
public class QueueUsingTwoStacks<T>{
    Stack<T> input=new Stack<>();
    Stack<T> output=new Stack<>();
    public static void main(String[] args){
        QueueUsingTwoStacks<Integer> queue=new QueueUsingTwoStacks<>();
        queue.enqueue(10);
        queue.enqueue(4);
        queue.enqueue(25);
        queue.enqueue(14);
        queue.dequeue();
        queue.enqueue(3);
        queue.peek();
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(15);
        System.out.println("check if queu empty or not: "+queue.isEmpty());
        queue.size();
    }
    public void enqueue(T element){
        input.push(element);
        System.out.println("Enqueue is: "+element);
    }
    public void dequeue(){
        if(output.isEmpty()){
            if(!(input.isEmpty())){
                output.push(input.pop());
            }
        }
        System.out.println("Dequeue is: "+ output.pop());
    }
    public void peek(){
        if(output.isEmpty()){
            if(!(input.isEmpty())){
                output.push(input.pop());
            }
        }
        System.out.println("Peek is: "+ output.peek());
    }
    public boolean isEmpty(){
        if(input.isEmpty() && output.isEmpty()){
            return true;
        }
        return false;
    }
    public int size(){
        int size = input.size() + output.size();
        System.out.println("size is: "+size);
        return size;
    }
}
