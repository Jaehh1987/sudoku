import javafx.application.Application;
import javafx.stage.Stage;

public class Displayer extends Application {

    static Game game;
    
    /*
     * constructor of the class
     * get a game object as an argument and assign it to game variable
     */
    public Displayer(Game game) {
        this.game = game;
    }
    
    public void start(Stage stage) throws Exception {
        
    }
    
}
