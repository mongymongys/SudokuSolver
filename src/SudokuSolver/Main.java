package SudokuSolver;

public class Main {
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {

        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        if (solveBoard(board)){
            System.out.println("Solved Succesfully ! ");
        }else {
            System.out.println("Unsolvable board ! ");
        }
        
        printboard(board);
    }

    private static void printboard(int[][] board) {
        for (int row= 0; row<GRID_SIZE; row++){
            for (int collumn= 0; collumn<GRID_SIZE; collumn++){
                System.out.print(board[row][collumn]);
            }
            System.out.println();
        }
    }


    private static boolean isNumbInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean isNumbInColumn(int[][] board, int number, int collumn) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][collumn] == number) {
                {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean isNumbInBox(int[][] board, int number, int row, int collumn) {
        int LocalBoxRow = row - row % 3;
        int LocalBoxCollumn = collumn - collumn % 3;

        for (int i = LocalBoxRow; i < LocalBoxRow + 3; i++){
            for( int j = LocalBoxCollumn; j< LocalBoxCollumn +3; j++){
                if(board[i][j]  == number){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int [][] board, int number, int row, int collumn ){
        return !isNumbInRow(board, number, row) &&
               !isNumbInColumn(board, number, collumn) &&
               !isNumbInBox(board, number, row, collumn);
    }

    private static boolean solveBoard(int [][] board){
        for( int row = 0; row< GRID_SIZE;row++){
            for (int collumn = 0; collumn<GRID_SIZE; collumn++){
                if (board[row][collumn] == 0){
                    for(int numberToTry = 1; numberToTry<=GRID_SIZE;numberToTry++ ){
                        if (isValidPlacement(board, numberToTry,row, collumn)){
                            board[row][collumn] = numberToTry;

                            if(solveBoard(board)){
                                return true;
                            }
                            else{
                                board[row][collumn] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}