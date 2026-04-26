import java.util.Stack;

public class TextEditorWithUndoRedo {
    static  Stack<String> undo = new Stack<>();
    static   Stack<String> redo = new Stack<>();
    static String currentState ="";
    static int max=10;
    public static void main(String[] args){
        type("Java ");
        display();
        type(" Programming ");
        display();
        type("!");
        display();
        undo();
        display();
        undo();
        display();
        redo();
        display();
        type(" Java");
        display();
        undo();
        display();
    }
    public static void type(String text){
        if (undo.size()>=max){
            System.out.println("reach undo limited");
            undo.remove(0);
        }
        undo.push(currentState);
        currentState+=text;
        redo.clear();
        System.out.println("typed :" +text );
    }
    public static void undo(){
        if (!(undo.isEmpty())) {
            redo.push(currentState);
            currentState = undo.pop();
        }
    }
    public static void redo(){
        if (!(redo.isEmpty())){
            undo.push(currentState);
            currentState = redo.pop();
        }
    }
    public static void display(){
        System.out.println("current text : " + currentState);
        System.out.println("undo stack   : " + undo);
        System.out.println("redo stack   : " + redo);
    }
}
