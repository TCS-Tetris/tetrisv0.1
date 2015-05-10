package model;


import java.util.Observable;
import java.util.Random;

public class Model extends Observable {

    private char [][] map=new char[20][10];
    private boolean[][] block=new boolean[3][3];
    private int block_x;
    private int block_y;
    private int block_type;
    private int block_turn;
    private char block_color;

    public Model(){
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<10;j++)
                map[i][j]='.';
        }
        getRandomBlock();
    }

    private void getRandomBlock()
    {
        Random rand=new Random();
        int x=rand.nextInt(7);
        /*
        .
        .
        ..
        */
        if(x==0)
        {
            block[0][0]=false;
            block[0][1]=true;
            block[0][2]=false;

            block[1][0]=false;
            block[1][1]=true;
            block[1][2]=false;

            block[2][0]=false;
            block[2][1]=true;
            block[2][2]=true;
            block_type=0;
            block_color='0';
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
            block_type=1;
            block_color='1';
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
            block_type=2;
            block_color='2';
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
            block_type=3;
            block_color='3';
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
            block_type=4;
            block_color='4';
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
            block_type=5;
            block_color='5';
        }
        /*
        .
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
            block_type=6;
            block_color='6';
        }
        block_turn=0;
        block_x=5;
        block_y=-1;
    }

    //tu będą wszystkie metody działające wewnątrz tetrisa (zmieniające położenie klocków)
    public char[][] giveMeMap(){
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
                        if (map[block_y][block_x - 2 + i]=='.')
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
                        if (map[block_y-1][block_x - 2 + i] == '.')
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
                        if (map[block_y-2][block_x - 2 + i] == '.')
                            break;
                    }
                    return;
                }
            }
        }
        if(block_type==6 && block_turn==0)
        {
            if(map[block_y+1][block_x-1]!='.')
                return;
            map[block_y+1][block_x-1]=block_color;
            map[block_y+1][block_x]='.';
            //dla dlugiego klocka sprawdzamy i rysujemy tez jeden nizej - jesli ok, to przesuwamy na mapie
        }
        else if(block_type==6 && block_turn==1)
        {
            //dlugi jezeli wszystko bylo ok, to w lewo mozemy tak czy siak przesunac
            map[block_y][block_x+2]='.';
        }
        //przesun na mapie
        if(block_y>=0)
        {
            if(block_type==6 && block_turn==1)
            {
                map[block_y][block_x+1]=block_color;
                map[block_y][block_x]=block_color;
                map[block_y][block_x-1]=block_color;
                map[block_y][block_x-2]=block_color;
            }
            else {
                for (int i = 0; i < 3; i++) {
                    if (block[2][i] == true) {
                        map[block_y][block_x - 2 + i] = block_color;
                        map[block_y][block_x - 1 + i] = '.';
                    }
                }
            }
        }
        if(block_y>=1)
        {
            for(int i=0;i<3;i++)
            {
                if(block[1][i]==true)
                {
                    map[block_y-1][block_x - 2 + i]=block_color;
                    map[block_y-1][block_x - 1 + i]='.';
                }
            }
        }
        if(block_y>=2)
        {
            for(int i=0;i<3;i++)
            {
                if(block[0][i]==true)
                {
                    map[block_y-2][block_x - 2 + i]=block_color;
                    map[block_y-2][block_x - 1 + i]='.';
                }
            }
        }
        block_x--;
        //checkIfTouchGround();
        setChanged();
        notifyObservers();
        //jezeli ok, to notifyAll
    }

    public void moveRight(){
        if(block_y==-1)
            return;
        if(block_y>=0)
        {
            if(block_type==6 && block_turn==1)
            {
                if(block_x==7)
                    return;
                else if(map[block_y][block_x+3]!='.')
                {
                    return;
                }
            }
            else {
                for (int i = 2; i >= 0; i--) {
                    if (block[2][i] == true) {
                        if (block_x + i <= 9) {
                            if (map[block_y][block_x + i] == '.')
                                break;
                        }
                        return;
                    }
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
                        if (map[block_y-1][block_x + i] == '.')
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
                        if (map[block_y-2][block_x + i] == '.')
                            break;
                    }
                    return;
                }
            }
        }
        if(block_type==6 && block_turn==0)
        {
            if(map[block_y+1][block_x+1]!='.')
                return;
            map[block_y+1][block_x+1]=block_color;
            map[block_y+1][block_x]='.';
            //dla dlugiego klocka sprawdzamy i rysujemy tez jeden nizej - jesli ok, to przesuwamy na mapie
        }
        else if(block_type==6 && block_turn==1)
        {
            if(block_x==7)
                return;
            if(map[block_y][block_x+3]!='.')
                return;
            map[block_y][block_x+3]=block_color;
        }
        //przesun na mapie
        if(block_y>=0)
        {
            for(int i=2;i>=0;i--)
            {
                if(block[2][i]==true)
                {
                    map[block_y][block_x + i] = block_color;
                    map[block_y][block_x + i - 1] = '.';
                }
            }
        }
        if(block_y>=1)
        {
            for(int i=2;i>=0;i--)
            {
                if(block[1][i]==true)
                {
                    map[block_y-1][block_x + i] = block_color;
                    map[block_y-1][block_x + i - 1] = '.';
                }
            }
        }
        if(block_y>=2)
        {
            for(int i=2;i>=0;i--)
            {
                if(block[0][i]==true)
                {
                    map[block_y-2][block_x + i] = block_color;
                    map[block_y-2][block_x + i - 1] = '.';
                }
            }
        }
        block_x++;
        //checkIfTouchGround();
        setChanged();
        notifyObservers();
        //jezeli ok, to notifyAll
    }

    public void moveDown(){
        checkIfTouchGround();
        if(block_type==6 && block_turn==0)
        {
            map[block_y+2][block_x]=block_color;
        }
        else if(block_type==6 && block_turn==1)
        {
            map[block_y+1][block_x+2]=block_color;
            map[block_y][block_x+2]='.';
        }
        //przesuwamy w dol
        if(block[2][0]==true)
        {
            if(block_y+1>=0)
                map[block_y+1][block_x-1]=block_color;
            if(block_y>=0)
                map[block_y][block_x-1]='.';
        }
        if(block[1][0]==true)
        {
            if(block_y>=0)
                map[block_y][block_x-1]=block_color;
            if(block_y-1>=0)
                map[block_y-1][block_x-1]='.';
        }
        if(block[0][0]==true)
        {
            if(block_y-1>=0)
                map[block_y-1][block_x-1]=block_color;
            if(block_y-2>=0)
                map[block_y-2][block_x-1]='.';
        }

        if(block[2][1]==true)
        {
            if(block_y+1>=0)
                map[block_y+1][block_x]=block_color;
            if(block_y>=0)
                map[block_y][block_x]='.';
        }
        if(block[1][1]==true)
        {
            if(block_y>=0)
                map[block_y][block_x]=block_color;
            if(block_y-1>=0)
                map[block_y-1][block_x]='.';
        }
        if(block[0][1]==true)
        {
            if(block_y-1>=0)
                map[block_y-1][block_x]=block_color;
            if(block_y-2>=0)
                map[block_y-2][block_x]='.';
        }

        if(block[2][2]==true)
        {
            if(block_y+1>=0)
                map[block_y+1][block_x+1]=block_color;
            if(block_y>=0)
                map[block_y][block_x+1]='.';
        }
        if(block[1][2]==true)
        {
            if(block_y>=0)
                map[block_y][block_x+1]=block_color;
            if(block_y-1>=0)
                map[block_y-1][block_x+1]='.';
        }
        if(block[0][2]==true)
        {
            if(block_y-1>=0)
                map[block_y-1][block_x+1]=block_color;
            if(block_y-2>=0)
                map[block_y-2][block_x+1]='.';
        }
        block_y++;
        //checkIfTouchGround();
        setChanged();
        notifyObservers();
    }

    private void checkIfTouchGround()
    {
        if(block_type==6 && block_turn==0)
        {
            if(block_y==18)
            {
                getRandomBlock();
                return;
            }
            if(map[block_y+2][block_x]!='.')
            {
                getRandomBlock();
                return;
            }
            return;
        }
        else if(block_type==6 && block_turn==1)
        {
            if(block_y==19)
            {
                getRandomBlock();
                return;
            }
            if(map[block_y+1][block_x-1]!='.')
            {
                getRandomBlock();
                return;
            }
            if(map[block_y+1][block_x]!='.')
            {
                getRandomBlock();
                return;
            }
            if(map[block_y+1][block_x+1]!='.')
            {
                getRandomBlock();
                return;
            }
            if(map[block_y+1][block_x+2]!='.')
            {
                getRandomBlock();
                return;
            }
            return;
        }
        if(block_y==19)
        {
            getRandomBlock();
            return;
        }
        if(block[2][0]==true)
        {
            if(block_y+1>=0) {
                if (map[block_y + 1][block_x - 1] !='.') {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[1][0]==true)
        {
            if(block_y>=0) {
                if (map[block_y][block_x - 1] !='.') {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[0][0]==true)
        {
            if(block_y-1>=0) {
                if (map[block_y - 1][block_x - 1] !='.') {
                    getRandomBlock();
                    return;
                }
            }
        }

        if(block[2][1]==true)
        {
            if(block_y+1>=0) {
                if (map[block_y + 1][block_x] !='.') {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[1][1]==true)
        {
            if(block_y>=0) {
                if (map[block_y][block_x] !='.') {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[0][1]==true)
        {
            if(block_y-1>=0) {
                if (map[block_y - 1][block_x] !='.') {
                    getRandomBlock();
                    return;
                }
            }
        }

        if(block[2][2]==true)
        {
            if(block_y+1>=0) {
                if (map[block_y + 1][block_x + 1] !='.') {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[1][2]==true)
        {
            if(block_y>=0) {
                if (map[block_y][block_x + 1] !='.') {
                    getRandomBlock();
                    return;
                }
            }
        }
        else if(block[0][2]==true)
        {
            if(block_y-1>=0) {
                if (map[block_y - 1][block_x + 1] !='.') {
                    getRandomBlock();
                    return;
                }
            }
        }
        //jeżeli dotykamy ziemi, to getRandomBlock
    }

    public void turnBlock()
    {
        if(block_type==0)
        {
            /*
            .
            .
            ..
            */
            if(block_turn==0)
            {
                if(block_x==0)
                    return;
                if(block_y<0)
                    return;
                if(block_y>=0 && map[block_y][block_x-1]!='.')
                    return;
                if(block_y>=1 && (map[block_y-1][block_x-1]!='.' || map[block_y-1][block_x+1]!='.'))
                    return;
                if(block_y>=2)
                {
                    map[block_y-2][block_x]='.';
                }
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]=block_color;
                    map[block_y-1][block_x+1]=block_color;
                }
                if(block_y>=0)
                {
                    map[block_y][block_x - 1] = block_color;
                    map[block_y][block_x] = '.';
                    map[block_y][block_x + 1] = '.';
                }
                block[0][1]=false;
                block[1][0]=true;
                block[1][2]=true;
                block[2][0]=true;
                block[2][1]=false;
                block[2][2]=false;
                block_turn=1;
            }
            else if(block_turn==1)
            {
                if(block_y<0)
                    return;
                if(block_y>=0 && map[block_y][block_x]!='.')
                    return;
                if(block_y>=2 && (map[block_y-2][block_x-1]!='.' || map[block_y-2][block_x]!='.'))
                    return;
                if(block_y>=0)
                {
                    map[block_y][block_x-1]='.';
                    map[block_y][block_x]=block_color;
                }
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]='.';
                    map[block_y-1][block_x+1]='.';
                }
                if(block_y>=2)
                {
                    map[block_y-2][block_x-1]=block_color;
                    map[block_y-2][block_x]=block_color;
                }
                block[0][0]=true;
                block[0][1]=true;
                block[1][0]=false;
                block[1][2]=false;
                block[2][0]=false;
                block[2][1]=true;
                block_turn=2;
            }
            else if(block_turn==2)
            {
                if(block_x==9)
                    return;
                if(block_y<0)
                    return;
                if(block_y>=1 && (map[block_y-1][block_x-1]!='.' || map[block_y-1][block_x+1]!='.'))
                    return;
                if(block_y>=2 && map[block_y-2][block_x+1]!='.')
                    return;
                if(block_y>=0)
                {
                    map[block_y][block_x]='.';
                }
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]=block_color;
                    map[block_y-1][block_x+1]=block_color;
                }
                if(block_y>=2)
                {
                    map[block_y-2][block_x-1]='.';
                    map[block_y-2][block_x]='.';
                    map[block_y-2][block_x+1]=block_color;
                }
                block[0][0]=false;
                block[0][1]=false;
                block[1][1]=false;
                block[1][2]=true;
                block[2][0]=true;
                block[2][2]=true;
                block_y--;
                block_turn=3;
            }
            else
            {
                if(block_y<0)
                    return;
                if(block_y==19)
                    return;
                if(block_y>=0 && (map[block_y+1][block_x]!='.' || map[block_y+1][block_x+1]!='.'))
                    return;
                if(block_y>=1 && map[block_y-1][block_x]!='.')
                    return;
                if(block_y>=0)
                {
                    map[block_y+1][block_x]=block_color;
                    map[block_y+1][block_x+1]=block_color;
                    map[block_y][block_x-1]='.';
                    map[block_y][block_x+1]='.';
                }
                if(block_y>=1)
                {
                    map[block_y-1][block_x]=block_color;
                    map[block_y-1][block_x+1]='.';
                }
                block[0][1]=true;
                block[1][1]=true;
                block[1][2]=false;
                block[2][0]=false;
                block_y++;
                block_turn=0;
            }
        }
        else if(block_type==1)
        {
            /*
             .
             .
            ..
            */
            if(block_turn==0) {
                if(block_y<0)
                    return;
                if(block_x==9)
                    return;
                if(block_y>=1 && (map[block_y-1][block_x-1]!='.' || map[block_y-1][block_x+1]!='.'))
                    return;
                if(block_y>=2 && map[block_y-2][block_x-1]!='.')
                    return;
                if(block_y>=0)
                {
                    map[block_y][block_x-1]='.';
                    map[block_y][block_x]='.';
                }
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]=block_color;
                    map[block_y-1][block_x+1]=block_color;
                }
                if(block_y>=2)
                {
                    map[block_y-2][block_x-1]=block_color;
                    map[block_y-2][block_x]='.';
                }
                block[0][1]=false;
                block[1][0]=true;
                block[1][1]=false;
                block[2][2]=true;
                block_y--;
                block_turn=1;
            }
            else if(block_turn==1)
            {
                if(block_y<0)
                    return;
                if(block_y==19)
                    return;
                if(block_y>=0 && map[block_y+1][block_x]!='.')
                    return;
                if(block_y>=1 && (map[block_y-1][block_x]!='.' || map[block_y-1][block_x+1]!='.'))
                    return;
                if(block_y>=0)
                {
                    map[block_y+1][block_x]=block_color;
                    map[block_y][block_x-1]='.';
                    map[block_y][block_x+1]='.';
                }
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]='.';
                    map[block_y-1][block_x]=block_color;
                    map[block_y-1][block_x+1]=block_color;
                }
                block[0][1]=true;
                block[0][2]=true;
                block[1][0]=false;
                block[1][1]=true;
                block[2][0]=false;
                block[2][2]=false;
                block_y++;
                block_turn=2;
            }
            else if(block_turn==2)
            {
                if(block_y<0)
                    return;
                if(block_x==0)
                    return;
                if(block_y>=0 && map[block_y][block_x+1]!='.')
                    return;
                if(block_y>=1 && (map[block_y-1][block_x-1]!='.' || map[block_y-1][block_x+1]!='.'))
                    return;
                if(block_y>=0)
                {
                    map[block_y][block_x]='.';
                    map[block_y][block_x+1]=block_color;
                }
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]=block_color;
                    map[block_y-1][block_x+1]=block_color;
                }
                if(block_y>=2)
                {
                    map[block_y-2][block_x]='.';
                    map[block_y-2][block_x+1]='.';
                }
                block[0][1]=false;
                block[0][2]=false;
                block[1][0]=true;
                block[1][2]=true;
                block[2][1]=false;
                block[2][2]=true;
                block_turn=3;
            }
            else
            {
                if(block_y<0)
                    return;
                if(block_y>=0 && (map[block_y][block_x-1]!='.' || map[block_y][block_x]!='.'))
                    return;
                if(block_y>=2 && map[block_y-2][block_x]!='.')
                    return;
                if(block_y>=0)
                {
                    map[block_y][block_x-1]=block_color;
                    map[block_y][block_x]=block_color;
                    map[block_y][block_x+1]='.';
                }
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]='.';
                    map[block_y-1][block_x+1]='.';
                }
                if(block_y>=2)
                    map[block_y-2][block_x]=block_color;
                block[0][1]=true;
                block[1][0]=false;
                block[1][2]=false;
                block[2][0]=true;
                block[2][1]=true;
                block[2][2]=false;
                block_turn=0;
            }
        }
        else if(block_type==2)
        {
            /*

             ..
            ..
            */
            if(block_turn==0)
            {
                if(block_y<0)
                    return;
                if(block_y>=0 && map[block_y][block_x+1]!='.')
                    return;
                if(block_y>=2 && map[block_y-2][block_x]!='.')
                    return;
                if(block_y>=0)
                {
                    map[block_y][block_x-1]='.';
                    map[block_y][block_x]='.';
                    map[block_y][block_x+1]=block_color;
                }
                if(block_y>=2)
                    map[block_y-2][block_x]=block_color;
                block[0][1]=true;
                block[2][0]=false;
                block[2][1]=false;
                block[2][2]=true;
                block_turn=1;
            }
            else
            {
                if(block_y<0)
                    return;
                if(block_x==0)
                    return;
                if(block_y>=0 && (map[block_y][block_x-1]!='.' || map[block_y][block_x]!='.'))
                    return;
                if(block_y>=0)
                {
                    map[block_y][block_x-1]=block_color;
                    map[block_y][block_x]=block_color;
                    map[block_y][block_x+1]='.';
                }
                if(block_y>=2)
                    map[block_y-2][block_x]='.';
                block[0][1]=false;
                block[2][0]=true;
                block[2][1]=true;
                block[2][2]=false;
                block_turn=0;
            }
        }
        else if(block_type==3)
        {
            /*

            ..
             ..
            */
            if(block_turn==0)
            {
                if(block_y<0)
                    return;
                if(block_y>=1 && map[block_y-1][block_x+1]!='.')
                    return;
                if(block_y>=2 && map[block_y-2][block_x+1]!='.')
                    return;
                if(block_y>=0)
                    map[block_y][block_x+1]='.';
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]='.';
                    map[block_y-1][block_x+1]=block_color;
                }
                if(block_y>=2)
                    map[block_y-2][block_x+1]=block_color;
                block[0][2]=true;
                block[1][0]=false;
                block[1][2]=true;
                block[2][2]=false;
                block_turn=1;
            }
            else
            {
                if(block_y<0)
                    return;
                if(block_x==0)
                    return;
                if(block_y>=0 && map[block_y][block_x+1]!='.')
                    return;
                if(block_y>=1 && map[block_y-1][block_x-1]!='.')
                    return;
                if(block_y>=0)
                    map[block_y][block_x+1]=block_color;
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]=block_color;
                    map[block_y-1][block_x+1]='.';
                }
                if(block_y>=2)
                    map[block_y-2][block_x+1]='.';
                block[0][2]=false;
                block[1][0]=true;
                block[1][2]=false;
                block[2][2]=true;
                block_turn=0;
            }
        }
        else if(block_type==4)
        {
            /*

             .
            ...
            */
            if(block_turn==0) {
                if(block_y<0)
                    return;
                if(block_y==19)
                    return;
                if(block_y>=0 && map[block_y+1][block_x]!='.')
                    return;
                if(block_y>=0)
                {
                    map[block_y+1][block_x]=block_color;
                    map[block_y][block_x-1]='.';
                }
                block[0][1]=true;
                block[1][2]=true;
                block[2][0]=false;
                block[2][2]=false;
                block_y++;
                block_turn=1;
            }
            else if(block_turn==1)
            {
                if(block_y<0)
                    return;
                if(block_x==0)
                    return;
                if(block_y>=1 && map[block_y-1][block_x-1]!='.')
                    return;
                if(block_y>=1)
                    map[block_y-1][block_x-1]=block_color;
                if(block_y>=2)
                    map[block_y-2][block_x]='.';
                block[0][1]=false;
                block[1][0]=true;
                block_turn=2;
            }
            else if(block_turn==2)
            {
                if(block_y<0)
                    return;
                if(block_y>=2 && map[block_y-2][block_x]!='.')
                    return;
                if(block_y>=1)
                    map[block_y-1][block_x+1]='.';
                if(block_y>=2)
                    map[block_y-2][block_x]=block_color;
                block[0][1]=true;
                block[1][2]=false;
                block_turn=3;
            }
            else
            {
                if(block_y<0)
                    return;
                if(block_x==9)
                    return;
                if(block_y>=1 && map[block_y-1][block_x+1]!='.')
                    return;
                if(block_y>=0)
                    map[block_y][block_x]='.';
                if(block_y>=1)
                    map[block_y-1][block_x+1]=block_color;
                block[0][1]=false;
                block[1][0]=false;
                block[2][0]=true;
                block[2][2]=true;
                block_y--;
                block_turn=0;
            }
        }
        else if(block_type==5)
        {
            /*

            ..
            ..
            */
            //bez obrotu
            return;
        }
        else if(block_type==6)
        {
            /*
            .
            .
            .
            .
             */
            if(block_turn==0)
            {
                if(block_y<0)
                    return;
                if(block_x>17)
                    return;
                if(block_x==0)
                    return;
                if(block_y>=1 && (map[block_y-1][block_x-1]!='.' || map[block_y-1][block_x+1]!='.'
                        || map[block_y-1][block_x+2]!='.'))
                    return;
                if(block_y>=0)
                {
                    map[block_y+1][block_x]='.';
                    map[block_y][block_x]='.';
                }
                if(block_y>=1)
                {
                    map[block_y-1][block_x-1]=block_color;
                    map[block_y-1][block_x+1]=block_color;
                    map[block_y-1][block_x+2]=block_color;
                }
                if(block_y>=2)
                    map[block_y-2][block_x]='.';
                block[0][1]=false;
                block[1][1]=false;
                block[2][0]=true;
                block[2][2]=true;
                block_y--;
                block_turn=1;
            }
            else
            {
                if(block_y<0)
                    return;
                if(block_y>17)
                    return;
                if(block_y>=0 && (map[block_y+2][block_x]!='.' || map[block_y+1][block_x]!='.'))
                    return;
                if(block_y>=1 && map[block_y-1][block_x]!='.')
                    return;
                if(block_y>=0)
                {
                    map[block_y+2][block_x]=block_color;
                    map[block_y+1][block_x]=block_color;
                    map[block_y][block_x-1]='.';
                    map[block_y][block_x+1]='.';
                    map[block_y][block_x+2]='.';
                }
                if(block_y>=1)
                    map[block_y-1][block_x]=block_color;
                block[0][1]=true;
                block[1][1]=true;
                block[2][0]=false;
                block[2][2]=false;
                block_y++;
                block_turn=0;
            }
        }
        setChanged();
        notifyObservers();
    }
}
