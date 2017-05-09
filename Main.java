package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Main extends JPanel {


    Ball ball = new Ball(this);
     int ballSpeed=1;
    Racquet racquet = new Racquet(this);


    public Main() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //when key pressed send notification to:
                racquet.KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.KeyReleased(e);
            }
        });
        //make focusable
        setFocusable(true);

        //addkeylistenr


    }

    public int getScore(){
        return ballSpeed-1;

    }


    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);
        //draw our ball
        ball.drawBall(graphics);

        //draw racquet
        racquet.drawRacquet(graphics);


        //draw score
        Graphics2D graphics2D= (Graphics2D) graphics;
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font("Arial",Font.BOLD,30));
        graphics2D.drawString(String.valueOf(getScore()),10,30);

    }

    public void update() {


        //update the ball's position.
        ball.updateBall();
        //update racquet
        racquet.updateRacquet();

    }

    //method to terminate game once ball reaches getHeight()
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Score: "+getScore(), "Game Over", JOptionPane.YES_NO_OPTION);

//        JOptionPane.show
                System.exit(ABORT);
//        ball=new Ball(this);
//        racquet=new Racquet(this);
//        ballSpeed=1;
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Tennis");
        Main game = new Main();


        frame.setContentPane(game);
//        frame.add(game);
        frame.setSize(300, 400);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Make a new game

        while (true) {
            game.update();
            game.repaint();
            Thread.sleep(10);

        }


    }
}
