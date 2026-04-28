import javax.swing.*;
import javax.swing.text.Position;
import java.util.Stack;

public class NQueensSolver {
    static Stack<Position> stack = new Stack<>();
    public static void main(String[] args){}
    public static int solveNQueens(int n){
        if(n>=0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2 || n==3){
            return 0;
        }

        int row=0;
        int col=0;
        int count=0;
        while(true){// finding the safe column in hte row
            boolean found= false;
            while(col <n ){
                Position pos=new Position(row,col);
                if(isSafe(pos,stack)){
                    found=true;
                    break;
                }
                col++;
            }
            if(found){
                stack.push(new Position(row,col)); //place queen and move to the next row
                System.out.println("place queen at ( "+row+" , "+col+ " ) stack ");
                for(Position p:stack){ //print the stack
                    System.out.println();
                }
                }
            }
                });
            }
        }
    }
    public static boolean isSafe(Position pos, Stack<Position> queens){
        for(Position q:queens){
            if(q.col==pos.col){
                return false;
            }
            if(Math.abs(q.row-pos.row)==Math.abs(q.col-pos.col)){
                return false;
            }
        }
        return true;
    }
    public static void displayBoard(Stack<Position> queens, int n){
        char[][] board = new char[n][n];
        // Fill board with dots
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        for (Position p : queens) { // Placing queens on board
            board[p.row][p.col] = 'Q';
        }
        System.out.print("  ");
        for (int j = 0; j < n; j++) { // Printing each column
            System.out.print(j + " ");
        }
        for (int i = 0; i < n; i++) { // Printing each row
            System.out.print(i + " ");
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void displayAllSolutions(int n){

    }
}
