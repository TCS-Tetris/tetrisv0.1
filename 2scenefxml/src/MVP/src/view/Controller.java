package view;

import presenter.MainPresenter;

/**
 * Created by vereena on 25.04.15.
 */
public class Controller {
    protected MainPresenter presenter;

    public void init(MainPresenter presenter) {
        this.presenter = presenter;
    }
}
