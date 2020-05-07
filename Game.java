/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/**
 *
 * @author Yves
 */
public class Game extends Frame implements KeyListener {

    Game(Frame frame) {     

        super.removeAll();          //removes the buttons
        super.addKeyListener(this); //adds the keylistener of player
        repaint();
        startGame = true;    //starts the game
        timer.start(); 
        addPlayer();
        addVirus();

    }

    public void addPlayer() {   // x , y, moveSpeed
        player = new Player(500, 350, 10);
    }

    public void addVirus() { // x , y, moveSpeed ,player
        virus = new Virus(player.x, player.y, 10, player);
    }

    @Override
    public void keyTyped(KeyEvent ea) { //returns to main menu when a key is pressed after gameover
        if (player.collision) {
            gameOver();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {    //moves player
        int key = e.getKeyCode();
        if (!player.collision) {
            if (key == KeyEvent.VK_UP) {
                player.moveUp();
            }
            if (key == KeyEvent.VK_DOWN) {
                player.moveDown();
            }
            if (key == KeyEvent.VK_LEFT) {
                player.moveLeft();
            }
            if (key == KeyEvent.VK_RIGHT) {
                player.moveRight();
            }
            repaint();
        } 
    }

    @Override
    public void keyReleased(KeyEvent ea) {      //returns player to front/idle frame when key is released
        player.imgSrcNumber = 0;
        player.moveAnimationCounter = 0;
        repaint();
    }

    int score = 0;
    int counter = 0;
    Timer timer = new Timer(delay, new ActionListener() {   //timer that moves the virus and increments score
        @Override
        public void actionPerformed(ActionEvent e) {
            score();
            virus.moveVirus();
            virus.checkCollision();
            repaint();
            if (player.collision) {     
                timer.stop();
            }
        }
    });

    public void score() {   //counts score and increments virus movement speed 
        if (counter == 10) {
            score++;
            counter = 0;
            virus.movementSpeed++;
        }
        counter++;
        player.score = String.valueOf(score);
    }

    public void gameOver() {    //returns to main menu
        super.dispose();
        new Frame();
    }
}
