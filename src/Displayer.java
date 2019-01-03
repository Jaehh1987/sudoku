import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Displayer extends Application {
	
    Game game;
    TextField textField[][];
    /*
     * constructor of the class
     * get a game object as an argument and assign it to game variable
     */
    public Displayer(Game game) {
        this.game = game;
        grid = new GridPane();
        
        textField = new TextField[9][9];
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		textField[i][j] = new TextField(Integer.toString(game.solution[i][j]));
            	textField[i][j].setMinWidth(120);
        	}
        }
        	
    }
    
    public void start(Stage stage) throws Exception {
        stage.setTitle("SUDOKU");
        grid.setGridLinesVisible(true);
        
        /* create buttons */
        Button button1 = new Button("Easy");
        Button button2 = new Button("Normal");
        Button button3 = new Button("Hard");
        
        /* styling button */
        button1.setStyle("-fx-pref-width: 200px;");
        button2.setStyle("-fx-pref-width: 200px;");
        button3.setStyle("-fx-pref-width: 200px;");
        
        /* add button to gridpane*/
        grid.add(button1, 0, 0, 3, 1);
        grid.add(button2, 0, 1, 3, 1);
        grid.add(button3, 0, 2, 3, 1);
        
        /* button event handler */
   
        
        Scene scene = new Scene(grid,500,500);
        
        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	grid.getChildren().remove(button1);
            	grid.getChildren().remove(button2);
            	grid.getChildren().remove(button3);
            	gameBoard();
            }
        });
        
        button2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	grid.getChildren().remove(button1);
            	grid.getChildren().remove(button2);
            	grid.getChildren().remove(button3);
            	gameBoard();
            }
        });
        
        button3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	grid.getChildren().remove(button1);
            	grid.getChildren().remove(button2);
            	grid.getChildren().remove(button3);
            	gameBoard();
            }
        });
        
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public void gameBoard() {
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		grid.add(textField[i][j], i, j);
        	}
        }
    }
}
