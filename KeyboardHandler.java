package sample;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Baldeep on 04/04/2017.
 */
public class KeyboardHandler extends JPanel {

    public KeyboardHandler() {

        //initialize listener object for racquet 1.
        KeyListener keyListener = new keyListener(){
            public void keyTyped(KeyEvent e) {


            }

            public void keyPressed(KeyEvent e) {


            }


            public void keyReleased(KeyEvent e) {


            }


        };
        //make focusable
        setFocusable(true);

        //addkeylistenr
        addKeyListener(keyListener);

        //for p2 make another key listener class for which we modify methods for corresponding behavior.

    }

//create keylistener class

    public class keyListener implements KeyListener {

        public void keyTyped(KeyEvent e) {


        }

        public void keyPressed(KeyEvent e) {


        }


        public void keyReleased(KeyEvent e) {


        }


    }


}
