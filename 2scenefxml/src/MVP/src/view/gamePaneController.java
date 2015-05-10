package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

import javafx.scene.canvas.*;
import java.util.Observable;
import javafx.scene.input.KeyCode;

import javafx.scene.canvas.GraphicsContext;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;



/**
 * Created by vereena on 25.04.15.
 */
public class gamePaneController extends Controller{

    @FXML
    private Canvas canvas;

    private void printSomething()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawShapes(gc);
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
    }




    @FXML
    private void handleButtonAction(ActionEvent event){
        presenter.setState(null);
    }

    @FXML
    private void handleLeftArrow(KeyEvent event){

        if (event.getCode() == KeyCode.LEFT )
        {
            //Left arrow key code
            //System.out.println("lewo w handle ");
            presenter.moveLeft();
            /****************************
             GraphicsContext gc = canvas.getGraphicsContext2D();
             //drawShapes(gc);
             gc.setFill(Color.WHITE);
             gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
             gc.setFill(Color.GREEN);
             gc.setStroke(Color.BLUE);
             gc.fillRoundRect(110, 60, 30, 30, 10, 10);

             ***************************/

    		/*
    		Canvas canvas1 = new Canvas(350, 300);
    		GraphicsContext gc = canvas1.getGraphicsContext2D();
    		gc.setFill(Color.GREEN);
  	      	gc.setStroke(Color.BLUE);
  	      	gc.fillRoundRect(110, 60, 30, 30, 10, 10);

  	      	canvas = canvas1;
  	      	*/

        }

        else if (event.getCode() == KeyCode.RIGHT)
        {
            //Right arrow key code
            //System.out.println("prawo w handle");
            presenter.moveRight();


            /****************************
             GraphicsContext gc = canvas.getGraphicsContext2D();
             gc.setFill(Color.WHITE);
             gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
             ****************************/
        }

        else if(event.getCode() == KeyCode.DOWN)
        {
            presenter.moveDown();
        }
        else if(event.getCode() == KeyCode.UP)
        {
            presenter.turnBlock();
        }
    }

    @Override
    public void update(Observable o,Object arg){
        //tu za pomocą presenter.giveMeMap() otrzymasz tablicę [20][10] (20 wierszy,10 kolumn, tak podobno ma teris)
        //no i tu (lub w jakiejś metodzie pomocniczej powinieneś to narysować)

        //System.out.println("update1");
        if(presenter.getState() != null)
        {
            char [][] MyMap = presenter.giveMeMap();


            //canvas ma wymiary 350 na 300 w tym momencie
            // to daje klocki o wymiarach 17.5 na 30 niech na razie beda 17 na 30 potem ustawie by bylo ladnie
            //czyli klocek [i][j] jest w miejscu (lewy gorny rog)
            // (i)*30, (j+1)*17,

            //czyszcze

            //System.out.println("update2");


            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            //System.out.println("po czyszczeniu");

            gc.setFill(Color.GREEN);
            gc.setStroke(Color.BLUE);




  	      	/*
  	      	for(int i = 3; i < 20; i++)
  	      	{
  	      		MyMap[i][3] = true;
  	      	}
  	      	*/

            //maluje
            for(int i = 0; i < 20; i++)
            {
                for(int j = 0; j < 10; j++)
                {
                    if(MyMap[i][j] !='.')
                    {
                        //System.out.println("to cos jest:" + i + " " + j);
                        gc.fillRoundRect((j)*30,i*17 , 30, 17, 10, 10);
                    }
                }
            }

        }



    }

    //w presenterze masz metody do przesuwania w lewo/prawo do wywołania w odpowienich handlerach
}