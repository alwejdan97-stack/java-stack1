import java.util.Stack;

public class BrowserHistorySimulator {
    public static void main(String[] args) {
        Stack<String> browserHistorySimulator = new Stack<>();// create stack
        browserHistorySimulator.push("https://www.github.com"); // add element to the stack
        browserHistorySimulator.push("https://www.google.com");
        browserHistorySimulator.push("https://www.youtube.com");
        browserHistorySimulator.push("https://www.Linkedin.com");
        browserHistorySimulator.push("https://www.Instgram.com");
        System.out.println("the current page and all pages in history after each visit is:" +browserHistorySimulator);
        System.out.println("Back 2 ");//using pop to back
        System.out.println(browserHistorySimulator.pop());
        System.out.println(browserHistorySimulator.pop());
        System.out.println("Display the current page and all pages in history after each visit :" +browserHistorySimulator); // Displayed element after pop
//peek the to element
        System.out.println("peek the top URL:" +browserHistorySimulator);
        System.out.println("check if the stack empty or not: "+ browserHistorySimulator.isEmpty()); // Check if the history is empty at different points
        browserHistorySimulator.push("https://www.anthrophic.com");//added 2 elements
        browserHistorySimulator.push("https://www.z.ai");
        System.out.println(browserHistorySimulator); //display all element
        }
}
