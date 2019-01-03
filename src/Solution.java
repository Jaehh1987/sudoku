import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * this class is to create solution of Sudoku puzzle
 */
public class Solution {

    int size;
    int blockSize;
    
    int[][] solution;
    
    Random random = new Random();
    
    /*
     * constructor.
     * gets puzzle size and calculates block size
     */
    public Solution(int size) {
        this.size = size;
        blockSize = (int)Math.sqrt(size);
        solution = new int[size][size];
        create();
    }
    
    public int[][] get() {
        return solution;
    }
    
    /*
     * method to create solution.
     */
    public void create() {
        fillDiagonal();
        fillRemaining();
    }
    
    /*
     * method to fill diagonal boxes
     */
    public void fillDiagonal() {
        for (int index = 0; index < size; index += blockSize) {
            fillBlock(index);
        }
    }
    
    /*
     * method to fill one block
     */
    public void fillBlock(int index) {
        
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 1; i <= size; i++) {
            temp.add(i);
        }
        Collections.shuffle(temp);
        
        int i = 0;
        for (int row = index; row < index + blockSize; row++) {
            for (int col = index; col < index + blockSize; col++) {
                solution[row][col] = temp.get(i++);
            }
        }
    }
    
    /*
     * method to fill rest of boxes
     */
    public void fillRemaining() {
        // loop through all cells in the solution array
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // if cell is empty, fill it with possible number
                if (solution[row][col] == 0) {
                    fillCell(row, col);
                }
            }
        }
    }
    
    /*
     * method to fill one single cell of the solution array
     */
    public void fillCell(int row, int col) {
        for (int candidate = 1; candidate < size; candidate++) {
            if (check(row, col, candidate)) {
                solution[row][col] = candidate;
                return;
            }
        }
    }
    
    /*
     * method to check availability of certain number in specific position
     * if candidate can fill in solution[row][col] return true, else return false.
     */
    public boolean check(int row, int col, int candidate) {
        boolean result = (
                checkBlock(row, col, candidate)
                && checkRow(row, candidate)
                && checkCol(col, candidate)
                );
        return result;
    }
    
    /*
     * method to check availability of certain number in the block
     */
    public boolean checkBlock(int row, int col, int candidate) {
        int blockStartRow = 3 * (row / 3);
        int blockStartCol = 3 * (col / 3);
        for (int i = blockStartRow; i < blockStartRow + blockSize; i++) {
            for (int j = blockStartCol; j < blockStartCol + blockSize; j++) {
                if (solution[i][j] == candidate) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /* 
     * method to check availability of certain number in the row
     */
    public boolean checkRow(int row, int candidate) {
        for (int i = 0; i < size; i++) {
            if (solution[row][i] == candidate) {
                return false;
            }
        }
        return true;
    }
    
    /*
     * method to check availability of certain number in the column
     */
    public boolean checkCol(int col, int candidate) {
        for (int i = 0; i < size; i++) {
            if (solution[i][col] == candidate) {
                return false;
            }
        }
        return true;
    }
}


