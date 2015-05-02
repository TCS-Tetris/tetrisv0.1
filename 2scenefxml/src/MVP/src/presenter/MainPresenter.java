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
        if(state.equals("game"))
        {
            this.model=new Model();
            this.timer=new Timer(model);
            model.addObserver(this);
        }
        setChanged();
        notifyObservers();
    }

    public void exitNow() {
        System.exit(0);
    }

    public boolean[][] giveMeMap(){
        return model.giveMeMap();
    }

    public void moveLeft(){
        model.moveLeft();
    }

    public void moveRight(){
        model.moveRight();
    }


    @Override
    public void update(Observable o, Object arg) {
        notifyObservers();
    }
}
