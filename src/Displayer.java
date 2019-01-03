import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Displayer {
	
    Game game;
    TextField textField[][];
    GridPane grid;
    /*
     * constructor of the class
     * get a game object as an argument and assign it to game variable
     */
    public Displayer(Game game, GridPane grid) {
        this.game = game;
        this.grid = grid;
        
        textField = new TextField[9][9];
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		textField[i][j] = new TextField(Integer.toString(game.solution[i][j]));
            	textField[i][j].setMinWidth(10);
        	}
        }
    }
    
    public void play() throws Exception {
       
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
    }
    
    public void gameBoard() {
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		grid.add(textField[j][i], i, j);
        	}
        }
    }
}
