
import java.util.*;
public class BrowserHistorySimulator {
    public static void main(String[] args) {
        Stack<String> web = new Stack<>(); // create the web stack
        web.push("www.youtube.com"); // add element to the stack
        System.out.println("the current website is: " + web.peek()); // return the last website (current web page)
        System.out.println(web); // print the full ftack
        web.push("www.google.com");
        System.out.println("the current website is: " + web.peek());
        System.out.println(web);
        web.push("www.drive.com");
        System.out.println("the current website is: " + web.peek());
        System.out.println(web);
        web.push("www.github.com");
        System.out.println("the current website is: " + web.peek());
        System.out.println(web);
        web.push("www.linkedin.com");
        System.out.println("the current website is: " + web.peek());
        System.out.println(web);
        web.pop(); // remove the last added web for the first time
        web.pop(); // remove the last added web for the second time
        System.out.println("the last website after removing 2 last website is: "+web.peek());
        System.out.println("check if the stack have websites or not: "+web.isEmpty()); // check if the stack empty or not (return false)
        web.push("www.snapchat.com");
        web.push("www.inastagram.com");
        System.out.println("final stack after visiting 2 websites is: "+web);
    }
}
