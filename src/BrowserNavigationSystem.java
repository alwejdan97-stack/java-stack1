import java.util.Stack;

public class BrowserNavigationSystem {
    static String currentPage;
    static Stack<String> backStack =new Stack<>();
    static Stack<String>  forwardStack =new Stack<>();
    public static void main(String[] args){
        BrowserNavigationSystem browser=new BrowserNavigationSystem();
        browser.visitPage("www.google.com");
        browser.visitPage("");
        browser.visitPage("www.youtube.com");
        browser.visitPage("www.inastagram.com");
        browser.visitPage("www.linkedin.com");
        browser.goBack();
        browser.goForward();
        browser.showCurrentPage();
        browser.showHistory();
        browser.goBack();
        browser.showHistory();
        browser.goForward();
        browser.showHistory();
    }
    public static void visitPage(String url){
        //String currentPage="www.youtube.com";
        if(currentPage != null){
            backStack.push(currentPage);
        }
        forwardStack.clear();
        currentPage=url;
        System.out.println("visit the current website ");
        showCurrentPage();
    }
    public static void goBack(){
        if(backStack.isEmpty()){
            System.out.println("can not go back");
        }
        backStack.push(currentPage);
        currentPage= backStack.pop();
        System.out.println("go pack ");
        showHistory();
    }
    public static void goForward(){ //method for go forward
        if(forwardStack.isEmpty()){ //check if the stack empty or not
            System.out.println("can not go forward");
        }
        forwardStack.push(currentPage);
        currentPage=forwardStack.pop();
        System.out.println("go forward");
        showHistory();
    }
    public static void showCurrentPage(){ // method for showing the current page
        System.out.println("the current page is: "+ currentPage);
    }
    public static void showHistory(){
        for(int i= backStack.size()-1; i>=0; i--){  // print backStack from down to top
            System.out.println(backStack);
        }
        for(int i= forwardStack.size()-1; i>=0; i--){ // print forward stack from down to top
            System.out.println(forwardStack);
        }
    }
}
