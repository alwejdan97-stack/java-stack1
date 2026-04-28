import java.util.Stack;

public class LargestRectangleInHistogram {
    static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args){}
    public static int findLargestRectangle(int[] heights){
        if(heights==null || heights.length==0){
            return 0;
        }
        int maxArea=0;
        for(int i=0; i<heights.length; i++){
            if(stack.isEmpty() || heights[i]>=heights[stack.peek()]){ //if stack is empty add elements
                stack.push(i);
                System.out.println("adding index "+i);
            }else{
                int top=stack.pop();
                System.out.println("the top element is: "+top);
                //int width=stack.isEmpty()?i:i-stack.peek()-1;
                int width=i-stack.peek()-1;
                int area=heights[top]*width;
                System.out.println("the area is: "+heights[top] +" * "+width+ " = "+area);
                maxArea=maxArea+Math.max(maxArea,area);
            }
            while(!(stack.isEmpty())){
                int top=stack.pop();
                System.out.println("the top element is: "+top);
                int width=i-stack.peek()-1;
                int area=heights[top]*width;
                System.out.println("the area is: "+heights[top] +" * "+width+ " = "+area);
                maxArea=maxArea+Math.max(maxArea,area);
            }
        }
        return maxArea;

    }
    public static int calculateArea(int[] heights, int start, int end, int height){}
    public static int displayHistogram(int[] heights){}
    public static int displayResult(int[] heights, int maxArea){}
}
