package Game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Player {

    Frame frame;
    BufferedImage image;
    int x;
    int y;
    int movementSpeed;
    boolean collision = false;
    int imgSrcNumber = 0;
    int moveAnimationCounter = 0;
    String score = "0";

    //image source
    String[] imgSrc = new String[]{"src\\Player\\Front1.png", "src\\Player\\Front2.png", "src\\Player\\Front3.png",
        "src\\Player\\Left1.png", "src\\Player\\Left2.png", "src\\Player\\Left3.png",
        "src\\Player\\Right1.png", "src\\Player\\Right2.png", "src\\Player\\Right3.png",
        "src\\Player\\Back1.png", "src\\Player\\Back2.png", "src\\Player\\Back3.png"};

    Player(int x, int y, int movementSpeed) {
        this.x = x;
        this.y = y;
        this.movementSpeed = movementSpeed;
    }

    public void paintPlayer(Graphics g) {   //draws player
        getImageSrc(imgSrc[imgSrcNumber]);
        g.drawImage(image, x, y, null);

    }

    public void moveUp() { //moves player up
        y -= movementSpeed;
        switch (moveAnimationCounter) {//changes the animation of player when mooving
            case 0:
                imgSrcNumber = 9;
                moveAnimationCounter++;
                break;
            case 2:
                imgSrcNumber = 10;
                moveAnimationCounter++;
                break;
            case 4:
                imgSrcNumber = 11;
                moveAnimationCounter++;
                break;
            case 6:
                moveAnimationCounter = 0;
                break;
            default:
                moveAnimationCounter++;
                break;
        }
        if (y < -50) { //returns player to the screen when moving outside
            y = 660;
        }
    }

    public void moveDown() {
        y += movementSpeed;
        switch (moveAnimationCounter) {
            case 0:
                imgSrcNumber = 0;
                moveAnimationCounter++;
                break;
            case 2:
                imgSrcNumber = 1;
                moveAnimationCounter++;
                break;
            case 4:
                imgSrcNumber = 2;
                moveAnimationCounter++;
                break;
            case 6:
                moveAnimationCounter = 0;
                break;
            default:
                moveAnimationCounter++;
                break;
        }
        if (y > 660) {
            y = -50;
        }
    }

    public void moveLeft() {
        x -= movementSpeed;
        switch (moveAnimationCounter) {
            case 0:
                imgSrcNumber = 3;
                moveAnimationCounter++;
                break;
            case 2:
                imgSrcNumber = 4;
                moveAnimationCounter++;
                break;
            case 4:
                imgSrcNumber = 5;
                moveAnimationCounter++;
                break;
            case 6:
                moveAnimationCounter = 0;
                break;
            default:
                moveAnimationCounter++;
                break;
        }
        if (x < -30) {
            x = 950;
        }
    }

    public void moveRight() {
        x += movementSpeed;
        switch (moveAnimationCounter) {
            case 0:
                imgSrcNumber = 6;
                moveAnimationCounter++;
                break;
            case 2:
                imgSrcNumber = 7;
                moveAnimationCounter++;
                break;
            case 4:
                imgSrcNumber = 8;
                moveAnimationCounter++;
                break;
            case 6:
                moveAnimationCounter = 0;
                break;
            default:
                moveAnimationCounter++;
                break;
        }
        if (x > 950) {
            x = -30;
        }
    }

    public Rectangle playerHitbox() {   //creates a rectangle for the hitbox of player
        return (new Rectangle(x + 15, y + 10, 55, 90));
    }

    public void drawScore(Graphics g) { //draws the game time/score
        g.setFont(new Font("Courier", Font.PLAIN, 50));
        g.drawString(score, 500, 100);
    }

    public void getImageSrc(String source) {   //insert path of image when called
        try {
            image = ImageIO.read(new File(source));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
