package presenter;

import model.Model;
import model.Timer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vereena on 25.04.15.
 */
public class MainPresenter extends Observable implements Observer{
    private String state;
    private Model model;
    private Timer timer;

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
        if(state!=null && state.equals("game"))
        {
            model=new Model();
            timer=new Timer(model);
            model.addObserver(this);
            timer.startMovingDown();
        }
        else if(model!=null && timer!=null)
        {
            timer.gameOn=false;
            model.deleteObserver(timer);
            model.deleteObserver(this);
            model=null;
            timer=null;
        }
        setChanged();
        notifyObservers();
    }

    public void exitNow() {
        System.exit(0);
    }

    public char[][] giveMeMap(){
        return model.giveMeMap();
    }

    public void moveLeft(){
        model.moveLeft();
    }

    public void moveRight(){
        model.moveRight();
    }

    public void moveDown() { model.moveDown();}

    public void turnBlock() { model.turnBlock();}

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
