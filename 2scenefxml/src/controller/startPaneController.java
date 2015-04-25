package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class startPaneController implements Initializable {

	//ekran startowy
    @FXML
    private Button exitButton;

    @FXML
    private Separator startSeparator2;

    @FXML
    private Separator startSeparator1;

    @FXML
    private Button newGameButton;
    
    
    //ekran gry
    @FXML
    private Label tetrisLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Pane paneField;

    @FXML
    private Button backButton;

    
    //metoda do przelacznia ekranow
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    	
    	Stage stage;
    	Parent root;
    	
    	//Stage pomStage;
    	
    	//System.out.println("cos sie dzieje");
    	//System.out.println(event.getSource());
    	if (event.getSource() == newGameButton) {
    		
    		
    		stage = (Stage) newGameButton.getScene().getWindow();
    		
    		//pomStage = stage;
    		//pomStage.close();
    		
    		root = FXMLLoader.load(getClass().getResource("/view/gamePane.fxml"));
    		//System.out.println("prawie dobrze");
    	} else {
    		
    		stage = (Stage) backButton.getScene().getWindow();
    		root = FXMLLoader.load(getClass().getResource("/view/startPane.fxml"));
    	}
    	
    	Scene scene = new Scene(root);
    	//System.out.println("3");
    	stage.setScene(scene);
    	stage.setTitle("Tetris v0.1");
    	//System.out.println("2");
    	stage.show();
    	//System.out.println("1");
    	
    }
    
    @FXML
    private void exitApp(ActionEvent event) {
    	
    	//System.out.println("action");
    	Stage stage = (Stage) exitButton.getScene().getWindow();
    	stage.close();
    }
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}


}
