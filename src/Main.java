import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
    
    // declare a game and a displayer
    static Game game;
    static Displayer displayer;
    
    public static void main(String[] args) {
        launch();
    }
    
    public void start(Stage stage) throws Exception {
        
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        
    	Scene scene = new Scene(grid,500,500);
    	stage.setTitle("SUDOKU");
    	
        stage.setScene(scene);
        stage.show();
        
        // integer represents Sudoku puzzle size
        int size = 9;
        
        // instantiate game and displayer object
        // displayer object takes game object as an argument
        game = new Game(size);
        displayer = new Displayer(game, grid);
        
        // check the integer size is perfect square or not
        Double sqrtSize = Math.sqrt(size);
        if (sqrtSize - Math.floor(sqrtSize) != 0) {
            System.out.println("Size should be perfect square number!");
            return;
        }
        
        displayer.play();
    }
}
