package Assignment4;

public class NQueen {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe

            if(isSafe(board, row, col)){
                board[row][col] = true;
//                display(board);
                count = count + queens(board, row+1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        //Left Diagonal
        int shiftLeft = Math.min(row, col);

        for (int i = 1; i <= shiftLeft; i++){
            if(board[row-i][col-i] == true){
                return false;
            }
        }

        // Right Diagonal
        int shiftRight = Math.min(row,board.length-col-1);
        for (int i = 1; i <= shiftRight; i++){
            if(board[row-i][col+i] == true){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean arr[] : board){
            for(boolean element : arr){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

}