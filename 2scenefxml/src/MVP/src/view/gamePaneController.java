package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.Observable;

/**
 * Created by vereena on 25.04.15.
 */
public class gamePaneController extends Controller{
    @FXML
    private void handleButtonAction(ActionEvent event){
        presenter.setState(null);
    }

    @Override
    public void update(Observable o,Object arg){
        //tu za pomocą presenter.giveMeMap() otrzymasz tablicę [20][10] (20 wierszy,10 kolumn, tak podobno ma teris)
        //no i tu (lub w jakiejś metodzie pomocniczej powinieneś to narysować)
    }

    //w presenterze masz metody do przesuwania w lewo/prawo do wywołania w odpowienich handlerach
}
