package model;

import java.util.Observable;

/**
 * Created by vereena on 25.04.15.
 */
public class Model extends Observable {
    //tu będą wszystkie metody działające wewnątrz tetrisa (zmieniające położenie klocków)
    public boolean[][] giveMeMap(){
        return new boolean[20][10];
    }

    public void moveLeft(){
        //jezeli ok, to notifyAll
    }

    public void moveRight(){
        //jezeli ok, to notifyAll
    }

    public void moveDown(){
        //jezeli ok, to notifyAll
    }
}
