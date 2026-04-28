import java.util.Stack;

public class LargestRectangleInHistogram {
    static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args){
        int[][] test={{2,1,5,6,2,3},{6,2,5,4,5,1,6},{5,4,3,2,1},{1,2,3,4,5},{7},{}};
        for(int[] heigh:test){
            //System.out.println(displayHistogram(heigh));
            int maxArea=findLargestRectangle(heigh);
            displayResult(heigh,maxArea);
        }
    }
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
    public static int calculateArea(int[] heights, int start, int end, int height){
        //calculating area
        int area;
        area=(end-start+1)*height;
        return area;
    }
    public static void displayHistogram(int[] heights){
        //using ASCII to display histogram
        if(heights.length==0){
            System.out.println("heighest is empty");
        }
        int max=0;
        for(int heigh: heights){
            max=Math.max(max,heigh);
            for(int i=max;i>0;i--){
                if(heigh>=i){
                    System.out.println("||");
                }else{
                    System.out.println(" ");
                }
            }
        }
        for(int heigh:heights){
            System.out.printf("%2d ",heigh);
        }
        System.out.println("");
    }
    public static void displayResult(int[] heights, int maxArea){
        System.out.println("the max area of rectangle is: "+maxArea);
    }
}
