package view;

import presenter.MainPresenter;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vereena on 25.04.15.
 */
public class Controller implements Observer{
    protected MainPresenter presenter;

    public void init(MainPresenter presenter) {
        this.presenter = presenter;
        this.presenter.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
