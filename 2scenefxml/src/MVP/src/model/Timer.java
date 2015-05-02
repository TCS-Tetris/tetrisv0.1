package model;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vereena on 02.05.15.
 */
public class Timer implements Observer{
    public boolean gameOn;
    Model model;

    public class Tick extends Thread{
        public void run()
        {
            while(gameOn==true)
            {
                model.moveDown();
                try {
                    this.sleep(500);
                }catch (InterruptedException e)
                {}
                //poczekaj jakas ilosc czasu
            }
        }
    }
    public Timer(Model model)
    {
        this.model=model;
        this.gameOn=true;
        model.addObserver(this);
    }
    public void startMovingDown() {
        Thread t=new Tick();
        t.start();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
