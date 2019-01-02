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
        
    }
    
}


