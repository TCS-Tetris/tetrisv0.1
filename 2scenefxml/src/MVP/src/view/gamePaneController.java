package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Created by vereena on 25.04.15.
 */
public class gamePaneController extends Controller{
    @FXML
    private void handleButtonAction(ActionEvent event){
        presenter.setState(null);
    }
}
