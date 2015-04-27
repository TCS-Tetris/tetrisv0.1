package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by vereena on 25.04.15.
 */
public class startPaneController extends Controller{
    //metoda do przelacznia ekranow
    @FXML
    private void handleButtonAction(ActionEvent event){
        presenter.setState("game");
    }

    @FXML
    private void exitApp(ActionEvent event) {
        presenter.exitNow();
    }
}


