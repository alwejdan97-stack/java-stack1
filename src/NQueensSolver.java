import javax.swing.*;
import javax.swing.text.Position;
import java.util.Stack;

public class NQueensSolver {
    static class Position{ // creating position class to store rows and columns
        int row;
        int col;
        Position(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static Stack<Position> stack = new Stack<>();
    public static void main(String[] args){
        System.out.println("N=0 solutions: ");
        solveNQueens(0);
        System.out.println("N=1 solutions: ");
        solveNQueens(1);
        System.out.println("N=3 solutions: ");
        solveNQueens(3);
        displayAllSolutions(3);
    }
    public static void solveNQueens(int n){
        if(n==0){
            System.out.println("no board for N=0");
            return ;
        }
        int row=0;
        int col=0;
        int count=0;
        while(true) {// finding the safe column in hte row
            boolean found = false;
            while (col < n) {
                Position pos = new Position(row,col);
                if (isSafe(pos, stack)) {
                    found = true;
                    break;
                }
                col++;
            }
            if (found){
                stack.push(new Position(row, col)); //place queen and move to the next row
                System.out.println("place queen at ( " + row + " , " + col + " ) stack ");
                for (Position p : stack) { //print the stack
                    System.out.println("(" + p.row + "," + p.col + ") ");
                }
                if (row == n - 1) {
                    count++;
                    System.out.println("Solution " + count + ":");
                    Position last = stack.pop();
                    row = last.row;
                    col = last.col + 1;
                } else {
                    row++;
                    col = 0;
                }
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                Position last = stack.pop();
                row = last.row;
                col = last.col + 1;
            }
        }
        System.out.println("total solutions for N=" + n + ": " + count);
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
        for (int i = 0; i < n; i++) { // Fill board with ...
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        for (Position p : queens) { // Placing queens on board
            board[p.row][p.col]= 'Q';
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
        System.out.println("*** display the solution ***");
        solveNQueens(n);
    }
}
