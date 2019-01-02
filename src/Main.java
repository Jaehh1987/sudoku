import javafx.application.Application;

public class Main {
    
    // declare a game and a displayer
    static Game game;
    static Displayer displayer;
    
    public static void main(String[] args) {
        
        // instantiate game and displayer object
        // displayer object takes game object as an argument
        game = new Game();
        displayer = new Displayer(game);
        
        // launch GUI
        Application.launch(Displayer.class);
    }
}
