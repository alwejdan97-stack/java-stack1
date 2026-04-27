import java.util.Stack;
import java.util.*;

public class NextGreaterElementFinder {
    static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args){
        int[] array={1,8,4,21,10,16,6};
        int[] nextGrater=findNextGreaterElement(array);
        System.out.println("next grater is: "+nextGrater);
        displayResults(array,nextGrater);
        int[] nextSmallest=findNextSmallerElement(array);
        System.out.println("next smallest is: "+Arrays.toString(nextSmallest));
    }
    public static int[] findNextGreaterElement(int[] array){
        for(int i=0; i<array.length; i++){
            if(!(stack.isEmpty()) && array[i]>array[stack.peek()]){
                array[stack.pop()]=array[i];
            }
            stack.push(i);
        }
        return array;
    }
    public static int[] findNextGreaterElementCircular(int[] array){
        int n=array.length;
        for(int i=0; i<2*n-1; i++){
            int index=i%n;
            if(!(stack.isEmpty()) && array[index]>array[stack.peek()]){
                array[stack.pop()]=array[index];
            }
            if(i<n){
                stack.push(index);
            }
        }
        return array;
        }
    public static int[] findNextSmallerElement(int[] array){
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<array.length; i++){
            if(!(stack.isEmpty()) && array[i]<array[stack.peek()]){
                array[stack.pop()]=array[i];
            }
            stack.push(i);
        }
        return array;
    }
    public static void displayResults(int[] array, int[] result){
        System.out.println("index | value | next grater");
        for(int i=0; i<array.length; i++){
            System.out.println(i+ " | " + array[i] + " | "+ result[i]);
        }
    }
}

