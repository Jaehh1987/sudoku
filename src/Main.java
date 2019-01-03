import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
    
    // declare a game and a displayer
    static Game game;
    static Displayer displayer;
    
    public static void main(String[] args) {
        
        
        // launch GUI
//        Application.launch(Displayer.class);
        launch();
    }
    
    public void start(Stage stage) throws Exception {
    	// integer represents Sudoku puzzle size
    	int size = 9;
    	GridPane grid = new GridPane();
    	
    	// instantiate game and displayer object
        // displayer object takes game object as an argument
    	game = new Game(size);
        displayer = new Displayer(game);
        
        // check the integer size is perfect square or not
        Double sqrtSize = Math.sqrt(size);
        if (sqrtSize - Math.floor(sqrtSize) != 0) {
            System.out.println("Size should be perfect square number!");
            return;
        }
        
    	Scene scene = new Scene(grid,500,500);
    	stage.setTitle("SUDOKU");
    	
        grid.setGridLinesVisible(true);

        
        stage.setScene(scene);
        stage.show();
    }
    
    
}
