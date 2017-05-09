package sample;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Baldeep on 04/04/2017.
 */
public class Racquet {

    private static final int WIDTH=60;
    private static final int HEIGHT=10;
    private static final int Y=300;
    private int x = 0;

    private int x2 = 0;

    private Main game;


    public Racquet(Main game) {
        //pass in game to have access to the screen width and height
        this.game = game;


    }

    //Code to update the ball position.
    public void updateRacquet() {


        //ch
        if (this.x+x2 < game.getWidth() - 60 && this.x+x2 > 0) {
            this.x = this.x + x2;
        }


    }

    public void drawRacquet(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.BLACK);

        graphics2D.fillRect(x, Y, WIDTH, HEIGHT);


    }

    public void KeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x2 = -game.ballSpeed;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            x2 = game.ballSpeed;

    }

    public void KeyReleased(KeyEvent e) {
        //The moment key is released we don't want to move anymore. Since while loop is infinite make
        //x2=0 so it won't move.
        x2 = 0;


    }

    //Bounds for collision detection
    public Rectangle getRacquetBounds(){
        return new Rectangle(x,Y,WIDTH,HEIGHT);
    }




}


