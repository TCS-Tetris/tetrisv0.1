package view;

import presenter.MainPresenter;

/**
 * Created by vereena on 25.04.15.
 */
public class Tetris {
    public static void main(String [] args)
    {
        MainPresenter presenter = new MainPresenter();

        View view=new View();
        view.show(presenter, args);
    }
}
