import javafx.application.Application;

public class Main {
    
    // declare a game and a displayer
    static Game game;
    static Displayer displayer;
    
    public static void main(String[] args) {
        
        // integer represents Sudoku puzzle size
        int size = 9;
        
        // check the integer size is perfect square or not
        Double sqrtSize = Math.sqrt(size);
        if (sqrtSize - Math.floor(sqrtSize) != 0) {
            System.out.println("Size should be perfect square number!");
            return;
        }
       
        // instantiate game and displayer object
        // displayer object takes game object as an argument
        game = new Game(size);
        displayer = new Displayer(game);
        
        // launch GUI
        Application.launch(Displayer.class);
    }
}
