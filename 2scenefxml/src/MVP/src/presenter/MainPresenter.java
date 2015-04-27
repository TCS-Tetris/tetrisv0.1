package presenter;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vereena on 25.04.15.
 */
public class MainPresenter extends Observable implements Observer{
    private String state;

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }

    public void exitNow() {
        System.exit(0);
    }

    @Override
    public void update(Observable o, Object arg) {
        notifyObservers();
    }
}
