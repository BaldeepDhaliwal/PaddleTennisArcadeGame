package sample;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Baldeep on 04/04/2017.
 */
public class Ball {

    private static final int DIAMETER=30;
    private int x=0;
    private int y=50;

    private int x2=1;
    private int y2=1;
    private Main game;
    private int score=0;

    public Ball(Main game){
        //pass in game to have access to the screen width and height
        this.game=game;
    }

    //Code to update the ball position.
    public void updateBall(){


        //if past width on right border
        if(this.x>game.getWidth()-30){
            x2=-game.ballSpeed;
    }
        //if past left border
        if(this.x<0)
            x2=game.ballSpeed;


        if(this.y>game.getHeight()-30){
            y2=-game.ballSpeed;
        }
        if(this.y<0)
            y2=game.ballSpeed;

        if(this.y>=(game.getHeight()-DIAMETER)){
            game.gameOver();

        }
        //if the ball intersects the racquet
        if(game.racquet.getRacquetBounds().intersects(getBallBounds())){
            //send the ball in opposite direction
            y2=-game.ballSpeed;
            score++;
            game.ballSpeed++;

//            label.setVerticalTextPosition(JLabel.LEFT);

        }

        this.x=this.x+x2;
        this.y=this.y+y2;

    }

    public void drawBall(Graphics graphics){

        Graphics2D graphics2D= (Graphics2D) graphics;
        graphics2D.setColor(Color.RED);

        graphics2D.fillOval(x, y, DIAMETER, DIAMETER);


    }
    public Rectangle getBallBounds(){

        return new Rectangle(x,y,DIAMETER,DIAMETER);
    }

}
