package model;

import com.sun.javafx.sg.prism.NGShape;

import java.util.Observable;
import java.util.Random;

/**
 * Created by vereena on 25.04.15.
 */
public class Model extends Observable {

    private boolean [][] map=new boolean[20][10];
    private boolean[][] block=new boolean[3][3];
    private int block_x;
    private int block_y;

    public Model(){
        getRandomBlock();
    }

    private void getRandomBlock()
    {
        Random rand=new Random();
        int x=rand.nextInt()%7;
        /*
        .
        .
        ..
        */
        if(x==0)
        {
            block[0][0]=true;
            block[0][1]=false;
            block[0][2]=false;

            block[1][0]=true;
            block[1][1]=false;
            block[1][2]=false;

            block[2][0]=true;
            block[2][1]=true;
            block[2][2]=false;
        }
        /*
         .
         .
        ..
        */
        else if(x==1)
        {
            block[0][0]=false;
            block[0][1]=true;
            block[0][2]=false;

            block[1][0]=false;
            block[1][1]=true;
            block[1][2]=false;

            block[2][0]=true;
            block[2][1]=true;
            block[2][2]=false;
        }
        /*

         ..
        ..
        */
        else if(x==2)
        {
            block[0][0]=false;
            block[0][1]=false;
            block[0][2]=false;

            block[1][0]=false;
            block[1][1]=true;
            block[1][2]=true;

            block[2][0]=true;
            block[2][1]=true;
            block[2][2]=false;
        }
        /*

        ..
         ..
        */
        else if(x==3)
        {
            block[0][0]=false;
            block[0][1]=false;
            block[0][2]=false;

            block[1][0]=true;
            block[1][1]=true;
            block[1][2]=false;

            block[2][0]=false;
            block[2][1]=true;
            block[2][2]=true;
        }
        /*

         .
        ...
        */
        else if(x==4)
        {
            block[0][0]=false;
            block[0][1]=false;
            block[0][2]=false;

            block[1][0]=false;
            block[1][1]=true;
            block[1][2]=false;

            block[2][0]=true;
            block[2][1]=true;
            block[2][2]=true;
        }
        /*

        ..
        ..
        */else if(x==5)
        {
            block[0][0]=false;
            block[0][1]=false;
            block[0][2]=false;

            block[1][0]=true;
            block[1][1]=true;
            block[1][2]=false;

            block[2][0]=true;
            block[2][1]=true;
            block[2][2]=false;
        }
        /*
        .
        .
        .
         */
        else
        {
            block[0][0]=false;
            block[0][1]=true;
            block[0][2]=false;

            block[1][0]=false;
            block[1][1]=true;
            block[1][2]=false;

            block[2][0]=false;
            block[2][1]=true;
            block[2][2]=false;
        }
        block_x=5;
        block_y=-1;
    }

    //tu będą wszystkie metody działające wewnątrz tetrisa (zmieniające położenie klocków)
    public boolean[][] giveMeMap(){
        return map;
    }

    public void moveLeft(){
        if(block_y==-1)
            return;
        if(block_y>=0)
        {
            for(int i=0;i<3;i++)
            {
                if(block[2][i]==true)
                {
                    if(block_x-2+i>=0)
                    {
                        if (map[block_y][block_x - 2 + i] == false)
                            break;
                    }
                    return;
                }
            }
        }
        if(block_y>=1)
        {
            for(int i=0;i<3;i++)
            {
                if(block[1][i]==true)
                {
                    if(block_x-2+i>=0)
                    {
                        if (map[block_y-1][block_x - 2 + i] == false)
                            break;
                    }
                    return;
                }
            }
        }
        if(block_y>=2)
        {
            for(int i=0;i<3;i++)
            {
                if(block[0][i]==true)
                {
                    if(block_x-2+i>=0)
                    {
                        if (map[block_y-2][block_x - 2 + i] == false)
                            break;
                    }
                    return;
                }
            }
        }
        //przesun na mapie
        if(block_y>=0)
        {
            for(int i=0;i<3;i++)
            {
                if(block[2][i]==true)
                {
                    map[block_y][block_x - 2 + i]=true;
                    map[block_y][block_x - 1 + i]=false;
                }
            }
        }
        if(block_y>=1)
        {
            for(int i=0;i<3;i++)
            {
                if(block[1][i]==true)
                {
                    map[block_y-1][block_x - 2 + i]=true;
                    map[block_y-1][block_x - 1 + i]=false;
                }
            }
        }
        if(block_y>=2)
        {
            for(int i=0;i<3;i++)
            {
                if(block[0][i]==true)
                {
                    map[block_y-2][block_x - 2 + i]=true;
                    map[block_y-2][block_x - 1 + i]=false;
                }
            }
        }
        block_x--;
        checkIfTouchGround();
        notifyObservers();
        //jezeli ok, to notifyAll
    }

    public void moveRight(){
        if(block_y==-1)
            return;
        if(block_y>=0)
        {
            for(int i=2;i>=0;i--)
            {
                if(block[2][i]==true)
                {
                    if(block_x+i<=9)
                    {
                        if (map[block_y][block_x + i] == false)
                            break;
                    }
                    return;
                }
            }
        }
        if(block_y>=1)
        {
            for(int i=2;i>=0;i--)
            {
                if(block[1][i]==true)
                {
                    if(block_x+i<=9)
                    {
                        if (map[block_y-1][block_x + i] == false)
                            break;
                    }
                    return;
                }
            }
        }
        if(block_y>=2)
        {
            for(int i=2;i>=0;i--)
            {
                if(block[0][i]==true)
                {
                    if(block_x+i<=9)
                    {
                        if (map[block_y-2][block_x + i] == false)
                            break;
                    }
                    return;
                }
            }
        }
        //przesun na mapie
        if(block_y>=0)
        {
            for(int i=2;i>=0;i--)
            {
                if(block[2][i]==true)
                {
                    map[block_y][block_x + i] = true;
                    map[block_y][block_x + i - 1] = false;
                }
            }
        }
        if(block_y>=1)
        {
            for(int i=2;i>=0;i--)
            {
                if(block[1][i]==true)
                {
                    map[block_y-1][block_x + i] = true;
                    map[block_y-1][block_x + i - 1] = false;
                }
            }
        }
        if(block_y>=2)
        {
            for(int i=2;i>=0;i--)
            {
                if(block[0][i]==true)
                {
                    map[block_y-2][block_x + i] = true;
                    map[block_y-2][block_x + i - 1] = false;
                }
            }
        }
        block_x++;
        checkIfTouchGround();
        notifyObservers();
        //jezeli ok, to notifyAll
    }

    public void moveDown(){
        //przesuwamy w dol
        if(block[2][0]==true)
        {
            if(block_y+1>=0)
                map[block_y+1][block_x-1]=true;
            if(block_y>=0)
                map[block_y][block_x-1]=false;
        }
        if(block[1][0]==true)
        {
            if(block_y>=0)
                map[block_y][block_x-1]=true;
            if(block_y-1>=0)
                map[block_y-1][block_x-1]=false;
        }
        if(block[0][0]==true)
        {
            if(block_y-1>=0)
                map[block_y-1][block_x-1]=true;
            if(block_y-2>=0)
                map[block_y-2][block_x-1]=false;
        }

        if(block[2][1]==true)
        {
            if(block_y+1>=0)
                map[block_y+1][block_x]=true;
            if(block_y>=0)
                map[block_y][block_x]=false;
        }
        if(block[1][1]==true)
        {
            if(block_y>=0)
                map[block_y][block_x]=true;
            if(block_y-1>=0)
                map[block_y-1][block_x]=false;
        }
        if(block[0][1]==true)
        {
            if(block_y-1>=0)
                map[block_y-1][block_x]=true;
            if(block_y-2>=0)
                map[block_y-2][block_x]=false;
        }

        if(block[2][2]==true)
        {
            if(block_y+1>=0)
                map[block_y+1][block_x+1]=true;
            if(block_y>=0)
                map[block_y][block_x+1]=false;
        }
        if(block[1][2]==true)
        {
            if(block_y>=0)
                map[block_y][block_x+1]=true;
            if(block_y-1>=0)
                map[block_y-1][block_x+1]=false;
        }
        if(block[0][2]==true)
        {
            if(block_y-1>=0)
                map[block_y-1][block_x+1]=true;
            if(block_y-2>=0)
                map[block_y-2][block_x+1]=false;
        }
        block_y++;
        checkIfTouchGround();
        notifyObservers();
    }

    private void checkIfTouchGround()
    {
        if(block_y==19)
        {
            getRandomBlock();
            return;
        }
        if(block[2][0]==true)
        {
            if(block_y+1>=0) {
                if (map[block_y + 1][block_x - 1] == true) {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[1][0]==true)
        {
            if(block_y>=0) {
                if (map[block_y][block_x - 1] == true) {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[0][0]==true)
        {
            if(block_y-1>=0) {
                if (map[block_y - 1][block_x - 1] == true) {
                    getRandomBlock();
                    return;
                }
            }
        }

        if(block[2][1]==true)
        {
            if(block_y+1>=0) {
                if (map[block_y + 1][block_x] == true) {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[1][1]==true)
        {
            if(block_y>=0) {
                if (map[block_y][block_x] == true) {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[0][1]==true)
        {
            if(block_y-1>=0) {
                if (map[block_y - 1][block_x] == true) {
                    getRandomBlock();
                    return;
                }
            }
        }

        if(block[2][2]==true)
        {
            if(block_y+1>=0) {
                if (map[block_y + 1][block_x + 1] == true) {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[1][2]==true)
        {
            if(block_y>=0) {
                if (map[block_y][block_x + 1] == true) {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[0][2]==true)
        {
            if(block_y-1>=0) {
                if (map[block_y - 1][block_x + 1] == true) {
                    getRandomBlock();
                    return;
                }
            }
        }
        //jeżeli dotykamy ziemi, to getRandomBlock
    }

}
