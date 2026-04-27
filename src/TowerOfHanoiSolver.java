import java.util.Stack;

public class TowerOfHanoiSolver {
        static Stack<Integer> A=new Stack<>(); //creating 3 stacks (disk)
        static Stack<Integer> B=new Stack<>();
        static Stack<Integer> C=new Stack<>();
        static int move=0;
    public static void main(String[] args){
        solve(3);
        solve(4);
        solve(5);
    }
    public static void initializePegs(int numDisks){
        A.clear();
        B.clear();
        C.clear();
        for(int i=numDisks; i>=1; i--){
            A.push(i); //add to first disk
        }
    }
    public static void solve(int n) {  //using to solve specific disk
        System.out.println("=== " + n + " Disks ===");
        initializePegs(n);
        move=0;
        displayPegs();
        solveHanoi(n, 'A', 'C', 'B');
        System.out.println("Moves: " + move);
        System.out.println("Minimum: " + ((int)Math.pow(2, n) - 1));
    }
    public static void moveDisk(char fromPeg, char toPeg){
        Stack<Integer> from=getPage(fromPeg);
        Stack<Integer> to=getPage(toPeg);
        if(!(isValidMove(fromPeg, toPeg))){
            System.out.println("invalid move");
            return;
        }
        int disk=from.pop();
        to.push(disk);
        move++;
        System.out.println("move "+ disk+ " from "+ from + " to "+to);
        displayPegs();
    }
    public static boolean isValidMove(char fromPeg, char toPeg){
        Stack<Integer> f=getPage(fromPeg);
        Stack<Integer> t=getPage(toPeg);
        if(f.isEmpty()){
            return false;
        }else if(t.isEmpty()){
            return true;
        }
        if(f.peek()<t.peek()){
            return true;
        }
        return false;
    }
    public static void solveHanoi(int n, char from, char to, char aux){
        if(n==1){
            moveDisk(from,to);
            return;
        }
        solveHanoi(n-1, from, aux,to);
        moveDisk(from,to);
        solveHanoi(n-1,aux,to,from);
    }
    public static void displayPegs(){
        System.out.println("A: "+A);
        System.out.println("B: "+B);
        System.out.println("C: "+C);
    }
    public static Stack getPage(char page){
        if(page=='A'){
            return A;
        }else if(page=='B'){
            return B;
        }else{
            return C;
        }
    }

}
