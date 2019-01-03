/*
 * this class is designed to govern one Sudoku game.
 */

public class Game {

    // integer represents Sudoku puzzle size
    int size;
    
    // 2D integer array to hold a solution of the game
    int[][] solution;
    
    // 2D integer array to be shown in the displayer
    int[][] user;
    
    /*
     * constructor of game class
     */
    public Game(int size) {
        
        this.size = size;
        
        // create solution using solution class and assign it to array for future use.
        Solution sol = new Solution(this.size);
        solution = sol.get();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + solution[i][j]);
            }
            System.out.println();
        }
    }
}
