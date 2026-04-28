import javax.swing.*;
import javax.swing.text.Position;
import java.util.Stack;

public class NQueensSolver {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args){}
    public static int solveNQueens(int n){
        if(n>=0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2 || n==3){
            return 0;
        }

    }
    public static boolean isSafe(Position pos, Stack<Position> queens){}
    public static void displayBoard(Stack<Position> queens, int n){}
    public static void displayAllSolutions(int n){

    }
}
