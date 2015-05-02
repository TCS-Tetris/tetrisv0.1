package model;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vereena on 02.05.15.
 */
public class Timer implements Observer{
    boolean gameOn;
    Model model;

    public Timer(Model model)
    {
        this.model=model;
        this.gameOn=true;
        model.addObserver(this);
    }
    public void moveDown()
    {
        while(gameOn==true)
        {
            //poczekaj jakas ilosc czasu
            model.moveDown();
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
