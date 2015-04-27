package view;

import javafx.application.Application;
import presenter.MainPresenter;
import view.FXApplication;


/**
 * Created by vereena on 25.04.15.
 */
public class View {
    public void show(MainPresenter presenter, String[] args) {
        FXApplication.setMainPresenter(presenter);
        Application.launch(FXApplication.class, args);
    }
}
